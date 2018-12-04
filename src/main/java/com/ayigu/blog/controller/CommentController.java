package com.ayigu.blog.controller;

import com.ayigu.blog.entity.Comment;
import com.ayigu.blog.util.RespUtil;
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
    public RespUtil<Comment> insertComment(@PathVariable Long articleId, @RequestBody Comment comment, HttpServletRequest request){
        comment.setArticleId(articleId);
        comment.setIp(request.getRemoteAddr());
        commentService.insertComment(comment);
        return RespUtil.success();
    }

    /**
     * 删除留言、评论
     *
     * @param commentId 留言、评论ID
     * @return 状态信息
     */
    @ApiOperation("删除留言、评论")
    @ApiImplicitParam(name = "commentId", value = "评论ID", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("admin/comments/{commentId}")
    public RespUtil<Comment> deleteComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);
        return RespUtil.success();
    }

    /**
     * 获取文章评论，留言
     *
     * @param articleId 文章ID
     * @return 评论，留言
     */
    @ApiOperation("获取文章评论，留言")
    @ApiImplicitParam(name = "articleId", value = "文章ID", required = true, dataType = "Long", paramType = "path")
    @GetMapping("comments/{articleId}")
    public RespUtil<List<Comment>> listCommentByArticleId(@PathVariable Long articleId){
        List<Comment> comments = commentService.listCommentByArticleId(articleId);
        return RespUtil.success(comments);
    }

    /**
     * 获取所有评论，留言
     * @return 评论，留言列表
     */
    @ApiOperation("获取所有评论，留言")
    @GetMapping("admin/comments")
    public RespUtil<List<Comment>> listAllComment(){
        List<Comment> comments = commentService.listAllComment();
        return RespUtil.success(comments);
    }
}
