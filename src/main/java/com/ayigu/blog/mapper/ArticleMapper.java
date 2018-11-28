package com.ayigu.blog.mapper;

import com.ayigu.blog.entity.Article;
import com.ayigu.blog.entity.ArticleExample;

import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Article record);

    int insertSelective(Article record);

    List<Article> selectByExample(ArticleExample example);

    Article selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}