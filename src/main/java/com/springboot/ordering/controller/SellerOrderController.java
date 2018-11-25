package com.springboot.ordering.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.ordering.dto.OrderDTO;
import com.springboot.ordering.model.OrderDetail;
import com.springboot.ordering.model.OrderMaster;
import com.springboot.ordering.service.OrderService;

/**
 * 卖家端订单管理
 *
 * @author LX
 * @date 2018-11-20 20:22
 */
@Controller
@RequestMapping("/seller/order")
public class SellerOrderController {
    @Autowired
    OrderService orderService;

    //分页查询所有订单
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "5") Integer size, Map<String, Object> map) {
        PageRequest request = PageRequest.of(page - 1, size);
        Page<OrderMaster> pageOrder = orderService.listAll(request);
        map.put("orderList", pageOrder);
        map.put("nowPage", page);
        return new ModelAndView("order/list", map);
    }

    //取消订单
    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam(value = "orderId") String orderId, Map<String, Object> map) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        orderService.cancel(orderDTO);
        map.put("msg", "订单取消订单成功！");
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/infoMsg", map);
    }

    //查询订单详情
    @GetMapping("/orderDetail")
    public ModelAndView orderDetail(@RequestParam(value = "orderId") String orderId, Map<String, Object> map) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        List<OrderDetail> orderDetails = orderDTO.getOrderDetails();
        map.put("orderDTO", orderDTO);
        map.put("orderDetails", orderDetails);
        return new ModelAndView("order/detail", map);

    }

    //完结订单
    @GetMapping("/orderFinish")
    public ModelAndView finish(@RequestParam(value = "orderId") String orderId, Map<String, Object> map) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        orderService.finish(orderDTO);

        map.put("msg", "订单已完结");
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/infoMsg", map);

    }

}
