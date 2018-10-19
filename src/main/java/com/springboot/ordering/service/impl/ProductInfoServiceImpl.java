package com.springboot.ordering.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.ordering.model.ProductInfo;
import com.springboot.ordering.repository.ProductInfoRepository;
import com.springboot.ordering.service.ProductInfoService;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String id) {
        return repository.findByProductId(id);
    }

    @Override
    public Page<ProductInfo> listAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<ProductInfo> findByProductStatus(Integer states) {
        return repository.findByProductStatus(states);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }
}
