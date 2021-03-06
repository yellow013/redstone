package io.cygnus.restful.service.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.cygnus.repository.entity.InstrumentSettlementEntity;
import io.cygnus.repository.service.InstrumentService;
import io.cygnus.restful.service.base.CygRestfulApi;
import io.cygnus.service.dto.LastPrice;
import io.mercury.common.annotation.cache.GetCache;

@RestController("/instrument")
public class InstrumentRestfulApi extends CygRestfulApi {

	@Resource
	private InstrumentService instrumentDao;

	/**
	 * Get SettlementPrice
	 * 
	 * @param instrumentId
	 * @param tradingDay
	 * @return
	 */
	@GetMapping("/settlement_price")
	public ResponseEntity<List<InstrumentSettlementEntity>> getSettlementPrice(@RequestParam("instrumentId") String instrumentId,
			@RequestParam("tradingDay") String tradingDay) {
		if (checkParamIsNull(instrumentId, tradingDay)) {
			return httpBadRequest();
		}
		Date dateTradingDay = null;
		if (tradingDay != null) {
			dateTradingDay = changeTradingDay(tradingDay);
			if (dateTradingDay == null) {
				return httpBadRequest();
			}
		}

		List<InstrumentSettlementEntity> settlementPrices = instrumentDao.
				getInstrumentSettlement(instrumentId, dateTradingDay);
		return jsonResponse(settlementPrices);
	}

	// LastPrices Cache
	private static ConcurrentHashMap<String, LastPrice> lastPriceMap = new ConcurrentHashMap<>();

	/**
	 * Get LastPrices
	 * 
	 * @param instrumentsStr
	 * @return
	 */
	@GetMapping("/last_price")
	@GetCache
	public ResponseEntity<Object> getLastPrice(@RequestParam("instrumentIds") String instrumentIdArrayStr) {
		if (instrumentIdArrayStr == null || instrumentIdArrayStr.equals("")) {
			return httpBadRequest();
		}
		List<LastPrice> lastPrices = new ArrayList<>();
		String[] instrumentIds = instrumentIdArrayStr.split(",");
		for (String instrumentId : instrumentIds) {
			LastPrice lastPrice;
			if (lastPriceMap.containsKey(instrumentId)) {
				lastPrice = lastPriceMap.get(instrumentId);
			} else {
				lastPrice = new LastPrice().setInstrumentId(instrumentId);
			}
			lastPrices.add(lastPrice);
		}
		return jsonResponse(lastPrices);
	}

	/**
	 * Put LastPrice
	 * 
	 * @param request
	 * @return
	 */
	@PutMapping("/last_price")
	public ResponseEntity<Object> putLastPrice(@RequestBody HttpServletRequest request) {
		String json = getBody(request);
		if (json == null) {
			return httpBadRequest();
		}
		LastPrice lastPrice = jsonToObj(json, LastPrice.class);
		lastPriceMap.put(lastPrice.getInstrumentId(), lastPrice);
		return httpOk();
	}

}
