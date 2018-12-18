package com.ayigu.blog.exception;

import com.ayigu.blog.enums.StatusCode;

/**
 * @Description: 自定义异常类
 * @Author: chenjun
 * @Date: 2018/12/17 21:53
 */
public class MyException extends RuntimeException {
    /**
     * 状态码
     */
    private Integer code;

    public MyException(StatusCode statusCode){
        super(statusCode.getMessage());
        this.code = statusCode.getCode();
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
