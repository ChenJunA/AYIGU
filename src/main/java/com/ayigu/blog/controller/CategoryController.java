package com.ayigu.blog.controller;

import com.ayigu.blog.entity.Category;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description: 分类操作相关Controller
 * @Author: chenjun
 * @Date: 2018/12/3 10:43
 */
public class CategoryController extends BaseController{
    /**
     * 新增文章分类
     *
     * @param category 分类信息
     * @return null
     */
    @ApiOperation("新增文章分类")
    @ApiImplicitParam(name = "category", value = "分类信息", required = true, dataType = "Category")
    @PostMapping("category")
    public String insertCategory(@RequestBody Category category){
        categoryService.insertCategory(category);
        return null;
    }

    /**
     * 删除分类信息
     *
     * @param categoryId 分类ID
     * @return null
     */
    @ApiOperation("删除分类")
    @ApiImplicitParam(name = "categoryId", value = "分类ID", required = true, dataType = "Long")
    @DeleteMapping("categories/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId){
        categoryService.deleteCategory(categoryId);
        return null;
    }

    /**
     * 更新分类信息
     * @param categoryId 分类ID
     * @param category 分类信息
     * @return null
     */
    @ApiOperation("更新分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId", value = "分类ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "category", value = "分类信息", required = true, dataType = "Category")
    })
    @PutMapping("categories/{categoryId}")
    public String updateCategory(@PathVariable Long categoryId, @RequestBody Category category){
        category.setId(categoryId);
        categoryService.updateCategory(category);
        return null;
    }

    /**
     * 获取所有分类
     *
     * @return 分类列表
     */
    @ApiOperation("获取所有分类")
    @GetMapping("categories")
    public List<Category> listAllCategory(){
        return categoryService.listAllCategory();
    }

    /**
     * 获取某一个分类信息
     *
     * @param categoryId 分类ID
     * @return null
     */
    @ApiOperation("获取某一个分类信息")
    @ApiImplicitParam(name = "categoryId", value = "分类ID", required = true, dataType = "Long")
    @GetMapping("categories/{categoryId}")
    public String getCategory(@PathVariable Long categoryId){
        categoryService.getCategoryById(categoryId);
        return null;
    }
}
