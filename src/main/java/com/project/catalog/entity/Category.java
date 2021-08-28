package com.project.catalog.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "categoryId", updatable = false, nullable = false)
	private Integer categoryId;

	@Column(length = 30)
	private String categoryName;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name="CATEGORYID_FK")
	private List<SelectedCategoryAttributes> categoryAttributes = new ArrayList<>();

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

	public List<SelectedCategoryAttributes> getCategoryAttributes() {
		return categoryAttributes;
	}

	public void setCategoryAttributes(List<SelectedCategoryAttributes> categoryAttributes) {
		this.categoryAttributes = categoryAttributes;
	}
	
}
