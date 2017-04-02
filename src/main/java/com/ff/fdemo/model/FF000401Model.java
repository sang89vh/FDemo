package com.ff.fdemo.model;

import java.text.ParseException;
import java.util.Date;

import org.springframework.util.StringUtils;

import com.ff.fdemo.utils.FFUtils;

public class FF000401Model extends FFBaseModel{
	private static final long serialVersionUID = 6701294248863642769L;
	private String COMPANY;
	private String COMPANYNAME;
	private String  COMPANYNAMEENG;
	private String  DELISTEDDATE;
	private String FLOOR;
	private Long ID;
	private String INDEXCODE;
	private String INSDUSTRYNAME;
	private String LISTEDDATE;
	private Date LISTED_DATE;
	private String OBJECT;
	private String SHORTNAME;
	private String STATUS;
	private String SYMBOL;
	public String getCOMPANY() {
		return COMPANY;
	}
	public void setCOMPANY(String company) {
		this.COMPANY = company;
	}
	public String getCOMPANYNAME() {
		return COMPANYNAME;
	}
	public void setCOMPANYNAME(String companyName) {
		this.COMPANYNAME = companyName;
	}
	public String getCOMPANYNAMENG() {
		return COMPANYNAMEENG;
	}
	public void setCOMPANYNAMEENG(String companyNameEng) {
		this.COMPANYNAMEENG = companyNameEng;
	}
	public String getDELISTEDDATE() {
		return DELISTEDDATE;
	}
	public void setDELISTEDDATE(String delistedDate) {
		this.DELISTEDDATE = delistedDate;
	}
	public String getFLOOR() {
		return FLOOR;
	}
	public void setFLOOR(String floor) {
		this.FLOOR = floor;
	}
	public Long getID() {
		return ID;
	}
	public void setID(Long id) {
		this.ID = id;
	}
	public String getINDEXCODE() {
		return INDEXCODE;
	}
	public void setINDEXCODE(String indexCode) {
		this.INDEXCODE = indexCode;
	}
	public String getINDUSTRYNAME() {
		return INSDUSTRYNAME;
	}
	public void setINDUSTRYNAME(String industryName) {
		this.INSDUSTRYNAME = industryName;
	}
	public String getLISTEDDATE() {
		return LISTEDDATE;
	}
	public void setLISTEDDATE(String listedDate) {
		try {
			LISTED_DATE = FFUtils.convertYYYY_MM_DDToDate(listedDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.LISTEDDATE = listedDate;
	}
	public String getOBJECT() {
		return OBJECT;
	}
	public void setOBJECT(String object) {
		this.OBJECT = object;
	}
	public String getSHORTNAME() {
		return SHORTNAME;
	}
	public void setSHORTNAME(String shortName) {
		this.SHORTNAME = shortName;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String status) {
		this.STATUS = status;
	}
	public String getSYMBOL() {
		return SYMBOL;
	}
	public void setSYMBOL(String symbol) {
		this.SYMBOL = symbol.trim();
	}
	public Date getLISTED_DATE() {
		return LISTED_DATE;
	}
	public void setLISTED_DATE(Date listed_date) {
		this.LISTED_DATE = listed_date;
	}
	
}
