package io.redstone.engine.impl.strategy;

import io.mercury.financial.instrument.Instrument;
import io.mercury.financial.market.api.MarketData;
import io.redstone.core.order.Order;
import io.redstone.core.order.OrderKeeper;
import io.redstone.core.strategy.base.BaseStrategy;

public abstract class IndicatorStrategy<M extends MarketData> extends BaseStrategy<M> {

	protected IndicatorStrategy(int strategyId, int subAccountId, Instrument instrument) {
		super(strategyId, subAccountId, instrument);
	}
	
	@Override
	protected boolean updateOrder(Order order) {
		log.info("handle order ordSysId==[{}]", order.ordSysId());
		if (OrderKeeper.containsOrder(order.ordSysId())) {
			OrderKeeper.updateOrder(order);
		} else {
			OrderKeeper.insertOrder(order);
		}
		return false;
	}

}
