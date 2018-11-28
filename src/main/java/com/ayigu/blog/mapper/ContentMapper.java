package com.ayigu.blog.mapper;

import com.ayigu.blog.entity.Content;
import com.ayigu.blog.entity.ContentExample;

import java.util.List;

public interface ContentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Content record);

    int insertSelective(Content record);

    List<Content> selectByExampleWithBLOBs(ContentExample example);

    List<Content> selectByExample(ContentExample example);

    Content selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Content record);

    int updateByPrimaryKeyWithBLOBs(Content record);

    int updateByPrimaryKey(Content record);
}