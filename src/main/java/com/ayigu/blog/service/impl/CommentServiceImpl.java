package com.ayigu.blog.service.impl;

import com.ayigu.blog.entity.Comment;
import com.ayigu.blog.entity.CommentExample;
import com.ayigu.blog.mapper.CommentMapper;
import com.ayigu.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Override
    public void insertComment(Comment comment) {
        commentMapper.insertSelective(comment);
    }

    @Override
    public void deleteComment(Long commentId) {
        Comment comment = commentMapper.selectByPrimaryKey(commentId);
        comment.setIsDelete(true);
        commentMapper.updateByPrimaryKeySelective(comment);
    }

    @Override
    public List<Comment> listCommentByArticleId(Long articleId) {
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria commentCriteria = commentExample.createCriteria();
        commentCriteria.andArticleIdEqualTo(articleId);
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        return comments;
    }
}
