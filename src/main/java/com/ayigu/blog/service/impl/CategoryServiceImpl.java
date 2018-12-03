package com.ayigu.blog.service.impl;

import com.ayigu.blog.entity.*;
import com.ayigu.blog.mapper.ArticleMapper;
import com.ayigu.blog.mapper.CategoryMapper;
import com.ayigu.blog.mapper.CommentMapper;
import com.ayigu.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    CommentMapper commentMapper;

    @Override
    public void insertCategory(Category category) {
        categoryMapper.insertSelective(category);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        //删除分类下文章（将delete属性置为true）
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria articleCriteria = articleExample.createCriteria();
        articleCriteria.andCategoryIdEqualTo(categoryId);
        List<Article> articles = articleMapper.selectByExample(articleExample);
        for (Article article : articles) {
            article.setIsDelete(true);
            articleMapper.updateByPrimaryKeySelective(article);

            //删除分类下文章评论（将delete属性置为true)
            CommentExample commentExample = new CommentExample();
            CommentExample.Criteria commentCriteri = commentExample.createCriteria();
            commentCriteri.andArticleIdEqualTo(article.getId());
            List<Comment> comments = commentMapper.selectByExample(commentExample);
            for(Comment comment : comments){
                comment.setIsDelete(true);
                commentMapper.updateByPrimaryKeySelective(comment);
            }
        }

        //删除该分类（将delete属性置为true）
        Category category = categoryMapper.selectByPrimaryKey(categoryId);
        category.setIsDelete(true);
        categoryMapper.updateByPrimaryKeySelective(category);
    }

    @Override
    public void updateCategory(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryMapper.selectByPrimaryKey(categoryId);
    }

    @Override
    public List<Category> listAllCategory() {
        CategoryExample categoryExample = new CategoryExample();
        //查询全部，返回集合
        return categoryMapper.selectByExample(categoryExample);
    }
}
