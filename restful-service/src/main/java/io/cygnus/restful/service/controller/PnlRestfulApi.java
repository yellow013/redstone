package io.cygnus.restful.service.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.cygnus.persistence.entity.StrategyInstrumentPNLDaily;
import io.cygnus.persistence.entity.StrategyInstrumentPNLSettlementDaily;
import io.cygnus.repository.service.PnlService;
import io.cygnus.restful.service.base.CygRestfulApi;

@RestController("/pnl")
public class PnlRestfulApi extends CygRestfulApi {

	/**
	 * 查询PNL
	 * 
	 * @param strategyId
	 * @param tradingDay
	 * @return
	 */
	@GetMapping
	public ResponseEntity<Object> getPnlDailys(@RequestParam("tradingDay") String tradingDay,
			@RequestParam("strategyId") Integer strategyId) {
		if (checkParamIsNull(tradingDay)) {
			return httpBadRequest();
		}
		Date dateTradingDay = changeTradingDay(tradingDay);
		if (dateTradingDay == null) {
			return httpBadRequest();
		}
		PnlService dao = new PnlService();
		List<StrategyInstrumentPNLDaily> pnlDailys = dao.queryPnlDailys(tradingDay, strategyId);
		return jsonResponse(pnlDailys);
	}

	/**
	 * Put PnlDaily
	 * 
	 * @param request
	 * @return
	 */
	@PutMapping
	public ResponseEntity<Object> putPnlDailys(@RequestBody HttpServletRequest request) {
		String json = getBody(request);
		if (checkParamIsNull(json)) {
			return httpBadRequest();
		}
		StrategyInstrumentPNLDaily pnlDaily = jsonToObj(json, StrategyInstrumentPNLDaily.class);
		PnlService dao = new PnlService();
		dao.addOrUpdatePnlDailys(pnlDaily);
		return httpOk();
	}

	/**
	 * 查询结算PNL
	 * 
	 * @param strategyId
	 * @param tradingDay
	 * @return
	 */
	@GetMapping("/settlement")
	public ResponseEntity<Object> getPnlSettlementDailys(@RequestParam("tradingDay") String tradingDay,
			@RequestParam("strategyId") Integer strategyId) {
		if (checkParamIsNull(tradingDay)) {
			return httpBadRequest();
		}
		Date dateTradingDay = changeTradingDay(tradingDay);
		if (dateTradingDay == null) {
			return httpBadRequest();
		}
		PnlService dao = new PnlService();
		List<StrategyInstrumentPNLSettlementDaily> pnlSettlementDailys = dao.queryPnlSettlementDailys(dateTradingDay,
				strategyId);
		return jsonResponse(pnlSettlementDailys);
	}

}
