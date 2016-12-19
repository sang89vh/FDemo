package com.ff.fdemo.model;

public class FF000402Model  extends FFBaseModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7241211868856531845L;
	private Long company_id;
	private String name;
	private Long total_years_activity;
	private Long point;
	private String domain;
	private String listed_date;
	private String symbol;
	private String status;
	public Long getCompany_id() {
		return company_id;
	}
	public void setCompany_id(Long company_id) {
		this.company_id = company_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getTotal_years_activity() {
		return total_years_activity;
	}
	public void setTotal_years_activity(Long total_years_activity) {
		this.total_years_activity = total_years_activity;
	}
	public Long getPoint() {
		return point;
	}
	public void setPoint(Long point) {
		this.point = point;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getListed_date() {
		return listed_date;
	}
	public void setListed_date(String listed_date) {
		this.listed_date = listed_date;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
