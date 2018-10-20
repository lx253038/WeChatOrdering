package com.springboot.ordering.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.ordering.model.OrderMaster;

public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
    OrderMaster findByOrderId(String orderid);

    Page<OrderMaster> findByBuyerOpenid(String openid, Pageable pageable);
}
