package com.springboot.ordering.convert;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.springboot.ordering.dto.OrderDTO;
import com.springboot.ordering.enums.ExceptionCodeEnums;
import com.springboot.ordering.exception.SellException;
import com.springboot.ordering.form.OrderForm;
import com.springboot.ordering.model.OrderDetail;

/**
 * 买家订单表单转换orderDTO
 */
public class ConvertOrderForm2OrderDTO {

    public static OrderDTO convert(OrderForm orderForm) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        //订单详情
        Gson gson = new Gson();
        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
            throw new SellException(ExceptionCodeEnums.PARAM_ERROR);
        }

        orderDTO.setOrderDetails(orderDetailList);

        return orderDTO;
    }

}
