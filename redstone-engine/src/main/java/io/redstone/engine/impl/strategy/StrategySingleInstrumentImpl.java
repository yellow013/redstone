package io.redstone.engine.impl.strategy;

import org.eclipse.collections.api.list.ImmutableList;

import io.mercury.common.collections.ImmutableLists;
import io.mercury.financial.instrument.Instrument;
import io.mercury.financial.market.api.MarketData;
import io.redstone.core.adaptor.Adaptor;
import io.redstone.core.adaptor.Adaptor.AdaptorStatus;
import io.redstone.core.order.enums.OrdType;
import io.redstone.core.order.enums.TrdDirection;

public abstract class StrategySingleInstrumentImpl<M extends MarketData> extends StrategyBaseImpl<M> {

	// 策略订阅的合约
	protected Instrument instrument;

	private ImmutableList<Instrument> instruments;

	protected StrategySingleInstrumentImpl(int strategyId, String strategyName, int subAccountId,
			Instrument instrument) {
		super(strategyId, strategyName, subAccountId);
		this.instrument = instrument;
		this.instruments = ImmutableLists.newList(instrument);
	}

	@Override
	public ImmutableList<Instrument> instruments() {
		return instruments;
	}

	public Instrument instrument() {
		return instrument;
	}

	private Adaptor adaptor;

	@Override
	public void addAdaptor(Adaptor adaptor) {
		this.adaptor = adaptor;
	}

	@Override
	protected Adaptor getAdaptor(Instrument instrument) {
		return adaptor;
	}

	/************************* 做市指令 *******************************/
	/**
	 * 
	 * @param direction
	 * @param targetQty
	 */
	protected void orderWatermark(TrdDirection direction, int targetQty) {
		super.orderWatermark(instrument, direction, targetQty);
	}

	protected void orderWatermark(TrdDirection direction, int targetQty, long limitPrice) {
		super.orderWatermark(instrument, direction, targetQty, limitPrice);
	}

	protected void orderWatermark(TrdDirection direction, int targetQty, long limitPrice, int floatTick) {
		super.orderWatermark(instrument, direction, targetQty, limitPrice, floatTick);
	}

	/**
	 * 
	 * @param ordType
	 * @param offerQty
	 */
	protected void openPositions(TrdDirection direction, OrdType ordType, int offerQty) {
		super.openPositions(instrument, direction, ordType, offerQty);
	}

	/**
	 * 
	 * @param ordType
	 * @param offerQty
	 * @param offerPrice
	 */
	protected void openPositions(TrdDirection direction, OrdType ordType, int offerQty, long offerPrice) {
		super.openPositions(instrument, direction, ordType, offerQty, offerPrice);
	}

	protected void closePositions() {
		super.closeAllPositions(instrument);
	}

	protected void closePositions(int closeQty) {
		super.closePositions(instrument, closeQty);
	}

	@Override
	public void onAdaptorStatus(int adaptorId, AdaptorStatus status) {
		log.info("{} :: On adaptor status callback, adaptorId==[{}], status==[{}]", strategyName(), adaptorId, status);
		switch (status) {
		case MdEnable:
			log.info("{} :: handle adaptor MdEnable, adaptorId==[{}]", strategyName(), adaptorId);
			adaptor.subscribeMarketData(instrument);
			log.info("{} :: call subscribeMarketData, instrument -> {}", strategyName(), instrument);
			break;
		case TraderEnable:
			log.info("{} :: handle adaptor TdEnable, adaptorId==[{}]", strategyName(), adaptorId);
			adaptor.queryOrder(null);
			log.info("{} :: call queryOrder, adaptodId==[{}], account is default", strategyName(), adaptorId);
			adaptor.queryPositions(null);
			log.info("{} :: call queryPositions, adaptodId==[{}], account is default", strategyName(), adaptorId);
			adaptor.queryBalance(null);
			log.info("{} :: call queryBalance, adaptodId==[{}], account is default", strategyName(), adaptorId);
			break;
		default:
			break;
		}
	}

}
