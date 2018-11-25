package com.springboot.ordering.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springboot.ordering.model.OrderDetail;
import com.springboot.ordering.model.ProductInfo;

public interface ProductInfoService {
    ProductInfo findOne(String id);

    Page<ProductInfo> listAll(Pageable pageable);

    List<ProductInfo> findByProductStatus(Integer state);

    List<ProductInfo> findByCategoryType(Integer state);

    ProductInfo save(ProductInfo productInfo);

    //ɾ��
    void delete(String id);
    //�ӿ��
    void increaseStock(List<OrderDetail> orderDetails);


    //�����
    void decreaseStock(List<OrderDetail> orderDetails);
}
