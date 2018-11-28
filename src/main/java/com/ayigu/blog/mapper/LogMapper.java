package com.ayigu.blog.mapper;

import com.ayigu.blog.entity.Log;
import com.ayigu.blog.entity.LogExample;

import java.util.List;

public interface LogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Log record);

    int insertSelective(Log record);

    List<Log> selectByExample(LogExample example);

    Log selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);
}