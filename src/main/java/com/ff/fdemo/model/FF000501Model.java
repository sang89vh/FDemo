package com.ff.fdemo.model;

import java.util.Date;

public class FF000501Model extends FFBaseModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8639442104533676538L;
	private String TRADING_CODE;
	private String SYMBOL;
	private Long VOLUME;
	private Long BUY;
	private Long SELL;
	private Long TAX;
	private Long FEE;
	private Long MARGIN;
	public String getTRADING_CODE() {
		return TRADING_CODE;
	}
	public void setTRADING_CODE(String trading_code) {
		this.TRADING_CODE = trading_code;
	}
	
	public String getSYMBOL() {
		return SYMBOL;
	}
	public void setSYMBOL(String symbol) {
		this.SYMBOL = symbol;
	}
	public Long getVOLUME() {
		return VOLUME;
	}
	public void setVOLUME(Double volume) {
		this.VOLUME = volume.longValue();
	}
	
	public Long getBUY() {
		return BUY;
	}
	public void setBUY(Double buy) {
		if(buy == null){
			buy =0d;
		}
		this.BUY = buy.longValue();
	}
	public Long getSELL() {
		return SELL;
	}
	public void setSELL(Double sell) {
		if(sell == null){
			sell =0d;
		}
		this.SELL = sell.longValue();
	}
	public Long getTAX() {
		return TAX;
	}
	public void setTAX(Double tax) {
		this.TAX = tax.longValue();
	}
	public Long getFEE() {
		return FEE;
	}
	public void setFEE(Double fee) {
		this.FEE = fee.longValue();
	}
	public Long getMARGIN() {
		return MARGIN;
	}
	public void setMARGIN(Long mARGIN) {
		MARGIN = mARGIN;
	}
	
	
	

}
