package com.project.catalog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SelectedCategoryAttributes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "selectedAttributeId", updatable = false, nullable = false)
	private Integer selectedAttributeId;

	@Column(length = 30)
	private String selectedAttributeName;
	
	@Column(length = 30)
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
