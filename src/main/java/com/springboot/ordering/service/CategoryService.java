package com.springboot.ordering.service;

import java.util.List;

import com.springboot.ordering.model.ProductCategory;

public interface CategoryService {
    ProductCategory findOne(Integer id);
    List<ProductCategory> listAll();
    List<ProductCategory>  findByCategoryTypeIn(List<Integer> list);
    ProductCategory save(ProductCategory productCategory);
}
