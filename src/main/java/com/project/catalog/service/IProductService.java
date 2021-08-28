package com.project.catalog.service;

import java.util.List;

import com.project.catalog.model.ProductDTO;

public interface IProductService {

	List<ProductDTO> findAllProducts();

	String addProduct(ProductDTO productDTO);

	String deleteProduct(Integer id);

}
