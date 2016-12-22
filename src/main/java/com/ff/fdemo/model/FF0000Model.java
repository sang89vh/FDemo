package com.ff.fdemo.model;

import java.text.ParseException;
import java.util.Date;

import com.ff.fdemo.utils.FFUtils;

public class FF0000Model extends FFBaseModel{


	private static final long serialVersionUID = -8131698370438920674L;
	
	private Long event_right_id;
    private String symbol;
    private String exchange;
    private String event_type;
    private Date right_date;
    private Date register_date;
    private Date action_date;
    private String content;
    private Long event_percent;
    private Long current_price;
    
    
    private String  events;
    private String start;
    private String end;
    	
	public Long getEvent_right_id() {
		return event_right_id;
	}
	public void setEvent_right_id(Long event_right_id) {
		this.event_right_id = event_right_id;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	public String getEvent_type() {
		return event_type;
	}
	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}
	public Date getRight_date() {
		return right_date;
	}
	public void setRight_date(Date right_date) {
		this.right_date = right_date;
	}
	public void setRight_date(String str_right_date) {
		try {
			this.right_date = FFUtils.convertDDMMYYToDate(str_right_date);
		} catch (ParseException e) {
			logger.error(e.getMessage(),e);
		}
	}
	public Date getRegister_date() {
		return register_date;
	}
	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}
	public void setRegister_date(String register_date) {
		try {
			this.register_date = FFUtils.convertDDMMYYToDate(register_date);
		} catch (ParseException e) {
			logger.error(e.getMessage(),e);
		}
	}
	public Date getAction_date() {
		return action_date;
	}
	public void setAction_date(Date action_date) {
		this.action_date = action_date;
	}
	public void setAction_date(String action_date) {
		try {
			this.action_date = FFUtils.convertDDMMYYToDate(action_date);
		} catch (ParseException e) {
			logger.error(e.getMessage(),e);
		}
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getEvent_percent() {
		return event_percent;
	}
	public void setEvent_percent(Long event_percent) {
		this.event_percent = event_percent;
	}
	public Long getCurrent_price() {
		return current_price;
	}
	public void setCurrent_price(Long current_price) {
		this.current_price = current_price;
	}
	public String getEvents() {
		return events;
	}
	public void setEvents(String events) {
		this.events = events;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
    
    

}
