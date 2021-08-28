package com.project.catalog.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.catalog.entity.Category;
import com.project.catalog.entity.CategoryAttributes;
import com.project.catalog.entity.SelectedCategoryAttributes;
import com.project.catalog.model.CategoryDTO;
import com.project.catalog.model.SelectedCategoryAttributesDTO;
import com.project.catalog.repository.CategoryRepository;
import com.project.catalog.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {

	private static final Logger logger = LogManager.getLogger(CategoryServiceImpl.class);

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<CategoryDTO> findAllCategory() {
		logger.info("FR-INFO Method  CategoryServiceImpl.findAllCategory");
		List<Category> categoryList = categoryRepository.findAll();

		List<CategoryDTO> categoryDTOList = categoryList.stream().map(category -> {
			List<SelectedCategoryAttributesDTO> selectedDto = category.getCategoryAttributes().stream()
					.map(obj -> new SelectedCategoryAttributesDTO(obj.getSelectedAttributeId(),
							obj.getSelectedAttributeName(), obj.getSelectedAttributeValue()))
					.collect(Collectors.toList());

			return new CategoryDTO(category.getCategoryId(), category.getCategoryName(), selectedDto);
		}).collect(Collectors.toList());

		return categoryDTOList;
	}

	@Override
	@Transactional
	public String addCategory(CategoryDTO categoryDTO) {
		logger.info("FR-INFO Method  CategoryServiceImpl.addCategory");
		Category category = new Category();

		category.setCategoryId(categoryDTO.getCategoryId());
		category.setCategoryName(categoryDTO.getCategoryName());

		List<SelectedCategoryAttributes> categoryList = categoryDTO.getCategoryAttributes().stream()
				.map(categoryObj -> new SelectedCategoryAttributes(categoryObj.getSelectedAttributeId(),
						categoryObj.getSelectedAttributeName(), categoryObj.getSelectedAttributeValue()))
				.collect(Collectors.toList());

		category.setCategoryAttributes(categoryList);

		CategoryAttributes findCategory = categoryRepository.findByCategoryName(category.getCategoryName());

		if (findCategory != null && findCategory.getAttributeId() != 0) {
			return "Category already exists";
		} else {
			categoryRepository.save(category);
			return "Category is added to database";
		}
	}

	@Override
	public String deleteCategory(Integer id) {
		logger.info("FR-INFO Method  CategoryServiceImpl.deleteCategory : " + id);
		String message = "Category doesn't exist";
		if (categoryRepository.existsById(id)) {
			categoryRepository.deleteById(id);
			message = "Category is deleted from database";
		}
		return message;
	}

}
