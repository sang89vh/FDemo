package com.ff.fdemo.model;

import java.math.BigInteger;

public class FF000502Model extends FFBaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8570734987871959139L;
	private String symbol;
	private BigInteger income;
	private BigInteger expenses;
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public BigInteger getIncome() {
		return income;
	}
	public void setIncome(BigInteger income) {
		this.income = income;
	}
	public BigInteger getExpenses() {
		return expenses;
	}
	public void setExpenses(BigInteger expenses) {
		this.expenses = expenses;
	}
	

}
