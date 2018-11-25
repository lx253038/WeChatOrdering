package com.springboot.ordering.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springboot.ordering.model.ProductCategory;

public interface CategoryService {
    Page<ProductCategory> findAll(Pageable pageable);
    ProductCategory findOne(Integer id);
    List<ProductCategory> listAll();
    List<ProductCategory>  findByCategoryTypeIn(List<Integer> list);

    List<ProductCategory> findByCategoryType(Integer categoryType);
    ProductCategory save(ProductCategory productCategory);

    void delete(Integer id);
}
