package com.springboot.ordering.service;

import java.util.List;

import com.springboot.ordering.model.ProductInfo;

public interface ProductInfoService {
    ProductInfo findOne(String id);

    List<ProductInfo> listAll();

    List<ProductInfo> findByProductStatus(Integer state);

    ProductInfo save(ProductInfo productInfo);
}
