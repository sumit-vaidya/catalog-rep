package com.project.catalog.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.catalog.entity.CategoryAttributes;
import com.project.catalog.model.CategoryAttributeDTO;
import com.project.catalog.repository.CategoryAttributeRepository;
import com.project.catalog.service.ICategoryAttributeService;

@Service
public class CategoryAttributeServiceImpl implements ICategoryAttributeService {

	private static final Logger logger = LogManager.getLogger(CategoryAttributeServiceImpl.class);

	@Autowired
	private CategoryAttributeRepository attributeRepository;

	@Override
	public String addCategoryAttribute(CategoryAttributeDTO categoryAttributeDTO) {
		logger.info("FR-INFO Method  CategoryAttributeServiceImpl.addCategoryAttribute");
		// Formation of Category Attribute object to store in the Category Attribute
		// table of database
		CategoryAttributes categoryAttributes = new CategoryAttributes();
		BeanUtils.copyProperties(categoryAttributeDTO, categoryAttributes);

		CategoryAttributes findCategoryAttributes = attributeRepository
				.findByAttributeName(categoryAttributes.getAttributeName());

		if (findCategoryAttributes != null && findCategoryAttributes.getAttributeId() != 0) {
			return "Category already exists";
		} else {
			attributeRepository.save(categoryAttributes);
			return "Category is added to database";
		}
	}

	@Override
	public List<CategoryAttributeDTO> findAllCategoryAttribute() {
		logger.info("FR-INFO Method  CategoryAttributeServiceImpl.findAllCategoryAttribute");
		List<CategoryAttributes> categoryAttributesList = attributeRepository.findAll();

		List<CategoryAttributeDTO> categoryAttributeDTOList = categoryAttributesList.stream()
				.map(categoryAttributeDTO -> new CategoryAttributeDTO(categoryAttributeDTO.getAttributeId(),
						categoryAttributeDTO.getAttributeName(), categoryAttributeDTO.getAttributeValue()))
				.collect(Collectors.toList());

		return categoryAttributeDTOList;
	}

}
