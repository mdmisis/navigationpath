package com.cd.mx.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class SearchTrackingMessage extends BasicTrackingMessage {

	
	private String query;
	private String searchId;
	private String numberResult;
	private List<Facet> facets;
	private String searchPageNum;
	private String filterCat;
	private ArrayList<String> products;
	
	@Override
	public EventType getEventType() {
		// TODO Auto-generated method stub
		return EventType.SEARCH;
	}
	
	
	
	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getSearchId() {
		return searchId;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	public String getNumberResult() {
		return numberResult;
	}

	public void setNumberResult(String numberResult) {
		this.numberResult = numberResult;
	}

	public List<Facet> getFacets() {
		return facets;
	}

	public void setFacets(List<Facet> facets) {
		this.facets = facets;
	}

	public String getSearchPageNum() {
		return searchPageNum;
	}


	public void setSearchPageNum(String searchPageNum) {
		this.searchPageNum = searchPageNum;
	}

	public String getFilterCat() {
		return filterCat;
	}

	public void setFilterCat(String filterCat) {
		this.filterCat = filterCat;
	}


	public ArrayList<String> getProducts() {
		return products;
	}


	public void setProducts(ArrayList<String> products) {
		this.products = products;
	}


	

	
	
	
	
}
