package io.ffreedom.redstone.core.order;

import io.ffreedom.redstone.core.order.enums.OrdStatus;

public final class OrderReport {

	private long ordSysId;
	private long epochMilliseconds;
	private OrdStatus ordStatus;
	/**
	 * 
	 */
	private String borkerReturnId;
	/**
	 * 
	 */
	private double filledQty;
	/**
	 * 
	 */
	private double leavesQty;

	private double execPrice;

	public long getOrdSysId() {
		return ordSysId;
	}

	public OrderReport setOrdSysId(long ordSysId) {
		this.ordSysId = ordSysId;
		return this;
	}

	public long getEpochMilliseconds() {
		return epochMilliseconds;
	}

	public OrderReport setEpochMilliseconds(long epochMilliseconds) {
		this.epochMilliseconds = epochMilliseconds;
		return this;
	}

	public OrdStatus getOrdStatus() {
		return ordStatus;
	}

	public OrderReport setOrdStatus(OrdStatus ordStatus) {
		this.ordStatus = ordStatus;
		return this;
	}

	public String getBorkerReturnId() {
		return borkerReturnId;
	}

	public OrderReport setBorkerReturnId(String borkerReturnId) {
		this.borkerReturnId = borkerReturnId;
		return this;
	}

	public double getFilledQty() {
		return filledQty;
	}

	public OrderReport setFilledQty(double filledQty) {
		this.filledQty = filledQty;
		return this;
	}

	public double getLeavesQty() {
		return leavesQty;
	}

	public OrderReport setLeavesQty(double leavesQty) {
		this.leavesQty = leavesQty;
		return this;
	}

	public double getExecPrice() {
		return execPrice;
	}

	public OrderReport setExecPrice(double execPrice) {
		this.execPrice = execPrice;
		return this;
	}

}