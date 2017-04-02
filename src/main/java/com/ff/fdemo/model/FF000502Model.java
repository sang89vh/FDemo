package com.ff.fdemo.model;

import java.math.BigInteger;

public class FF000502Model extends FFBaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8570734987871959139L;
	private String SYMBOL;
	private Long INCOME;
	private Long EXPENSES;
	public String getSYMBOL() {
		return SYMBOL;
	}
	public void setSYMBOL(String symbol) {
		this.SYMBOL = symbol;
	}
	public Long getINCOME() {
		return INCOME;
	}
	public void setINCOME(Long income) {
		this.INCOME = income;
	}
	public Long getEXPENSES() {
		return EXPENSES;
	}
	public void setEXPENSES(Long expenses) {
		this.EXPENSES = expenses;
	}
	

}
