package com.project.catalog.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.catalog.entity.CategoryAttributes;
import com.project.catalog.model.CategoryAttributesDTO;
import com.project.catalog.repository.CategoryAttributeRepository;
import com.project.catalog.service.ICategoryAttributeService;

@Service
public class CategoryAttributeServiceImpl implements ICategoryAttributeService {

	private static final Logger logger = LogManager.getLogger(CategoryAttributeServiceImpl.class);

	@Autowired
	private CategoryAttributeRepository attributeRepository;

	@Override
	@Transactional
	public String addCategoryAttribute(CategoryAttributesDTO categoryAttributeDTO) {
		logger.info("FR-INFO Method  CategoryAttributeServiceImpl.addCategoryAttribute");		
		CategoryAttributes categoryAttributes = new CategoryAttributes();
		BeanUtils.copyProperties(categoryAttributeDTO, categoryAttributes);

		CategoryAttributes findCategoryAttributes = attributeRepository
				.findByAttributeName(categoryAttributes.getAttributeName());

		if (findCategoryAttributes != null && findCategoryAttributes.getAttributeId() != 0) {
			return "Category Attribute already exists";
		} else {
			attributeRepository.save(categoryAttributes);
			return "Category Attribute is added to database";
		}
	}

	@Override
	public List<CategoryAttributesDTO> findAllCategoryAttribute() {
		logger.info("FR-INFO Method  CategoryAttributeServiceImpl.findAllCategoryAttribute");
		List<CategoryAttributes> categoryAttributesList = attributeRepository.findAll();

		List<CategoryAttributesDTO> categoryAttributeDTOList = categoryAttributesList.stream()
				.map(categoryAttribute -> new CategoryAttributesDTO(categoryAttribute.getAttributeId(),
						categoryAttribute.getAttributeName(), categoryAttribute.getAttributeValue()))
				.collect(Collectors.toList());

		return categoryAttributeDTOList;
	}

	@Override
	public String deleteCategoryAttribute(Integer id) {
		logger.info("FR-INFO Method  CategoryAttributeServiceImpl.deleteCategoryAttribute : "+id);
		String message = "Category Attribute doesn't exist";
		if(attributeRepository.existsById(id)) {
			attributeRepository.deleteById(id);
			message = "Category Attribute is deleted from database";
		}
		return message;
	}

}
