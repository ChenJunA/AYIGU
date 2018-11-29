package com.ayigu.blog.service;

import com.ayigu.blog.dto.ArticleDTO;

import java.util.List;

/**
 * @Description: 操作文章相关的Service层
 * @Author: chenjun
 * @Date: 2018/11/29 16:20
 */
public interface ArticleService {
    /**
     * 新增文章
     *
     * @param articleDTO 文章信息
     */
    void insetArticle(ArticleDTO articleDTO);

    /**
     * 根据ID删除文章
     *
     * @param articleId 文章ID
     */
    void deleteArticle(Long articleId);

    /**
     * 更新文章
     *
     * @param articleDTO 文章信息
     */
    void updateArticle(ArticleDTO articleDTO);

    /**
     * 根据ID获取相应文章详细信息
     *
     * @param articleId 文章ID
     * @return 文章详细信息
     */
    ArticleDTO getArticleDtoById(Long articleId);

    /**
     * 所有文章列表
     *
     * @return 所有文章集合
     */
    List<ArticleDTO> listAll();

    /**
     * 根据分类ID查询该分类下所有文章
     *
     * @param categoryId
     * @return 对应分类下所有文章
     */
    List<ArticleDTO> listByCategoryId(Long categoryId);

    /**
     * 最新法布文章（默认五篇）
     *
     * @return 文章列表
     */
    List<ArticleDTO> listLastest();
}
