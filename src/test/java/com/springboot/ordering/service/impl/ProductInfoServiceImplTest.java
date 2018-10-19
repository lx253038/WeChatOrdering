package com.springboot.ordering.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.ordering.model.ProductInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    ProductInfoServiceImpl service;

    @Test
    public void findOne() {
        ProductInfo one = service.findOne("1001");
        System.out.println(one);
    }

    @Test
    public void listAll() {
        PageRequest request = new PageRequest(0, 2);
        Page<ProductInfo> productInfos = service.listAll(request);
        System.out.println(productInfos.getTotalElements());
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> infos = service.findByProductStatus(1);
        System.out.println(infos.size());

    }

    @Test
    public void save() {
        ProductInfo p1=new ProductInfo("1001","∑Ω±„√Ê",new BigDecimal(13.0),20,"1111","c:/icon",1,1);
        ProductInfo p2=new ProductInfo("1002","ªÕ»≥¶",new BigDecimal(3.5),100,"ªÕ»≥¶6666","c:/icon",1,11);
        ProductInfo p3=new ProductInfo();
        p3.setProductId("1004");
        p3.setProductName("÷ΩΩÌ");
        p3.setProductPrice(new BigDecimal(16.0));
        p3.setProductStock(300);
        p3.setProductDescription("÷ΩΩÌ6666");
        p3.setProductStatus(1);
        p3.setCategoryType(14);
        service.save(p1);
        service.save(p2);
        service.save(p3);
    }
}