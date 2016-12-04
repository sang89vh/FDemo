package com.ff.fdemo.model;

import java.util.Date;

public class FF0002Model extends FFBaseModel {
	private static final long serialVersionUID = 2461837578780051992L;
	private Long his_price_id;
	private String symbol;
	private Date trading_date;
	private Long open_price;
	private Long high_price;
	private Long low_price;
	private Long close_price;
	private Long volume;
	private String market;
	public Long getHis_price_id() {
		return his_price_id;
	}
	public void setHis_price_id(Long his_price_id) {
		this.his_price_id = his_price_id;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Date getTrading_date() {
		return trading_date;
	}
	public void setTrading_date(Date trading_date) {
		this.trading_date = trading_date;
	}
	public Long getOpen_price() {
		return open_price;
	}
	public void setOpen_price(Long open_price) {
		this.open_price = open_price;
	}
	public Long getHigh_price() {
		return high_price;
	}
	public void setHigh_price(Long high_price) {
		this.high_price = high_price;
	}
	public Long getLow_price() {
		return low_price;
	}
	public void setLow_price(Long low_price) {
		this.low_price = low_price;
	}
	public Long getClose_price() {
		return close_price;
	}
	public void setClose_price(Long close_price) {
		this.close_price = close_price;
	}
	public Long getVolume() {
		return volume;
	}
	public void setVolume(Long volume) {
		this.volume = volume;
	}
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	
	
	
	
	
}
