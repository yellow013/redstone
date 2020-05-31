package io.mercury.ftdc.gateway;

import io.mercury.ftdc.gateway.bean.FtdcDepthMarketData;
import io.mercury.ftdc.gateway.bean.FtdcInputOrder;
import io.mercury.ftdc.gateway.bean.FtdcInputOrderAction;
import io.mercury.ftdc.gateway.bean.FtdcMdConnect;
import io.mercury.ftdc.gateway.bean.FtdcOrder;
import io.mercury.ftdc.gateway.bean.FtdcOrderAction;
import io.mercury.ftdc.gateway.bean.FtdcTrade;
import io.mercury.ftdc.gateway.bean.FtdcTraderConnect;

public final class FtdcRspMsg {

	private RspType rspType;

	// 返回交易接口连接信息
	private FtdcTraderConnect ftdcTraderConnect;
	// 返回行情接口连接信息
	private FtdcMdConnect ftdcMdConnect;

	// 返回行情
	private FtdcDepthMarketData ftdcDepthMarketData;

	// 报单推送
	private FtdcOrder ftdcOrder;
	// 成交推送
	private FtdcTrade ftdcTrade;

	// 返回报单错误
	private FtdcInputOrder ftdcInputOrder;
	// 返回撤单错误
	private FtdcInputOrderAction ftdcInputOrderAction;
	// 返回撤单错误
	private FtdcOrderAction ftdcOrderAction;

	public FtdcRspMsg(FtdcTraderConnect ftdcTraderConnect) {
		this.rspType = RspType.FtdcTraderConnect;
		this.ftdcTraderConnect = ftdcTraderConnect;
	}

	public FtdcRspMsg(FtdcMdConnect ftdcMdConnect) {
		this.rspType = RspType.FtdcMdConnect;
		this.ftdcMdConnect = ftdcMdConnect;
	}

	public FtdcRspMsg(FtdcDepthMarketData ftdcDepthMarketData) {
		this.rspType = RspType.FtdcDepthMarketData;
		this.ftdcDepthMarketData = ftdcDepthMarketData;
	}

	public FtdcRspMsg(FtdcOrder ftdcOrder) {
		this.rspType = RspType.FtdcOrder;
		this.ftdcOrder = ftdcOrder;
	}

	public FtdcRspMsg(FtdcTrade ftdcTrade) {
		this.rspType = RspType.FtdcTrade;
		this.ftdcTrade = ftdcTrade;
	}

	public FtdcRspMsg(FtdcInputOrder ftdcInputOrder) {
		this.rspType = RspType.FtdcInputOrder;
		this.ftdcInputOrder = ftdcInputOrder;
	}

	public FtdcRspMsg(FtdcInputOrderAction ftdcInputOrderAction) {
		this.rspType = RspType.FtdcInputOrderAction;
		this.ftdcInputOrderAction = ftdcInputOrderAction;
	}

	public FtdcRspMsg(FtdcOrderAction ftdcOrderAction) {
		this.rspType = RspType.FtdcOrderAction;
		this.ftdcOrderAction = ftdcOrderAction;
	}

	public RspType getRspType() {
		return rspType;
	}

	public FtdcDepthMarketData getFtdcDepthMarketData() {
		return ftdcDepthMarketData;
	}

	public FtdcTraderConnect getFtdcTraderConnect() {
		return ftdcTraderConnect;
	}

	public FtdcMdConnect getRspMdConnect() {
		return ftdcMdConnect;
	}

	public FtdcOrder getFtdcOrder() {
		return ftdcOrder;
	}

	public FtdcTrade getFtdcTrade() {
		return ftdcTrade;
	}

	public FtdcInputOrder getFtdcInputOrder() {
		return ftdcInputOrder;
	}

	public FtdcInputOrderAction getFtdcInputOrderAction() {
		return ftdcInputOrderAction;
	}

	public FtdcOrderAction getFtdcOrderAction() {
		return ftdcOrderAction;
	}

	public static enum RspType {

		FtdcDepthMarketData,

		FtdcTraderConnect,

		FtdcMdConnect,

		FtdcOrder,

		FtdcTrade,

		FtdcInputOrder,

		FtdcInputOrderAction,

		FtdcOrderAction,

		Other,

		;

	}

}
