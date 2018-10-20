package com.springboot.ordering.enums;

/**
 * ֧��״̬
 */

public enum PayStatusEnums implements CodeEnums<Integer> {
    NEW(0, "δ֧��"),
    FINISH(1, "��֧��");

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
