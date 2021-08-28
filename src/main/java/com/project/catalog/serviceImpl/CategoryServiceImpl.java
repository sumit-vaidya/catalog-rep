package com.project.catalog.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.catalog.entity.Category;
import com.project.catalog.entity.CategoryAttributes;
import com.project.catalog.entity.SelectedCategoryAttributes;
import com.project.catalog.exception.CategoryNotFoundException;
import com.project.catalog.model.CategoryDTO;
import com.project.catalog.model.SelectedCategoryAttributesDTO;
import com.project.catalog.repository.CategoryRepository;
import com.project.catalog.service.ICategoryService;
import com.project.catalog.util.CatalogErrorCode;
import com.project.catalog.util.CatalogResponse;

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
			categoryRepository.saveAndFlush(category);
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

	@Override
	public CategoryDTO findCategoryById(Integer id) throws CategoryNotFoundException {
		logger.info("FR-INFO Method  CategoryServiceImpl.findCategoryById : " + id);
		CategoryDTO categoryDTO = new CategoryDTO();
		try {
			Optional<Category> category = categoryRepository.findById(id);

			// if search criteria is not matched then throwing user defined exception
			if (category == null) {
				CategoryNotFoundException asException = new CategoryNotFoundException();
				CatalogResponse errorResponse = new CatalogResponse();
				logger.error(
						"LYT-ERROR Method CategoryServiceImpl.findCategoryById : Search criteria doesn't meet... ");
				errorResponse.setErrorMsg("Search criteria doesn't meet...");
				errorResponse.setErrorCode(CatalogErrorCode.ERR_SEARCH_NOT_FOUND);
				asException.setCatalogResponse(errorResponse);
			}
			categoryDTO.setCategoryId(category.get().getCategoryId());
			categoryDTO.setCategoryName(category.get().getCategoryName());
			List<SelectedCategoryAttributesDTO> categoryAttributes = category.get().getCategoryAttributes().stream()
					.map(item -> new SelectedCategoryAttributesDTO(item.getSelectedAttributeId(),
							item.getSelectedAttributeName(), item.getSelectedAttributeValue()))
					.collect(Collectors.toList());
			categoryDTO.setCategoryAttributes(categoryAttributes);

		} catch (Exception e) {
			CategoryNotFoundException asException = new CategoryNotFoundException();
			CatalogResponse errorResponse = new CatalogResponse();
			logger.error("LYT-ERROR Method CategoryServiceImpl.findCategoryById " + e, e);
			errorResponse.setErrorMsg("Something went wrong while searching");
			errorResponse.setErrorCode(CatalogErrorCode.ERR_SEARCH_PROCESSING);
			asException.setCatalogResponse(errorResponse);
			throw asException;
		}
		return categoryDTO;
	}

	@Override
	public List<SelectedCategoryAttributesDTO> findCategoryAttributesById(Integer id) throws CategoryNotFoundException {
		logger.info("FR-INFO Method  CategoryServiceImpl.findCategoryAttributesById : " + id);
		List<SelectedCategoryAttributesDTO> categoryAttributes = new ArrayList<>();
		try {
			Optional<Category> category = categoryRepository.findById(id);

			// if search criteria is not matched then throwing user defined exception
			if (category == null) {
				CategoryNotFoundException asException = new CategoryNotFoundException();
				CatalogResponse errorResponse = new CatalogResponse();
				logger.error(
						"LYT-ERROR Method CategoryServiceImpl.findCategoryById : Search criteria doesn't meet... ");
				errorResponse.setErrorMsg("Search criteria doesn't meet...");
				errorResponse.setErrorCode(CatalogErrorCode.ERR_SEARCH_NOT_FOUND);
				asException.setCatalogResponse(errorResponse);
			}			
			categoryAttributes = category.get().getCategoryAttributes().stream()
					.map(item -> new SelectedCategoryAttributesDTO(item.getSelectedAttributeId(),
							item.getSelectedAttributeName(), item.getSelectedAttributeValue()))
					.collect(Collectors.toList());

		} catch (Exception e) {
			CategoryNotFoundException asException = new CategoryNotFoundException();
			CatalogResponse errorResponse = new CatalogResponse();
			logger.error("LYT-ERROR Method CategoryServiceImpl.findCategoryById " + e, e);
			errorResponse.setErrorMsg("Something went wrong while searching");
			errorResponse.setErrorCode(CatalogErrorCode.ERR_SEARCH_PROCESSING);
			asException.setCatalogResponse(errorResponse);
			throw asException;
		}
		return categoryAttributes;
	}

}
