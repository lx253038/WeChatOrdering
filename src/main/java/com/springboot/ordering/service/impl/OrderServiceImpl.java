package com.springboot.ordering.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.ordering.dto.OrderDTO;
import com.springboot.ordering.enums.ExceptionCodeEnums;
import com.springboot.ordering.enums.OrderStatusEnums;
import com.springboot.ordering.enums.PayStatusEnums;
import com.springboot.ordering.exception.SellException;
import com.springboot.ordering.model.OrderDetail;
import com.springboot.ordering.model.OrderMaster;
import com.springboot.ordering.model.ProductInfo;
import com.springboot.ordering.repository.OrderDetailRepository;
import com.springboot.ordering.repository.OrderMasterRepository;
import com.springboot.ordering.service.OrderService;
import com.springboot.ordering.service.ProductInfoService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMasterRepository orderMasterRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    ProductInfoService productInfoService;


    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {

        BigDecimal orderSumMoney = new BigDecimal(BigInteger.ZERO);
        String orderId = UUID.randomUUID().toString();
        //1.��ѯ��Ʒ����棬�۸�
        for (OrderDetail detail : orderDTO.getOrderDetails()) {
            ProductInfo productInfo = productInfoService.findOne(detail.getProductId());
            if (productInfo == null) {
                throw new SellException(ExceptionCodeEnums.PRODUCT_NOT_FOUND);
            }
            //2.������Ʒ�����ܼ�
            orderSumMoney = productInfo.getProductPrice().multiply(new BigDecimal(detail.getProductQuantity())).add(orderSumMoney);
            detail.setDetailId(UUID.randomUUID().toString());
            detail.setOrderId(orderId);
            detail.setProductName(productInfo.getProductName());
            detail.setProductPrice(productInfo.getProductPrice());
            detail.setProductIcon(productInfo.getProductIcon());
            orderDetailRepository.save(detail);

        }
        //3.д�붩�����ݿ�
        OrderMaster orderMaster = new OrderMaster();


        orderDTO.setOrderId(orderId);
        orderDTO.setOrderAmount(orderSumMoney);
        orderDTO.setOrderStatus(OrderStatusEnums.NEW.getCode()); //orderstatus:0
        orderDTO.setPayStatus(PayStatusEnums.NEW.getCode());    //payStatus:0
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMasterRepository.save(orderMaster);
        //4.�ۿ��
        productInfoService.decreaseStock(orderDTO.getOrderDetails());
        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        OrderMaster orderMaster = orderMasterRepository.findByOrderId(orderId);
        List<OrderDetail> orderDetails = orderDetailRepository.findByOrderId(orderId);
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        orderDTO.setCreateTime(orderMaster.getCreateTime().getTime() / 1000);
        orderDTO.setUpdateTime(orderMaster.getUpdateTime().getTime() / 1000);
        orderDTO.setOrderDetails(orderDetails);


        return orderDTO;
    }

    @Override
    public Page<OrderMaster> findList(String openid, Pageable pageable) {
        Page<OrderMaster> orderMasters = orderMasterRepository.findByBuyerOpenid(openid, pageable);
        return orderMasters;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        if (orderDTO.getOrderStatus().equals(OrderStatusEnums.NEW.getCode())) {
            throw new SellException(ExceptionCodeEnums.ORDER_STATUS_ERROR);
        }
        //�޸Ķ���״̬
        orderDTO.setOrderStatus(OrderStatusEnums.CANCEL.getCode());
        if (orderDTO.getPayStatus().equals(PayStatusEnums.FINISH.getCode())) {
            //�޸�֧��״̬
            orderDTO.setPayStatus(PayStatusEnums.NEW.getCode());
        }
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMasterRepository.save(orderMaster);

        //�������
        productInfoService.increaseStock(orderDTO.getOrderDetails());
        return orderDTO;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        if (orderDTO.getOrderStatus().equals(OrderStatusEnums.NEW.getCode())) {
            throw new SellException(ExceptionCodeEnums.ORDER_STATUS_ERROR);
        }
        //�޸Ķ���״̬
        orderDTO.setOrderStatus(OrderStatusEnums.FINISH.getCode());

        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMasterRepository.save(orderMaster);
        return orderDTO;

    }

    @Override
    public OrderDTO pay(OrderDTO orderDTO) {


        if (orderDTO.getOrderStatus().equals(OrderStatusEnums.NEW.getCode())) {
            throw new SellException(ExceptionCodeEnums.ORDER_STATUS_ERROR);
        }
        if (orderDTO.getPayStatus().equals(PayStatusEnums.NEW.getCode())) {
            throw new SellException(ExceptionCodeEnums.ORDER_PAY_STATUS_ERROR);
        }

        //�޸Ķ���֧��״̬
        orderDTO.setPayStatus(PayStatusEnums.FINISH.getCode());

        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
