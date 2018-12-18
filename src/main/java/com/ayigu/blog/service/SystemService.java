package com.ayigu.blog.service;

import com.ayigu.blog.entity.Log;
import java.util.List;
/**
 * @Description: 操作系统日志等相关的Service层
 * @Author: chenjun
 * @Date: 2018/11/29 16:26
 */
public interface SystemService {
    /**
     * 新增日志
     *
     * @param log 日志信息
     */
    void insertLog(Log log) throws Exception;

    /**
     * 返回日志记录数量
     *
     * @return 日志记录数量
     */
    int countLog() throws Exception;

    /**
     * 获取所有日志记录
     *
     * @return 日志记录
     */
    List<Log> listAllLog() throws Exception;
}