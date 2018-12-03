package com.ayigu.blog.controller;

import com.ayigu.blog.service.ArticleService;
import com.ayigu.blog.service.CategoryService;
import com.ayigu.blog.service.CommentService;
import com.ayigu.blog.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 基础Controller
 * @Author: chenjun
 * @Date: 2018/11/29 16:20
 */
public class BaseController {
    @Autowired
    ArticleService articleService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    CommentService commentService;
    @Autowired
    SystemService systemService;
}
