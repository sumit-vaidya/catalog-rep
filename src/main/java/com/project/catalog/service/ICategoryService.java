package com.project.catalog.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.project.catalog.exception.CategoryNotFoundException;
import com.project.catalog.model.CategoryDTO;
import com.project.catalog.model.SelectedCategoryAttributesDTO;

public interface ICategoryService {

	List<CategoryDTO> findAllCategory();

	String addCategory(CategoryDTO categoryDTO);

	String deleteCategory(Integer id);

	CategoryDTO findCategoryById(Integer id) throws CategoryNotFoundException;

	List<SelectedCategoryAttributesDTO> findCategoryAttributesById(Integer id) throws CategoryNotFoundException;

}
