package com.springboot.ordering.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.ordering.enums.ExceptionCodeEnums;
import com.springboot.ordering.exception.SellException;
import com.springboot.ordering.model.OrderDetail;
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
    public List<ProductInfo> findByCategoryType(Integer state) {
        return repository.findByCategoryType(state);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public void increaseStock(List<OrderDetail> orderDetails) {
        for (OrderDetail detail : orderDetails) {
            ProductInfo productInfo = repository.findByProductId(detail.getProductId());
            Integer stock = productInfo.getProductStock() + detail.getProductQuantity();
            productInfo.setProductStock(stock);
            repository.save(productInfo);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<OrderDetail> orderDetails) {
        for (OrderDetail detail : orderDetails) {
            ProductInfo productInfo = repository.findByProductId(detail.getProductId());
            if (productInfo == null) {
                throw new SellException(ExceptionCodeEnums.PRODUCT_NOT_FOUND);
            }
            Integer stock = productInfo.getProductStock() - detail.getProductQuantity();
            if (stock < 0) {
                throw new SellException(ExceptionCodeEnums.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(stock);
            repository.save(productInfo);
        }
    }
}
