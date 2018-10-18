package com.springboot.ordering.repository;

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
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        ProductCategory category = new ProductCategory();
        category = repository.findById(11).get();
        category.setCategoryName("haodggj活动很好的");
        category.setCategoryType(13);
        System.out.println(category);
        repository.save(category);


        System.out.println(category.getCategoryId());
    }

    @Test
    public void fingByCategory() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        System.out.println(result.size());
    }

}