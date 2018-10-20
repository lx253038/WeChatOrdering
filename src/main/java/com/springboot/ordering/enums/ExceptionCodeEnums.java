package com.springboot.ordering.enums;

/**
 * �쳣״̬��
 */

public enum ExceptionCodeEnums {
    PARAM_ERROR(1, "��������ȷ"),

    PRODUCT_NOT_FOUND(10, "δ�ҵ���Ʒ"),

    PRODUCT_STOCK_ERROR(11, "��Ʒ��治��"),

    ORDER_NOT_FOUND(12, "δ�ҵ�����"),

    ORDER_DETAIL_NOT_FOUND(13, "δ�ҵ���������"),

    ORDER_STATUS_ERROR(14, "����״̬����ȷ"),

    ORDER_STATUS_UPDATE_FAIL(15, "����״̬����ʧ��"),

    ORDER_PAY_NOT_FOUND(16, "֧��״̬����ȷ"),

    ORDER_PAY_STATUS_ERROR(17, "����֧��״̬����ȷ"),

    ORDER_PAY_STATUS_UPDATE_FAIL(18, "����֧��״̬����ʧ��"),

    Order_CART_EMPTY(19, "���ﳵΪ��"),

    NOT_CURRENT_USER(20, "���ǵ�ǰ�û�"),

    WECHAT_MP_ERROR(21, "΢����ҳ��Ȩʧ��"),

    PAY_MONEY_NOT_EQUAL(22, "֧����һ��"),

    CANCEL_ORDER_SUCCESS(23, "ȡ�������ɹ�"),

    FINISH_ORDER_SUCCESS(24, "��ᶩ���ɹ�"),

    PRODUCT_OFF_SALE_FAIL(25, "��Ʒ�¼�ʧ��"),

    PRODUCT_ON_SALE_FAIL(26, "��Ʒ�¼�ʧ��"),

    PRODUCT_OFF_SALE_SUCCESS(27, "��Ʒ�¼ܳɹ�"),

    PRODUCT_ON_SALE_SUCCESS(28, "��Ʒ�¼ܳɹ�"),

    PRODUCT_UPDATE_SUCCESS(29, "��Ʒ���³ɹ�"),

    CATEGORY_NOT_FOUND(30, "��Ʒ��Ŀû���ҵ�"),

    CATEGORY_UPDATE_SUCCESS(31, "��Ʒ��Ŀ���³ɹ�"),

    CATEGORY_UPDATE_FAIL(32, "��Ʒ��Ŀ����ʧ��"),

    LOGIN_FAIL(33, "��¼ʧ��"),

    LOGIN_SUCCESS(34, "��¼�ɹ�"),

    LOGOUT_SUCCESS(35, "�ǳ��ɹ�"),

    ;

    private Integer code;

    private String msg;

    ExceptionCodeEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


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
