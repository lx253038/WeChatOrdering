package com.springboot.ordering.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springboot.ordering.dto.OrderDTO;
import com.springboot.ordering.model.OrderMaster;

public interface OrderService {


    //��������
    OrderDTO create(OrderDTO orderDTO);

    //��ѯ��������
    OrderDTO findOne(String orderId);

    //��ѯ�����б�
    Page<OrderMaster> findList(String openid, Pageable pageable);

    //ȡ������
    OrderDTO cancel(OrderDTO orderDTO);

    //��ᶩ��
    OrderDTO finish(OrderDTO orderDTO);

    //֧������
    OrderDTO pay(OrderDTO orderDTO);

    //��ѯ���ж����б�
    Page<OrderMaster> listAll(Pageable pageable);

}
