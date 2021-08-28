package com.project.catalog.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.catalog.model.ProductDTO;
import com.project.catalog.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Override
	public List<ProductDTO> findAllProducts() {
		return null;
	}

	@Override
	public String addProduct(ProductDTO productDTO) {
		return null;
	}

	@Override
	public String deleteProduct(Integer id) {
		return null;
	}

}
