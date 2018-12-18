package com.ayigu.blog.service;

import com.ayigu.blog.entity.Comment;

import java.util.List;

/**
 * @Description: 操作评论、留言相关的Service层
 * @Author: chenjun
 * @Date: 2018/11/29 16:24
 */
public interface CommentService {
    /**
     * 新增留言、评论
     *
     * @param comment 留言、评论信息
     */
    void insertComment(Comment comment) throws Exception;

    /**
     * 删除留言、评论
     *
     * @param commentId 留言、评论ID
     */
    void deleteComment(Long commentId) throws Exception;

    /**
     * 获取对应文章下的所有评论
     *
     * @param articleId 文章ID
     * @return 评论信息
     */
    List<Comment> listCommentByArticleId(Long articleId) throws Exception;

    /**
     * 获取所有评论、留言
     * @return 评论、留言列表
     */
    List<Comment> listAllComment() throws Exception;
}
