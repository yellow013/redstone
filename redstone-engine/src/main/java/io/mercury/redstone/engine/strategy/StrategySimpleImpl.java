package io.mercury.redstone.engine.strategy;

import org.eclipse.collections.api.list.ImmutableList;

import io.mercury.common.collections.ImmutableLists;
import io.mercury.common.param.map.ImmutableParamMap;
import io.mercury.financial.instrument.Instrument;
import io.mercury.financial.market.api.MarketData;
import io.mercury.redstone.core.adaptor.Adaptor;
import io.mercury.redstone.core.adaptor.AdaptorEvent;
import io.mercury.redstone.core.strategy.StrategyParamKey;

public abstract class StrategySimpleImpl<M extends MarketData, P extends StrategyParamKey>
		extends StrategyBaseImpl<M, P> {

	// 策略订阅的合约
	protected Instrument instrument;

	/**
	 * 策略订阅的合约列表
	 */
	protected ImmutableList<Instrument> instruments;

	protected StrategySimpleImpl(int strategyId, String strategyName, int subAccountId, Instrument instrument,
			ImmutableParamMap<P> param) {
		super(strategyId, strategyName, subAccountId, param);
		this.instrument = instrument;
		this.instruments = ImmutableLists.newList(instrument);
	}

	@Override
	public ImmutableList<Instrument> instruments() {
		return instruments;
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

	@Override
	public void onAdaptorEvent(AdaptorEvent event) {
		log.info("{} :: On adaptor status callback, adaptorId==[{}], status==[{}]", strategyName(), event.adaptorId(),
				event.adaptorStatus());
		switch (event.adaptorStatus()) {
		case MdEnable:
			log.info("{} :: Handle adaptor MdEnable, adaptorId==[{}]", strategyName(), event.adaptorId());
			adaptor.subscribeMarketData(instrument);
			log.info("{} :: Call subscribeMarketData, instrument -> {}", strategyName(), instrument);
			break;
		case TraderEnable:
			log.info("{} :: Handle adaptor TdEnable, adaptorId==[{}]", strategyName(), event.adaptorId());
			adaptor.queryOrder(instrument);
			log.info("{} :: Call queryOrder, adaptodId==[{}], account is default", strategyName(), event.adaptorId());
			adaptor.queryPositions(instrument);
			log.info("{} :: Call queryPositions, adaptodId==[{}], account is default", strategyName(),
					event.adaptorId());
			adaptor.queryBalance();
			log.info("{} :: Call queryBalance, adaptodId==[{}], account is default", strategyName(), event.adaptorId());
			break;
		default:
			break;
		}
	}

}
