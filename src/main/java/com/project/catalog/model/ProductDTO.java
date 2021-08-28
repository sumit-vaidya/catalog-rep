package com.project.catalog.model;

import java.io.Serializable;

public class ProductDTO implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6661756240952427463L;

	private Integer productId;

	private String productName;

	private CategoryDTO category;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}
	
	
	
}
