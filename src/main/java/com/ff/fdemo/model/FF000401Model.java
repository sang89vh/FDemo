package com.ff.fdemo.model;

import java.text.ParseException;
import java.util.Date;

import org.springframework.util.StringUtils;

import com.ff.fdemo.utils.FFUtils;

public class FF000401Model extends FFBaseModel{
	private static final long serialVersionUID = 6701294248863642769L;
	private String company;
	private String companyName;
	private String  companyNameEng;
	private String  delistedDate;
	private String floor;
	private Long id;
	private String indexCode;
	private String industryName;
	private String listedDate;
	private Date listed_date;
	private String object;
	private String shortName;
	private String status;
	private String symbol;
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyNameEng() {
		return companyNameEng;
	}
	public void setCompanyNameEng(String companyNameEng) {
		this.companyNameEng = companyNameEng;
	}
	public String getDelistedDate() {
		return delistedDate;
	}
	public void setDelistedDate(String delistedDate) {
		this.delistedDate = delistedDate;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIndexCode() {
		return indexCode;
	}
	public void setIndexCode(String indexCode) {
		this.indexCode = indexCode;
	}
	public String getIndustryName() {
		return industryName;
	}
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}
	public String getListedDate() {
		return listedDate;
	}
	public void setListedDate(String listedDate) {
		try {
			listed_date = FFUtils.convertYYYY_MM_DDToDate(listedDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.listedDate = listedDate;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol.trim();
	}
	public Date getListed_date() {
		return listed_date;
	}
	public void setListed_date(Date listed_date) {
		this.listed_date = listed_date;
	}
	
}
