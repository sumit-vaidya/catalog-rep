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

import com.project.catalog.model.ProductDTO;
import com.project.catalog.service.IProductService;

@RestController
public class ProductRestController {
	
	private static final Logger logger = LogManager.getLogger(ProductRestController.class);
	
	@Autowired
	private IProductService  service;

	@GetMapping(value="/v1/catalog/product/fetch", produces="application/json")
	public ResponseEntity<List<ProductDTO>>  findAllProducts() {	
		logger.info("FR-INFO Method  ProductRestController.findAllProducts");
		List<ProductDTO> productDTOList=service.findAllProducts();
		return new ResponseEntity<List<ProductDTO>>(productDTOList, HttpStatus.OK);		
	}
	
	@PostMapping(value="/v1/catalog/product/add", consumes="application/json", produces="text/plain")
	public String addProduct(@RequestBody ProductDTO productDTO) {
		logger.info("FR-INFO Method  ProductRestController.addProduct");
		return service.addProduct(productDTO);		
	}
	
	@DeleteMapping(value="/v1/catalog/product/delete/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		logger.info("FR-INFO Method  ProductRestController.deleteProduct : "+ id);
		return service.deleteProduct(id);
	}
}
