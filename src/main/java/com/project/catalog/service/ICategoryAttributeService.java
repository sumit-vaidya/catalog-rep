package com.project.catalog.service;

import java.util.List;

import com.project.catalog.model.CategoryAttributeDTO;

public interface ICategoryAttributeService {

	String addCategoryAttribute(CategoryAttributeDTO categoryAttributeDTO);

	List<CategoryAttributeDTO> findAllCategoryAttribute();

}
