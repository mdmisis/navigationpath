package com.cd.mx.model;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class PurchaseTrackingMessage extends BasicTrackingMessage {

	
	private String purchaseId;
	private float shippingsCosts;
	private float shippingsCostsMp;
	private float costsReduce;
	private float giftCard;
	private  List<PurchaseProductSheet>  listProducts;
	
	
	private String orderType;
	private String evar31;
	private String title;
	private String postalCode;
	private String city;
	private String evar36;
	private String paymentType;

	
	
	



	


	

	@Override
	public EventType getEventType() {
		// TODO Auto-generated method stub
		return EventType.PURCHASE;
	}

	public String getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}

	public float getShippingsCosts() {
		return shippingsCosts;
	}

	public void setShippingsCosts(float shippingsCosts) {
		this.shippingsCosts = shippingsCosts;
	}

	public float getShippingsCostsMp() {
		return shippingsCostsMp;
	}

	public void setShippingsCostsMp(float shippingsCostsMp) {
		this.shippingsCostsMp = shippingsCostsMp;
	}

	public float getCostsReduce() {
		return costsReduce;
	}

	public void setCostsReduce(float costsReduce) {
		this.costsReduce = costsReduce;
	}

	public float getGiftCard() {
		return giftCard;
	}

	public void setGiftCard(float giftCard) {
		this.giftCard = giftCard;
	}

	public List<PurchaseProductSheet> getListProducts() {
		return listProducts;
	}

	public void setListProducts(List<PurchaseProductSheet> listProducts) {
		this.listProducts = listProducts;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getEvar31() {
		return evar31;
	}

	public void setEvar31(String evar31) {
		this.evar31 = evar31;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEvar36() {
		return evar36;
	}

	public void setEvar36(String evar36) {
		this.evar36 = evar36;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	
	
}
