package com.ayigu.blog.service.impl;

import com.ayigu.blog.entity.Log;
import com.ayigu.blog.entity.LogExample;
import com.ayigu.blog.mapper.LogMapper;
import com.ayigu.blog.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemServiceImpl implements SystemService {
    @Autowired
    LogMapper logMapper;

    @Override
    public void insertLog(Log log) {
        logMapper.insertSelective(log);
    }

    @Override
    public int countLog() {
        LogExample logExample = new LogExample();
        //查询全部，返回集合大小
        return logMapper.selectByExample(logExample).size();
    }

    @Override
    public List<Log> listAllLog() {
        LogExample logExample = new LogExample();
        //查询全部，返回集合
        return logMapper.selectByExample(logExample);
    }
}
