package com.ff.fdemo.model;


public class FF000503Model extends FFBaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3368248173313834073L;
	private String symbol;
	private Long value;
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Long getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value.longValue();
	}

}
