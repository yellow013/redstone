package io.redstone.adaptor.simulator;

import io.mercury.common.param.ParamKey;
import io.mercury.common.param.ParamType;

public enum SimAdaptorParams implements ParamKey {

	/**
	 * Simulator Params
	 */
	MdHost(101, ParamType.STRING),

	MdPort(102, ParamType.INT),

	TdHost(103, ParamType.STRING),

	TdPort(104, ParamType.INT),

	StartTradingDay(105, ParamType.DATE),

	EndTradingDay(106, ParamType.DATE),

	;

	private int keyId;

	private ParamType paramType;

	private SimAdaptorParams(int keyId, ParamType paramType) {
		this.keyId = keyId;
		this.paramType = paramType;
	}

	@Override
	public ParamType type() {
		return paramType;
	}

	@Override
	public int id() {
		return keyId;
	}

}
