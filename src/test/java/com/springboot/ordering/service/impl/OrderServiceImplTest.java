package com.springboot.ordering.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.ordering.dto.OrderDTO;
import com.springboot.ordering.model.OrderDetail;
import com.springboot.ordering.model.OrderMaster;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

    @Autowired
    OrderServiceImpl service;
    final static String BUYER_OPENID = "110110110";

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerOpenid(BUYER_OPENID);
        orderDTO.setBuyerPhone("123456789012");
        orderDTO.setBuyerAddress("广州从师科技有限公司");
        orderDTO.setBuyerName("范先生11");

        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("1001");
        o1.setProductQuantity(3);

        OrderDetail o2 = new OrderDetail();
        o2.setProductId("1002");
        o2.setProductQuantity(5);


        orderDetailList.add(o1);
        orderDetailList.add(o2);
        orderDTO.setOrderDetails(orderDetailList);

        OrderDTO result = service.create(orderDTO);
        System.out.println(result);

    }

    @Test
    public void findOne() {
        OrderDTO orderDTO = service.findOne("c886214b-6597-42bd-a3b5-064193ccc963");
        System.out.println(orderDTO);
    }

    @Test
    public void findList() {
        PageRequest request = new PageRequest(0, 2);
        Page<OrderMaster> list = service.findList(BUYER_OPENID, request);
        System.out.println(list);
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = service.findOne("c886214b-6597-42bd-a3b5-064193ccc963");
        System.out.println(service.cancel(orderDTO));
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = service.findOne("ffbf7f89-833c-4cb4-aca7-7b26b7978429");
        System.out.println(service.finish(orderDTO));
    }

    @Test
    public void pay() {
        OrderDTO orderDTO = service.findOne("ffbf7f89-833c-4cb4-aca7-7b26b7978429");
        System.out.println(service.pay(orderDTO));
    }
}