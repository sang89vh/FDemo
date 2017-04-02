package com.ff.fdemo.model;

import org.springframework.util.StringUtils;

public class FF000001Model extends FFBaseModel {

	private static final long serialVersionUID = -26626542025190420L;

	private String ID;
	private String RESOURCEID;
	// "2016-09-07T05:00:00"
	private String START;
	// "2016-09-07T22:00:00";
	private String END;
	private String TITLE;
	private String EVENT_TYPE;
	public String getID() {
		return ID;
	}
	public void setID(String id) {
		this.ID = id;
	}
	public String getRESOURCEID() {
		return RESOURCEID;
	}
	public void setRESOURCEID(String resourceId) {
		this.RESOURCEID = resourceId;
	}
	public String getSTART() {
		return START;
	}
	public void setSTART(String start) {
		this.START = start;
	}
	public String getEND() {
		if(StringUtils.isEmpty(END)){
			return START;
		}
		return END;
	}
	public void setEND(String end) {
		this.END = end;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String title) {
		this.TITLE = title;
	}
	public String getEVENT_TYPE() {
		return EVENT_TYPE;
	}
	public void setEVENT_TYPE(String event_type) {
		this.EVENT_TYPE = event_type;
	}
	
	

}
