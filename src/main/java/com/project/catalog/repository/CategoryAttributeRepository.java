package com.project.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.catalog.entity.CategoryAttributes;

@Repository	
public interface CategoryAttributeRepository extends JpaRepository<CategoryAttributes, Integer> {

	CategoryAttributes findByAttributeName(String attributeName);

}
