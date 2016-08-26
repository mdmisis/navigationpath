package com.cd.mx.model;


import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "eventType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SearchTrackingMessage.class, name = "SEARCH"),
        @JsonSubTypes.Type(value = AddToBasketTrackingMessage.class, name = "ADD_TO_BASKET"),
        @JsonSubTypes.Type(value = ProductSheetTrackingMessage.class, name = "PRODUCT_SHEET"),
        @JsonSubTypes.Type(value = PurchaseTrackingMessage.class, name = "PURCHASE"),
        
})
public abstract class BasicTrackingMessage {
	private String visidHigh;
	private String visidLow;
	private String visitNum;
	private String visitPageNum;
	private String postEvar30;
	private String dateTime;
	private List<String> cookies;
	private List<String> cookiesNoChange;
	private List<String> eventList;
	private String pageEvent;
	private String pageEventVar1;
	private String pageEventVar2;
	private String pageUrl;
	private String referrer;
	private String cleanUrl;
	private String cleanReferrer;
	private String pageName;
	private String prop7;
	private String ip;
	private String postProp59;
	private String postEvar13;
	
	public abstract EventType getEventType();
	public  String getActionIdentifier() {
		return cleanUrl;
	}
	public  String getReferrerActionIdentifier() {
		return cleanReferrer;
	}
	public String getCleanUrl() {
		return cleanUrl;
	}
	public void setCleanUrl(String cleanUrl) {
		this.cleanUrl = cleanUrl;
	}
	public String getCleanReferrer() {
		return cleanReferrer;
	}
	public void setCleanReferrer(String cleanReferrer) {
		this.cleanReferrer = cleanReferrer;
	}
	public String getVisidHigh() {
		return visidHigh;
	}
	public void setVisidHigh(String visidHigh) {
		this.visidHigh = visidHigh;
	}
	public String getVisidLow() {
		return visidLow;
	}
	public void setVisidLow(String visidLow) {
		this.visidLow = visidLow;
	}
	public String getVisitNum() {
		return visitNum;
	}
	public void setVisitNum(String visitNum) {
		this.visitNum = visitNum;
	}
	public String getVisitPageNum() {
		return visitPageNum;
	}
	public void setVisitPageNum(String visitPageNum) {
		this.visitPageNum = visitPageNum;
	}
	public String getPostEvar30() {
		return postEvar30;
	}
	public void setPostEvar30(String postEvar30) {
		this.postEvar30 = postEvar30;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public List<String> getCookies() {
		return cookies;
	}
	public void setCookies(List<String> cookies) {
		this.cookies = cookies;
	}
	public List<String> getCookiesNoChange() {
		return cookiesNoChange;
	}
	public void setCookiesNoChange(List<String> cookiesNoChange) {
		this.cookiesNoChange = cookiesNoChange;
	}
	public List<String> getEventList() {
		return eventList;
	}
	public void setEventList(List<String> eventList) {
		this.eventList = eventList;
	}
	public String getPageEvent() {
		return pageEvent;
	}
	public void setPageEvent(String pageEvent) {
		this.pageEvent = pageEvent;
	}
	public String getPageEventVar1() {
		return pageEventVar1;
	}
	public void setPageEventVar1(String pageEventVar1) {
		this.pageEventVar1 = pageEventVar1;
	}
	public String getPageEventVar2() {
		return pageEventVar2;
	}
	public void setPageEventVar2(String pageEventVar2) {
		this.pageEventVar2 = pageEventVar2;
	}
	public String getPageUrl() {
		return pageUrl;
	}
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	public String getReferrer() {
		return referrer;
	}
	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPostProp59() {
		return postProp59;
	}
	public void setPostProp59(String postProp59) {
		this.postProp59 = postProp59;
	}
	public String getPostEvar13() {
		return postEvar13;
	}
	public void setPostEvar13(String postEvar13) {
		this.postEvar13 = postEvar13;
	}
	public String getProp7() {
		return prop7;
	}
	public void setProp7(String prop7) {
		this.prop7 = prop7;
	}
	
	
}
