package com.project.catalog.model;

import java.io.Serializable;

public class CategoryAttributeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8708204339076077515L;
	
	private Integer attributeId;
	private String attributeName;	
	private String attributeValue;
	
	public CategoryAttributeDTO() {}
	
	public CategoryAttributeDTO(Integer attributeId, String attributeName, String attributeValue) {
		super();
		this.attributeId = attributeId;
		this.attributeName = attributeName;
		this.attributeValue = attributeValue;
	}

	public Integer getAttributeId() {
		return attributeId;
	}
	
	public void setAttributeId(Integer attributeId) {
		this.attributeId = attributeId;
	}
	
	public String getAttributeName() {
		return attributeName;
	}
	
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	
	public String getAttributeValue() {
		return attributeValue;
	}
	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}
}
