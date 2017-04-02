package com.ff.fdemo.model;

public class FF000402Model  extends FFBaseModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7241211868856531845L;
	private Long COMPANY_ID;
	private String NAME;
	private Long TOTAL_YEARS_ACTIVITY;
	private Long POINT;
	private String DOMAIN;
	private String LISTED_DATE;
	private String SYMBOL;
	private String STATUS;
	public Long getCOMPANY_ID() {
		return COMPANY_ID;
	}
	public void setCOMPANY_ID(Long company_id) {
		this.COMPANY_ID = company_id;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String name) {
		this.NAME = name;
	}
	public Long getTOTAL_YEARS_ACTIVITY() {
		return TOTAL_YEARS_ACTIVITY;
	}
	public void setTOTAL_YEARS_ACTIVITY(Long total_years_activity) {
		this.TOTAL_YEARS_ACTIVITY = total_years_activity;
	}
	public Long getPOINT() {
		return POINT;
	}
	public void setPOINT(Long point) {
		this.POINT = point;
	}
	public String getDOMAIN() {
		return DOMAIN;
	}
	public void setDOMAIN(String domain) {
		this.DOMAIN = domain;
	}
	public String getLISTED_DATE() {
		return LISTED_DATE;
	}
	public void setLISTED_DATE(String listed_date) {
		this.LISTED_DATE = listed_date;
	}
	public String getSYMBOL() {
		return SYMBOL;
	}
	public void setSYMBOL(String symbol) {
		this.SYMBOL = symbol;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String status) {
		this.STATUS = status;
	}
	
	
}
