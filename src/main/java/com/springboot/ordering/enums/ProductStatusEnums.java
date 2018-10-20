package com.springboot.ordering.enums;

/**
 * ��Ʒ״̬
 */
public enum ProductStatusEnums {
    UP(1, "�ڼ�"),
    DOWN(0, "�¼�");

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
