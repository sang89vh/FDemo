package com.ff.fdemo.model;

import java.text.ParseException;
import java.util.Date;

import com.ff.fdemo.utils.FFUtils;

public class FF0000Model extends FFBaseModel{


	private static final long serialVersionUID = -8131698370438920674L;
	
	private Long EVENT_RIGHT_ID;
    private String SYMBOL;
    private String EXCHANGE;
    private String EVENT_TYPE;
    private Date RIGHT_DATE;
    private Date REGISTER_DATE;
    private Date ACTION_DATE;
    private String CONTENT;
    private Long EVENT_PERCENT;
    private Long CURRENT_PRICE;
    
    
    private String  EVENTS;
    private String START;
    private String END;
    	
	public Long getEVENT_RIGHT_ID() {
		return EVENT_RIGHT_ID;
	}
	public void setEVENT_RIGHT_ID(Long event_right_id) {
		this.EVENT_RIGHT_ID = event_right_id;
	}
	public String getSYMBOL() {
		return SYMBOL;
	}
	public void setSYMBOL(String symbol) {
		this.SYMBOL = symbol;
	}
	public String getEXCHANGE() {
		return EXCHANGE;
	}
	public void setEXCHANGE(String exchange) {
		this.EXCHANGE = exchange;
	}
	public String getEVENT_TYPE() {
		return EVENT_TYPE;
	}
	public void setEVENT_TYPE(String event_type) {
		this.EVENT_TYPE = event_type;
	}
	public Date getRIGHT_DATE() {
		return RIGHT_DATE;
	}
	public void setRIGHT_DATE(Date right_date) {
		this.RIGHT_DATE = right_date;
	}
	public void setRIGHT_DATE(String str_right_date) {
		try {
			this.RIGHT_DATE = FFUtils.convertDDMMYYToDate(str_right_date);
		} catch (ParseException e) {
			logger.error(e.getMessage(),e);
		}
	}
	public Date getREGISTER_DATE() {
		return REGISTER_DATE;
	}
	public void setREGISTER_DATE(Date register_date) {
		this.REGISTER_DATE = register_date;
	}
	public void setREGISTER_DATE(String register_date) {
		try {
			this.REGISTER_DATE = FFUtils.convertDDMMYYToDate(register_date);
		} catch (ParseException e) {
			logger.error(e.getMessage(),e);
		}
	}
	public Date getACTION_DATE() {
		return ACTION_DATE;
	}
	public void setACTION_DATE(Date action_date) {
		this.ACTION_DATE = action_date;
	}
	public void setACTION_DATE(String action_date) {
		try {
			this.ACTION_DATE = FFUtils.convertDDMMYYToDate(action_date);
		} catch (ParseException e) {
			logger.error(e.getMessage(),e);
		}
	}
	public String getCONTENT() {
		return CONTENT;
	}
	public void setCONTENT(String content) {
		this.CONTENT = content;
	}
	public Long getEVENT_PERCENT() {
		return EVENT_PERCENT;
	}
	public void setEVENT_PERCENT(Long event_percent) {
		this.EVENT_PERCENT = event_percent;
	}
	public Long getCURRENT_PRICE() {
		return CURRENT_PRICE;
	}
	public void setCURRENT_PRICE(Long current_price) {
		this.CURRENT_PRICE = current_price;
	}
	public String getEVENTS() {
		return EVENTS;
	}
	public void setEVENTS(String events) {
		this.EVENTS = events;
	}
	public String getSTART() {
		return START;
	}
	public void setSTART(String start) {
		this.START = start;
	}
	public String getEND() {
		return END;
	}
	public void setEND(String end) {
		this.END = end;
	}
    
    

}
