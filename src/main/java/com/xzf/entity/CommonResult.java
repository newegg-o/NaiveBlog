package com.xzf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 统计结果集
 *
 * @author 呵呵厉害了
 * @date 2021/06/20 19:10
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult implements Serializable {
    private long code;
    private String message;
    private Object obj;


    public static CommonResult success(String message) {
        return new CommonResult(200, message, null);
    }

    public static CommonResult success(String message, Object obj) {
        return new CommonResult(200, message, obj);

    }

    public static CommonResult error(String message) {
        return new CommonResult(500, message, null);
    }


    public static CommonResult error(String message, Object obj) {
        return new CommonResult(500, message, obj);
    }


    public static CommonResult error(int code, String msg, Object data) {
        CommonResult r = new CommonResult();
        r.setCode(code);
        r.setMessage(msg);
        r.setObj(data);
        return r;
    }
}
