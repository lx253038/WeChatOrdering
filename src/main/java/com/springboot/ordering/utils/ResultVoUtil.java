package com.springboot.ordering.utils;

import com.springboot.ordering.VO.ResultVo;

public class ResultVoUtil {
    public static ResultVo success(Object object) {
        ResultVo vo = new ResultVo();
        vo.setCode(0);
        vo.setMsg("³É¹¦");
        vo.setData(object);
        return vo;
    }

    public static ResultVo success() {
        return success(null);
    }

    public static ResultVo error(Integer code, String msg) {
        ResultVo vo = new ResultVo();
        vo.setCode(code);
        vo.setMsg(msg);
        return vo;
    }

}
