package io.mercury.redstone.core.order.specific;

import org.slf4j.Logger;

import io.mercury.financial.instrument.Instrument;
import io.mercury.redstone.core.order.OrderOutputText;
import io.mercury.redstone.core.order.enums.OrdType;
import io.mercury.redstone.core.order.enums.TrdAction;
import io.mercury.redstone.core.order.enums.TrdDirection;
import io.mercury.redstone.core.order.structure.OrdPrice;
import io.mercury.redstone.core.order.structure.OrdQty;
import io.mercury.redstone.core.order.structure.TrdList;
import io.mercury.redstone.core.order.structure.TrdRecord;

/**
 * 实际执行订单的最小执行单元, 可能根据合规, 账户情况等由ParentOrder拆分出多个ChildOrder
 * 
 * @author yellow013
 * @creation 2018年1月14日
 */
public final class ChildOrder extends ActualOrder {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3863592977001402228L;
	/**
	 * 子订单成交列表
	 */
	private final TrdList trdList;

	public ChildOrder(int strategyId, int subAccountId, Instrument instrument, OrdQty ordQty, OrdPrice ordPrice,
			OrdType ordType, TrdDirection direction, TrdAction action, long ownerOrdId) {
		super(strategyId, subAccountId, instrument, ordQty, ordPrice, ordType, direction, action, ownerOrdId);
		this.trdList = new TrdList(ordSysId());
	}

	@Override
	public int ordLevel() {
		return 0;
	}

	public TrdList trdList() {
		return trdList;
	}

	public TrdRecord lastTrdRecord() {
		return trdList.last().get();
	}

	@Override
	public void outputLog(Logger log, String objName, String msg) {
		log.info(OrderOutputText.ChildOrderOutputText, objName, msg, ordSysId(), ownerOrdId(), ordStatus(), direction(),
				action(), ordType(), instrument(), ordPrice(), ordQty(), ordTimestamp(), trdList);
	}

}
