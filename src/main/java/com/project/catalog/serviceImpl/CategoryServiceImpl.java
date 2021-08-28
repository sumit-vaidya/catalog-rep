package com.project.catalog.serviceImpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.catalog.model.CategoryDTO;
import com.project.catalog.repository.CategoryRepository;
import com.project.catalog.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {

	private static final Logger logger = LogManager.getLogger(CategoryServiceImpl.class);

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<CategoryDTO> findAllCategory() {
		return null;
	}

	@Override
	public String addCategory(CategoryDTO categoryDTO) {
		return null;
	}

	@Override
	public String deleteCategory(Integer id) {
		return null;
	}

}
