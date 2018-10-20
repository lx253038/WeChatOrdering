package com.springboot.ordering.enums;


public enum ResultCodeEnums {
    OK(0, "³É¹¦"),
    ERROR(-1, "Ê§°Ü");

    /**
     * ×´Ì¬Âë
     */
    private Integer code;

    /**
     * ×´Ì¬ÂëĞÅÏ¢
     */
    private String msg;

    ResultCodeEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
