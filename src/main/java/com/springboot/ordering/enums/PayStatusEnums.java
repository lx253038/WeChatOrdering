package com.springboot.ordering.enums;

/**
 * 支付状态
 */

public enum PayStatusEnums implements CodeEnums<Integer> {
    NEW(0, "未支付"),
    FINISH(1, "已支付");

    private Integer code;

    private String msg;

    PayStatusEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
