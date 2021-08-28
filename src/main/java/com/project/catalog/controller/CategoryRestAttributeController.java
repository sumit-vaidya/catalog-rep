package com.project.catalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.catalog.model.CategoryAttributesDTO;
import com.project.catalog.service.ICategoryAttributeService;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class CategoryRestAttributeController {
	
	private static final Logger logger = LogManager.getLogger(CategoryRestAttributeController.class);
	
	@Autowired
	private ICategoryAttributeService  service;

	@GetMapping(value="/v1/catalog/category/attribute/fetch", produces="application/json")
	public ResponseEntity<List<CategoryAttributesDTO>>  findAllCategoryAttribute() {	
		logger.info("FR-INFO Method  CategoryRestAttributeController.findAllCategoryAttribute");
		List<CategoryAttributesDTO>  recipesDTOList=service.findAllCategoryAttribute();
		return new ResponseEntity<List<CategoryAttributesDTO>>(recipesDTOList, HttpStatus.OK);		
	}
	
	@PostMapping(value="/v1/catalog/category/attribute/add", consumes="application/json", produces="text/plain")
	public String addCategoryAttribute(@RequestBody CategoryAttributesDTO categoryAttributeDTO) {
		logger.info("FR-INFO Method  CategoryRestAttributeController.addCategoryAttribute");
		return service.addCategoryAttribute(categoryAttributeDTO);		
	}
	
	@DeleteMapping(value="/v1/catalog/category/attribute/delete/{id}")
	public String deleteCategoryAttribute(@PathVariable Integer id) {
		logger.info("FR-INFO Method  CategoryRestAttributeController.deleteCategoryAttribute : "+ id);
		return service.deleteCategoryAttribute(id);
	}
}
