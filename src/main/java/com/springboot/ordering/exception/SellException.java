package com.springboot.ordering.exception;

import com.springboot.ordering.enums.ExceptionCodeEnums;

public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ExceptionCodeEnums exceptionCodeEnums) {
        super(exceptionCodeEnums.getMsg());
        this.code = exceptionCodeEnums.getCode();
    }

    public SellException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

}
