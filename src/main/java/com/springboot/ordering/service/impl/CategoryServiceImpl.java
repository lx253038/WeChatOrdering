package com.springboot.ordering.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ordering.model.ProductCategory;
import com.springboot.ordering.repository.ProductCategoryRepository;
import com.springboot.ordering.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    ProductCategoryRepository  repository;

    @Override
    public ProductCategory findOne(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public List<ProductCategory> listAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> list) {
        return repository.findByCategoryTypeIn(list);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
