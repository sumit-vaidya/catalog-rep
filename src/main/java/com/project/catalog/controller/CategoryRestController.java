package com.project.catalog.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.catalog.model.CategoryDTO;
import com.project.catalog.service.ICategoryService;

@RestController
public class CategoryRestController {
	
	private static final Logger logger = LogManager.getLogger(CategoryRestController.class);
	
	@Autowired
	private ICategoryService  service;

	@GetMapping(value="/v1/catalog/category/fetch", produces="application/json")
	public ResponseEntity<List<CategoryDTO>>  findAllCategory() {	
		logger.info("FR-INFO Method  CategoryRestController.findAllCategory");
		List<CategoryDTO> categoryDTOList=service.findAllCategory();
		return new ResponseEntity<List<CategoryDTO>>(categoryDTOList, HttpStatus.OK);		
	}
	
	@PostMapping(value="/v1/catalog/category/add", consumes="application/json", produces="text/plain")
	public String addCategory(@RequestBody CategoryDTO categoryDTO) {
		logger.info("FR-INFO Method  CategoryRestController.addCategory");
		return service.addCategory(categoryDTO);		
	}
	
	@DeleteMapping(value="/v1/catalog/category/delete/{id}")
	public String deleteCategory(@PathVariable Integer id) {
		logger.info("FR-INFO Method  CategoryRestController.deleteCategory : "+ id);
		return service.deleteCategory(id);
	}
}
