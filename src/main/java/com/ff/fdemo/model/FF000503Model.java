package com.ff.fdemo.model;


public class FF000503Model extends FFBaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3368248173313834073L;
	private String SYMBOL;
	private Long VALUE;
	public String getSYMBOL() {
		return SYMBOL;
	}
	public void setSYMBOL(String symbol) {
		this.SYMBOL = symbol;
	}
	public Long getVALUE() {
		return VALUE;
	}
	public void setVALUE(Double value) {
		this.VALUE = value.longValue();
	}

}
