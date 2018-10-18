package com.springboot.ordering.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.ordering.model.ProductCategory;
import com.springboot.ordering.model.ProductInfo;

public interface ProductInfoRepository extends JpaRepository<ProductInfo,Integer> {
    List<ProductInfo> findByProductStatus(Integer state);
    ProductInfo findByProductId(String projectId);
}
