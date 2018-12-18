package com.ayigu.blog.service.impl;

import com.ayigu.blog.entity.Comment;
import com.ayigu.blog.entity.CommentExample;
import com.ayigu.blog.enums.StatusCode;
import com.ayigu.blog.exception.MyException;
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
    public void insertComment(Comment comment) throws Exception {
        commentMapper.insertSelective(comment);
    }

    @Override
    public void deleteComment(Long commentId) throws Exception {
        Comment comment = commentMapper.selectByPrimaryKey(commentId);
        if(comment == null){
            throw new MyException(StatusCode.CONTENT_ERROR);
        }
        comment.setIsDelete(true);
        commentMapper.updateByPrimaryKeySelective(comment);
    }

    @Override
    public List<Comment> listCommentByArticleId(Long articleId) throws Exception {
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria commentCriteria = commentExample.createCriteria();
        commentCriteria.andArticleIdEqualTo(articleId);
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        return comments;
    }

    @Override
    public List<Comment> listAllComment() throws Exception {
        CommentExample commentExample = new CommentExample();
        //查询全部，返回集合
        return commentMapper.selectByExample(commentExample);
    }
}
