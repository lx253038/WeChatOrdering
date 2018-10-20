package com.springboot.ordering.enums;


public enum ResultCodeEnums {
    OK(0, "�ɹ�"),
    ERROR(-1, "ʧ��");

    /**
     * ״̬��
     */
    private Integer code;

    /**
     * ״̬����Ϣ
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
