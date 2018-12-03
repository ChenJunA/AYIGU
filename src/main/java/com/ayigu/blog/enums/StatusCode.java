package com.ayigu.blog.enums;

/**
 * @Description: 错误状态码枚举类
 * @Author: chenjun
 * @Date: 2018/12/3 14:13
 */
public enum StatusCode {
    SUCCESS_CODE(200,"SUCCESS"),
    SYSTEM_ERROR(500, "系统错误"),
    PARAMETER_CHECK_ERROR(400, "参数校验错误"),
    AUTH_VALID_ERROR(701, "用户权限不足"),
    UNLOGIN_ERROR(401, "用户未登录或登录状态超时失效"),;

    private Integer value;
    private String message;

    StatusCode(Integer value, String message) {
        this.value = value;
        this.message = message;
    }

    public Integer getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    public String getCode(){
        return value.toString();
    }

    public static StatusCode getByCode(Integer code){
        for (StatusCode statusCode : values()){
            if (statusCode.getValue() == code){
                return statusCode;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "StatusCode{" +
                "value=" + value +
                ", message='" + message + '\'' +
                '}';
    }
}
