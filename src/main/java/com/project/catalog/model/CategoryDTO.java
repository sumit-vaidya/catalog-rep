package com.project.catalog.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CategoryDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3633733673015173326L;

	private Integer categoryId;

	private String categoryName;
	
	private List<SelectedCategoryAttributesDTO> categoryAttributes = new ArrayList<>();	
	
	public CategoryDTO() {
		
	}
	
	public CategoryDTO(Integer categoryId, String categoryName,
			List<SelectedCategoryAttributesDTO> categoryAttributes) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryAttributes = categoryAttributes;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<SelectedCategoryAttributesDTO> getCategoryAttributes() {
		return categoryAttributes;
	}

	public void setCategoryAttributes(List<SelectedCategoryAttributesDTO> categoryAttributes) {
		this.categoryAttributes = categoryAttributes;
	}
	
}
