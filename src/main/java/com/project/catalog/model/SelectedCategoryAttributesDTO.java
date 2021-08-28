package com.project.catalog.model;

import java.io.Serializable;

public class SelectedCategoryAttributesDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3663327159370445510L;

	private Integer selectedAttributeId;

	private String selectedAttributeName;
	
	private String selectedAttributeValue;

	public Integer getSelectedAttributeId() {
		return selectedAttributeId;
	}

	public void setSelectedAttributeId(Integer selectedAttributeId) {
		this.selectedAttributeId = selectedAttributeId;
	}

	public String getSelectedAttributeName() {
		return selectedAttributeName;
	}

	public void setSelectedAttributeName(String selectedAttributeName) {
		this.selectedAttributeName = selectedAttributeName;
	}

	public String getSelectedAttributeValue() {
		return selectedAttributeValue;
	}

	public void setSelectedAttributeValue(String selectedAttributeValue) {
		this.selectedAttributeValue = selectedAttributeValue;
	}
}
