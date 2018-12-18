package com.ayigu.blog.service;

import com.ayigu.blog.entity.Category;

import java.util.List;

/**
 * @Description: 操作分类相关的Service层
 * @Author: chenjun
 * @Date: 2018/11/29 16:22
 */
public interface CategoryService {
    /**
     * 新增分类
     *
     * @param category 分类信息
     */
    void insertCategory(Category category) throws Exception;

    /**
     * 删除分类
     *
     * @param categoryId 分类ID
     */
    void deleteCategory(Long categoryId) throws Exception;

    /**
     * 跟新分类
     *
     * @param category 分类信息
     */
    void updateCategory(Category category) throws Exception;

    /**
     * 获取对应ID的分类
     *
     * @param categoryId 分类ID
     * @return 分类信息
     */
    Category getCategoryById(Long categoryId) throws Exception;

    /**
     * 获取所有分类信息
     * @return 分类信息
     */
    List<Category> listAllCategory() throws Exception;
}
