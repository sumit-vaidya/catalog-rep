package com.project.catalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.catalog.model.CategoryAttributeDTO;
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
	public ResponseEntity<List<CategoryAttributeDTO>>  findAllCategoryAttribute() {	
		logger.info("FR-INFO Method  CategoryRestAttributeController.findAllCategoryAttribute");
		List<CategoryAttributeDTO>  recipesDTOList=service.findAllCategoryAttribute();
		return new ResponseEntity<List<CategoryAttributeDTO>>(recipesDTOList, HttpStatus.OK);		
	}
	
	@PostMapping(value="/v1/catalog/category/attribute/add", consumes="application/json", produces="text/plain")
	public String addCategoryAttribute(@RequestBody CategoryAttributeDTO categoryAttributeDTO) {
		logger.info("FR-INFO Method  CategoryRestAttributeController.addCategoryAttribute");
		return service.addCategoryAttribute(categoryAttributeDTO);		
	}	
}
