package com.ayigu.blog.controller;

import com.ayigu.blog.entity.Category;
import com.ayigu.blog.util.RespUtil;
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
@RestController
public class CategoryController extends BaseController{
    /**
     * 新增文章分类
     *
     * @param category 分类信息
     * @return 状态信息
     */
    @ApiOperation("新增文章分类")
    @ApiImplicitParam(name = "category", value = "分类信息", required = true, dataType = "Category")
    @PostMapping("admin/category")
    public RespUtil<Category> insertCategory(@RequestBody Category category) throws Exception {
        categoryService.insertCategory(category);
        return RespUtil.success();
    }

    /**
     * 删除分类信息
     *
     * @param categoryId 分类ID
     * @return 状态信息
     */
    @ApiOperation("删除分类")
    @ApiImplicitParam(name = "categoryId", value = "分类ID", required = true, dataType = "Long")
    @DeleteMapping("admin/categories/{categoryId}")
    public RespUtil<Category> deleteCategory(@PathVariable Long categoryId) throws Exception {
        categoryService.deleteCategory(categoryId);
        return RespUtil.success();
    }

    /**
     * 更新分类信息
     * @param categoryId 分类ID
     * @param category 分类信息
     * @return 状态信息
     */
    @ApiOperation("更新分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId", value = "分类ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "category", value = "分类信息", required = true, dataType = "Category")
    })
    @PutMapping("admin/categories/{categoryId}")
    public RespUtil<Category> updateCategory(@PathVariable Long categoryId, @RequestBody Category category) throws Exception {
        category.setId(categoryId);
        categoryService.updateCategory(category);
        return RespUtil.success(category);
    }

    /**
     * 获取所有分类
     *
     * @return 分类列表
     */
    @ApiOperation("获取所有分类")
    @GetMapping("categories")
    public RespUtil<List<Category>> listAllCategory() throws Exception {
        List<Category> categories = categoryService.listAllCategory();
        return RespUtil.success(categories);
    }

    /**
     * 获取某一个分类信息
     *
     * @param categoryId 分类ID
     * @return 状态信息
     */
    @ApiOperation("获取某一个分类信息")
    @ApiImplicitParam(name = "categoryId", value = "分类ID", required = true, dataType = "Long")
    @GetMapping("categories/{categoryId}")
    public RespUtil<Category> getCategory(@PathVariable Long categoryId) throws Exception {
        Category category = categoryService.getCategoryById(categoryId);
        return RespUtil.success(category);
    }
}
