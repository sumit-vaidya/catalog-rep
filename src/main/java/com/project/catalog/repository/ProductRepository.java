package com.project.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.catalog.entity.Product;

@Repository	
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
