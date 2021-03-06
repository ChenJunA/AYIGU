package com.ayigu.blog.service.impl;

import com.ayigu.blog.entity.Log;
import com.ayigu.blog.entity.LogExample;
import com.ayigu.blog.mapper.LogMapper;
import com.ayigu.blog.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SystemServiceImpl implements SystemService {
    @Autowired
    LogMapper logMapper;

    @Override
    public void insertLog(Log log) throws Exception {
        logMapper.insertSelective(log);
    }

    @Override
    public int countLog() throws Exception {
        LogExample logExample = new LogExample();
        //查询全部，返回集合大小
        return logMapper.selectByExample(logExample).size();
    }

    @Override
    public List<Log> listAllLog() throws Exception {
        LogExample logExample = new LogExample();
        //查询全部，返回集合
        return logMapper.selectByExample(logExample);
    }
}
