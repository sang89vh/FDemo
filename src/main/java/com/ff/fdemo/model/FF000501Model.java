package com.ff.fdemo.model;

import java.util.Date;

public class FF000501Model extends FFBaseModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8639442104533676538L;
	private String trading_code;
	private String buy_sell;
	private String symbol;
	private Long volume;
	private Long value;
	private Long tax;
	private Long fee;
	public String getTrading_code() {
		return trading_code;
	}
	public void setTrading_code(String trading_code) {
		this.trading_code = trading_code;
	}
	public String getBuy_sell() {
		return buy_sell;
	}
	public void setBuy_sell(String buy_sell) {
		this.buy_sell = buy_sell;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Long getVolume() {
		return volume;
	}
	public void setVolume(Double volume) {
		this.volume = volume.longValue();
	}
	public Long getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value.longValue();
	}
	public Long getTax() {
		return tax;
	}
	public void setTax(Double tax) {
		this.tax = tax.longValue();
	}
	public Long getFee() {
		return fee;
	}
	public void setFee(Double fee) {
		this.fee = fee.longValue();
	}
	
	
	

}
