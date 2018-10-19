package com.springboot.ordering.VO;

/**
 * http请求返回最外层的对象
 */
public class ResultVo<T> {

    //状态码
    private Integer code;
    //提示信息
    private String msg;
    //返回数据具体内容
    private T data;


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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
