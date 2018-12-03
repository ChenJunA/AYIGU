package com.ayigu.blog.controller;

import com.ayigu.blog.entity.Comment;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description: 留言、评论操作相关Controller
 * @Author: chenjun
 * @Date: 2018/12/3 10:34
 */
@RestController
public class CommentController extends BaseController {
    /**
     * 新增留言、评论
     *
     * @param articleId 文章ID
     * @param comment 评论、留言
     */
    @ApiOperation("新增留言、评论")
    @ApiImplicitParam(name = "articleId", value = "文章ID", required = true, dataType = "Long", paramType = "path")
    @PostMapping("comment/{articleId}")
    public String insertComment(@PathVariable Long articleId, @RequestBody Comment comment, HttpServletRequest request){
        comment.setArticleId(articleId);
        comment.setIp(request.getRemoteAddr());
        commentService.insertComment(comment);
        return null;
    }

    /**
     * 删除留言、评论
     *
     * @param commentId 留言、评论ID
     * @return null
     */
    @ApiOperation("删除留言、评论")
    @ApiImplicitParam(name = "commentId", value = "评论ID", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("comments/{commentId}")
    public String deleteComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);
        return null;
    }

    /**
     * 获取文章评论，留言
     *
     * @param articleId 文章ID
     * @return 评论，留言
     */
    @ApiOperation("获取文章评论，留言")
    @ApiImplicitParam(name = "articleId", value = "文章ID", required = true, dataType = "Long", paramType = "path")
    @GetMapping("comment/{articleId}")
    public List<Comment> listCommentByArticleId(@PathVariable Long articleId){
        return commentService.listCommentByArticleId(articleId);
    }
}
