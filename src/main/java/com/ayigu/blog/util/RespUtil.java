package com.ayigu.blog.util;

import com.ayigu.blog.enums.StatusCode;
import org.springframework.http.HttpStatus;

import java.util.Map;

/**
 * @Description: 返回数据工具类
 * @Author: chenjun
 * @Date: 2018/12/3 13:49
 */
public class RespUtil<T> {
    private final static String SUCCESS_CODE = "200";
    /**
     * 返回状态码
     */
    private String status;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 附加内容
     */
    private Map<String,Object> extra;

    //Getter and Setter
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }

    //构造函数
    public RespUtil() {
        this.status = SUCCESS_CODE;
        this.message = "SUCCESS";
    }

    public RespUtil(String status) {
        this.status = status;
    }

    public RespUtil(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public RespUtil(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public RespUtil(String status, String message, Map<String, Object> extra) {
        this.status = status;
        this.message = message;
        this.extra = extra;
    }

    public RespUtil(String status, String message, T data, Map<String, Object> extra) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.extra = extra;
    }

    //返回成功
    public static <T> RespUtil success(){
        return new RespUtil<T>(StatusCode.SUCCESS_CODE.getCode(),StatusCode.SUCCESS_CODE.getMessage());
    }

    public static <T> RespUtil success(T data){
        return new RespUtil<T>(StatusCode.SUCCESS_CODE.getCode(),StatusCode.SUCCESS_CODE.getMessage(),data);
    }

    public static <T> RespUtil success(Map<String, Object> extra){
        return new RespUtil<T>(StatusCode.SUCCESS_CODE.getCode(),StatusCode.SUCCESS_CODE.getMessage(), extra);
    }

    public static <T> RespUtil success(T data, Map<String, Object> extra){
        return new RespUtil<T>(StatusCode.SUCCESS_CODE.getCode(),StatusCode.SUCCESS_CODE.getMessage(), data, extra);
    }

    //返回失败,默认ErrorCode.SYSTEM_ERROR
    public static <T> RespUtil fail(){
        return new RespUtil<T>(StatusCode.SYSTEM_ERROR.getCode(), StatusCode.SYSTEM_ERROR.getMessage());
    }

    public static <T> RespUtil fail(T data){
        return new RespUtil<T>(StatusCode.SYSTEM_ERROR.getCode(), StatusCode.SYSTEM_ERROR.getMessage(), data);
    }

    public static <T> RespUtil fail(Map<String, Object> extra){
        return new RespUtil<T>(StatusCode.SYSTEM_ERROR.getCode(), StatusCode.SYSTEM_ERROR.getMessage(), extra);
    }

    public static <T> RespUtil fail(T data, Map<String, Object> extra){
        return new RespUtil<T>(StatusCode.SYSTEM_ERROR.getCode(), StatusCode.SYSTEM_ERROR.getMessage(), data, extra);
    }

    //返回失败,传入ErrorCode
    public static <T> RespUtil fail(StatusCode statusCode){
        return new RespUtil<T>(statusCode.getCode(), statusCode.getMessage());
    }

    public static <T> RespUtil fail(StatusCode statusCode, T data){
        return new RespUtil<T>(statusCode.getCode(), statusCode.getMessage(), data);
    }

    public static <T> RespUtil fail(StatusCode statusCode, Map<String, Object> extra){
        return new RespUtil<T>(statusCode.getCode(), statusCode.getMessage(), extra);
    }

    public static <T> RespUtil fail(StatusCode statusCode, T data, Map<String, Object> extra){
        return new RespUtil<T>(statusCode.getCode(), statusCode.getMessage(), data, extra);
    }

    //返回自定义状态码
    public static <T> RespUtil result(String status, String message){
        return new RespUtil<T>(status, message);
    }

    public static <T> RespUtil result(String status, String message, T data){
        return new RespUtil<T>(status, message, data);
    }

    public static <T> RespUtil result(String status, String message, Map<String, Object> extra){
        return new RespUtil<T>(status, message, extra);
    }

    public static <T> RespUtil result(String status, String message,T data, Map<String,Object> extra){
        return new RespUtil<T>(status, message, data, extra);
    }

    //返回Http状态
    public static <T> RespUtil httpStatus(HttpStatus httpStatus){
        return new RespUtil(httpStatus.toString(), httpStatus.getReasonPhrase());
    }

    public static <T> RespUtil httpStatus(HttpStatus httpStatus, T data){
        return new RespUtil(httpStatus.toString(), httpStatus.getReasonPhrase(), data);
    }

    public static <T> RespUtil httpStatus(HttpStatus httpStatus, Map<String, Object> extra){
        return new RespUtil(httpStatus.toString(), httpStatus.getReasonPhrase(), extra);
    }

    public static <T> RespUtil httpStatus(HttpStatus httpStatus, T data, Map<String, Object> extra){
        return new RespUtil(httpStatus.toString(), httpStatus.getReasonPhrase(), extra);
    }
}
