package com.springboot.ordering.service.impl;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.ordering.model.ProductCategory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    CategoryServiceImpl service;

    @Test
    public void findOne() {
        ProductCategory category = service.findOne(12);
        System.out.println(category);
    }

    @Test
    public void listAll() {
        List<ProductCategory> list=service.listAll();
        System.out.println(list.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<ProductCategory> result = service.findByCategoryTypeIn(list);
        System.out.println(result.size());
    }

    @Test
    public void save() {
        ProductCategory category=new ProductCategory();

        category.setCategoryType(25);
        category.setCategoryName("Ð¡³Ô");
        service.save(category);
    }
}