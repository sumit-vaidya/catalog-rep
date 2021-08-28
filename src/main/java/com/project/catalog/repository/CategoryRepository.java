package com.project.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.catalog.entity.Category;
import com.project.catalog.entity.CategoryAttributes;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	CategoryAttributes findByCategoryName(String categoryName);

}
