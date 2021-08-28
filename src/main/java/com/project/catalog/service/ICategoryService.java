package com.project.catalog.service;

import java.util.List;

import com.project.catalog.model.CategoryDTO;

public interface ICategoryService {

	List<CategoryDTO> findAllCategory();

	String addCategory(CategoryDTO categoryDTO);

	String deleteCategory(Integer id);

}
