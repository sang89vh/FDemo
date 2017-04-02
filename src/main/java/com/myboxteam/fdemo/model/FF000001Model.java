package com.myboxteam.fdemo.model;

import org.springframework.util.StringUtils;

public class FF000001Model extends FFBaseModel {

	private static final long serialVersionUID = -26626542025190420L;

	private String id;
	private String resourceId;
	// "2016-09-07T05:00:00"
	private String start;
	// "2016-09-07T22:00:00";
	private String end;
	private String title;
	private String event_type;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		if(StringUtils.isEmpty(end)){
			return start;
		}
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEvent_type() {
		return event_type;
	}
	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}
	
	

}
