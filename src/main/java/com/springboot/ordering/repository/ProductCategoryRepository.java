package com.springboot.ordering.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.ordering.model.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    List<ProductCategory> findByCategoryType(Integer categoryType);
}
