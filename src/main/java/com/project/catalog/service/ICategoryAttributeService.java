package com.project.catalog.service;

import java.util.List;

import com.project.catalog.model.CategoryAttributesDTO;

public interface ICategoryAttributeService {

	String addCategoryAttribute(CategoryAttributesDTO categoryAttributeDTO);

	List<CategoryAttributesDTO> findAllCategoryAttribute();

	String deleteCategoryAttribute(Integer id);

}
