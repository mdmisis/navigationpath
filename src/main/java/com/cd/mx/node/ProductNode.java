package com.cd.mx.node;

import com.cd.mx.model.ProductSheetTrackingMessage;
import com.cd.mx.model.SearchTrackingMessage;

public class ProductNode {
	private ProductSheetTrackingMessage pstm;
	private SearchTrackingMessage stm;
	
	
	public ProductNode(ProductSheetTrackingMessage pstm, SearchTrackingMessage stm) {
		super();
		this.pstm = pstm;
		this.stm = stm;
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
