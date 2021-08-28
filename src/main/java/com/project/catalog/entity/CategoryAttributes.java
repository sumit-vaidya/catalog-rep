package com.project.catalog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CategoryAttributes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "attributeId", updatable = false, nullable = false)
	private Integer attributeId;

	@Column(length = 30)
	private String attributeName;
	
	@Column(length = 30)
	private String attributeValue;

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
