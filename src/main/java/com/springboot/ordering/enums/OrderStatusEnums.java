package com.springboot.ordering.enums;

/**
 * 订单状态
 */

public enum OrderStatusEnums implements CodeEnums<Integer> {
    NEW(0, "新订单"),
    FINISH(1, "完成订单"),
    CANCEL(2, "取消订单");

    private Integer code;

    private String msg;

    OrderStatusEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
