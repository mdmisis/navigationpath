package com.cd.mx.model;

import java.util.List;

public class Facet {
	private String id;
	private List<String> values;
	
	
	public Facet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Facet(String id, List<String> values) {
		super();
		this.id = id;
		this.values = values;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getValues() {
		return values;
	}
	public void setValues(List<String> values) {
		this.values = values;
	}

	
	
}
