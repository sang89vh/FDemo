package com.ff.fdemo.model;

import java.util.Date;

import com.ff.fdemo.utils.FFUtils;

public class FF0002Model extends FFBaseModel {
	private static final long serialVersionUID = 2461837578780051992L;
	private Long HIS_PRICE_ID;
	private String SYMBOL;
	private Date TRADING_DATE;
	private String TRADING_DATE_LABEL;
	private Long OPEN_PRICE;
	private Long HIGH_PRICE;
	private Long LOW_PRICE;
	private Long CLOSE_PRICE;
	private Long VOLUME;
	private String MARKET;
	public Long getHIS_PRICE_ID() {
		return HIS_PRICE_ID;
	}
	public void setHIS_PRICE_ID(Long his_price_id) {
		this.HIS_PRICE_ID = his_price_id;
	}
	public String getSYMBOL() {
		return SYMBOL;
	}
	public void setSYMBOL(String symbol) {
		this.SYMBOL = symbol;
	}
	public Date getTRADING_DATE() {
		return TRADING_DATE;
	}
	public void setTRADING_DATE(Date trading_date) {
		this.TRADING_DATE = trading_date;
	}
	
	public String getTRADING_DATE_LABEL() {
		return FFUtils.convertDateToStrSlashDDMMYYY(TRADING_DATE);
	}
	public void setTRADING_DATE_LABEL(String trading_date_label) {
		this.TRADING_DATE_LABEL = trading_date_label;
	}
	public Long getOPEN_PRICE() {
		return OPEN_PRICE;
	}
	public void setOPEN_PRICE(Long open_price) {
		this.OPEN_PRICE = open_price;
	}
	public Long getHIGH_PRICE() {
		return HIGH_PRICE;
	}
	public void setHIGH_PRICE(Long high_price) {
		this.HIGH_PRICE = high_price;
	}
	public Long getLOW_PRICE() {
		return LOW_PRICE;
	}
	public void setLOW_PRICE(Long low_price) {
		this.LOW_PRICE = low_price;
	}
	public Long getCLOSE_PRICE() {
		return CLOSE_PRICE;
	}
	public void setCLOSE_PRICE(Long close_price) {
		this.CLOSE_PRICE = close_price;
	}
	public Long getVOLUME() {
		return VOLUME;
	}
	public void setVOLUME(Long volume) {
		this.VOLUME = volume;
	}
	public String getMARKET() {
		return MARKET;
	}
	public void setMARKET(String market) {
		this.MARKET = market;
	}
	
	
	
	
	
}
