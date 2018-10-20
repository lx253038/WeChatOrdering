package com.springboot.ordering.enums;

/**
 * 商品状态
 */
public enum ProductStatusEnums {
    UP(1, "在架"),
    DOWN(0, "下架");

    private Integer code;

    private String message;

    ProductStatusEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
