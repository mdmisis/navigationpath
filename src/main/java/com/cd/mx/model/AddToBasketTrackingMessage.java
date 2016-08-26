package com.cd.mx.model;

import java.util.List;



public class AddToBasketTrackingMessage extends BasicTrackingMessage{

	
	private String prop1;
	private String prop2;
	private String prop3;
	private String prop4;
	private String prop5;
	private String prop6;
	
	private String productId;
	private int quantity;
	private float price;

	private String evar45;
	private String evar42;
	private String evar8;
	
	private String sellerType;
	private String seller;
	private String state;
	private List<AddToBasketProductSheet> associateProducts;

	
	@Override
	public EventType getEventType() {
		// TODO Auto-generated method stub
		return EventType.ADD_TO_BASKET;
	}
	
	public  String getActionIdentifier() {
		return productId;
	}

	public String getProp1() {
		return prop1;
	}

	public void setProp1(String prop1) {
		this.prop1 = prop1;
	}

	public String getProp2() {
		return prop2;
	}

	public void setProp2(String prop2) {
		this.prop2 = prop2;
	}

	public String getProp3() {
		return prop3;
	}

	public void setProp3(String prop3) {
		this.prop3 = prop3;
	}

	public String getProp4() {
		return prop4;
	}

	public void setProp4(String prop4) {
		this.prop4 = prop4;
	}

	public String getProp5() {
		return prop5;
	}

	public void setProp5(String prop5) {
		this.prop5 = prop5;
	}

	public String getProp6() {
		return prop6;
	}

	public void setProp6(String prop6) {
		this.prop6 = prop6;
	}

	

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getEvar45() {
		return evar45;
	}

	public void setEvar45(String evar45) {
		this.evar45 = evar45;
	}

	public String getEvar42() {
		return evar42;
	}

	public void setEvar42(String evar42) {
		this.evar42 = evar42;
	}

	public String getEvar8() {
		return evar8;
	}

	public void setEvar8(String evar8) {
		this.evar8 = evar8;
	}

	public String getSellerType() {
		return sellerType;
	}

	public void setSellerType(String sellerType) {
		this.sellerType = sellerType;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<AddToBasketProductSheet> getAssociateProducts() {
		return associateProducts;
	}

	public void setAssociateProducts(List<AddToBasketProductSheet> associateProducts) {
		this.associateProducts = associateProducts;
	}
	
	
	

		
}
