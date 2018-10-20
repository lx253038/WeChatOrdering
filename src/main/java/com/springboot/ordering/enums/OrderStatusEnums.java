package com.springboot.ordering.enums;

/**
 * ����״̬
 */

public enum OrderStatusEnums implements CodeEnums<Integer> {
    NEW(0, "�¶���"),
    FINISH(1, "��ɶ���"),
    CANCEL(2, "ȡ������");

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
