package com.springboot.ordering.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.springboot.ordering.VO.ResultVo;
import com.springboot.ordering.convert.ConvertOrderForm2OrderDTO;
import com.springboot.ordering.dto.OrderDTO;
import com.springboot.ordering.enums.ExceptionCodeEnums;
import com.springboot.ordering.exception.SellException;
import com.springboot.ordering.form.OrderForm;
import com.springboot.ordering.model.OrderMaster;
import com.springboot.ordering.service.OrderService;
import com.springboot.ordering.utils.ResultVoUtil;

@RestController
@RequestMapping("/buyer/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    //下单
    @PostMapping("/create")
    public ResultVo<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new SellException(ExceptionCodeEnums.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = ConvertOrderForm2OrderDTO.convert(orderForm);
        OrderDTO result = orderService.create(orderDTO);
        HashMap<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());
        return ResultVoUtil.success(map);
    }

    //订单列表
    @GetMapping("/list")
    public ResultVo<List<OrderDTO>> list(@RequestParam("openid") String openid, @RequestParam(value = "page", defaultValue = "0") Integer page
            , @RequestParam(value = "size", defaultValue = "2") Integer size) {
        if (StringUtils.isEmpty(openid)) {
            throw new SellException(ExceptionCodeEnums.PARAM_ERROR);
        }
        PageRequest request = PageRequest.of(page, size);
        Page<OrderMaster> orderMastersPage = orderService.findList(openid, request);
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for (OrderMaster vo : orderMastersPage.getContent()) {
            OrderDTO orderDTO = new OrderDTO();
            BeanUtils.copyProperties(vo, orderDTO);
            orderDTO.setCreateTime(vo.getCreateTime().getTime() / 1000);
            orderDTO.setUpdateTime(vo.getUpdateTime().getTime() / 1000);
            orderDTOS.add(orderDTO);
        }

        return ResultVoUtil.success(orderDTOS);
    }

    //订单详情
    @GetMapping("/detail")
    public ResultVo<OrderDTO> list(@RequestParam("openid") String openid, @RequestParam("orderId") String orderId) {
        if (StringUtils.isEmpty(openid) || StringUtils.isEmpty(orderId)) {
            throw new SellException(ExceptionCodeEnums.PARAM_ERROR);
        }

        OrderDTO orderDTO = orderService.findOne(orderId);
        if (!orderDTO.getBuyerOpenid().equals(openid)) {
            throw new SellException(ExceptionCodeEnums.NOT_CURRENT_USER);
        }
        return ResultVoUtil.success(orderDTO);
    }

    //取消订单
    @PostMapping("/cancel")
    public ResultVo cancel(@RequestParam("openid") String openid, @RequestParam("orderId") String orderId) {
        if (StringUtils.isEmpty(openid) || StringUtils.isEmpty(orderId)) {
            throw new SellException(ExceptionCodeEnums.PARAM_ERROR);
        }
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (!orderDTO.getBuyerOpenid().equals(openid)) {
            throw new SellException(ExceptionCodeEnums.NOT_CURRENT_USER);
        }
        orderService.cancel(orderDTO);
        return ResultVoUtil.success();
    }


}
