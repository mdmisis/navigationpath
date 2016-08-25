package com.cd.mx.model;

public class Search extends BasicTrackingMessage{
	public String searchId;

	@Override
	public EventType getEventType() {
		// TODO Auto-generated method stub
		return EventType.Search;
	}

	@Override
	public String getPageUrl() {
		// TODO Auto-generated method stub
		return "lol";
	}
	
}
