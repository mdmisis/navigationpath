package com.cd.mx.node;

import com.cd.mx.model.AddToBasketTrackingMessage;
import com.cd.mx.model.ProductSheetTrackingMessage;
import com.cd.mx.model.SearchTrackingMessage;

public class AddNode {
	private AddToBasketTrackingMessage abtm;
	private ProductSheetTrackingMessage pstm;
	private SearchTrackingMessage stm;
	
	
	
	public AddNode(AddToBasketTrackingMessage abtm, ProductSheetTrackingMessage pstm, SearchTrackingMessage stm) {
		super();
		this.abtm = abtm;
		this.pstm = pstm;
		this.stm = stm;
	}
	
	public AddToBasketTrackingMessage getAbtm() {
		return abtm;
	}
	public void setAbtm(AddToBasketTrackingMessage abtm) {
		this.abtm = abtm;
	}
	public ProductSheetTrackingMessage getPstm() {
		return pstm;
	}
	public void setPstm(ProductSheetTrackingMessage pstm) {
		this.pstm = pstm;
	}
	public SearchTrackingMessage getStm() {
		return stm;
	}
	public void setStm(SearchTrackingMessage stm) {
		this.stm = stm;
	}
	
	

}
