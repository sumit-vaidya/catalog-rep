package com.project.catalog.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.catalog.entity.Category;
import com.project.catalog.entity.Product;
import com.project.catalog.entity.SelectedCategoryAttributes;
import com.project.catalog.model.CategoryDTO;
import com.project.catalog.model.ProductDTO;
import com.project.catalog.model.SelectedCategoryAttributesDTO;
import com.project.catalog.repository.ProductRepository;
import com.project.catalog.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	private static final Logger logger = LogManager.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<ProductDTO> findAllProducts() {
		logger.info("FR-INFO Method  ProductServiceImpl.findAllProducts");
		List<Product> productList = productRepository.findAll();

		List<ProductDTO> productDTOList = productList.stream().map(product -> {			
			Category category = product.getCategory();
			List<SelectedCategoryAttributesDTO> list = category.getCategoryAttributes().stream().map(item -> new SelectedCategoryAttributesDTO(item.getSelectedAttributeId(),item.getSelectedAttributeName(), item.getSelectedAttributeValue())).collect(Collectors.toList());			
			CategoryDTO categoryDTO = new CategoryDTO(category.getCategoryId(), category.getCategoryName(), list);
			return new ProductDTO(product.getProductId(), product.getProductName(), categoryDTO);
		}).collect(Collectors.toList());

		return productDTOList;
	}

	@Override
	@Transactional
	public String addProduct(ProductDTO productDTO) {
		logger.info("FR-INFO Method  ProductServiceImpl.addProduct");
		Product product = new Product();
		product.setProductId(productDTO.getProductId());
		product.setProductName(productDTO.getProductName());
		CategoryDTO categoryDTO = productDTO.getCategory();
		Category category = new Category();
		category.setCategoryId(categoryDTO.getCategoryId());
		category.setCategoryName(categoryDTO.getCategoryName());
		List<SelectedCategoryAttributes> list = categoryDTO.getCategoryAttributes().stream()
				.map(item -> new SelectedCategoryAttributes(item.getSelectedAttributeId(), item.getSelectedAttributeName(), item.getSelectedAttributeValue())).collect(Collectors.toList());
		category.setCategoryAttributes(list);
		product.setCategory(category);

		Product findProduct = productRepository.findByProductName(product.getProductName());

		if (findProduct != null && findProduct.getProductId() != 0) {
			return "Product already exists";
		} else {
			productRepository.save(product);
			return "Product is added to database";
		}
	}

	@Override
	public String deleteProduct(Integer id) {
		logger.info("FR-INFO Method  ProductServiceImpl.deleteProduct : " + id);
		String message = "Product doesn't exist";
		if (productRepository.existsById(id)) {
			productRepository.deleteById(id);
			message = "Product is deleted from database";
		}
		return message;
	}

}
