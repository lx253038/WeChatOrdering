package com.springboot.ordering.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springboot.ordering.model.ProductInfo;

public interface ProductInfoService {
    ProductInfo findOne(String id);

    Page<ProductInfo> listAll(Pageable pageable);

    List<ProductInfo> findByProductStatus(Integer state);

    ProductInfo save(ProductInfo productInfo);
}
