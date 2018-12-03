package com.ayigu.blog.controller;

import com.ayigu.blog.dto.ArticleDTO;
import com.ayigu.blog.util.MarkdownToHtmlUtil;
import com.ayigu.blog.util.RespUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description: 文章操作相关Controller
 * @Author: chenjun
 * @Date: 2018/12/3 10:41
 */
@RestController
public class ArticleController extends BaseController{
    /**
     * 新增文章
     *
     * @param articleDTO 文章信息
     * @return
     */
    @ApiOperation("新增文章")
    @ApiImplicitParam(name = "articleDTO", value = "文章信息", required = true, dataType = "ArticleDTO")
    @PostMapping("article")
    public RespUtil<ArticleDTO> insertArticle(@RequestBody ArticleDTO articleDTO){
        articleService.insetArticle(articleDTO);
        return RespUtil.success();
    }

    /**
     * 删除文章
     *
     * @param articleId 文章ID
     * @return
     */
    @ApiOperation("删除文章")
    @ApiImplicitParam(name = "articleId", value = "文章ID", required = true, dataType = "Long")
    @DeleteMapping("articles/{articleId}")
    public RespUtil<ArticleDTO> deleteArticle(@PathVariable Long articleId){
        articleService.deleteArticle(articleId);
        return RespUtil.success();
    }

    /**
     * 更新文章
     *
     * @param articleId 文章ID
     * @param articleDTO 文章信息
     * @return
     */
    @ApiOperation("更新文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleId", value = "文章ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "articleDTO", value = "文章信息", required = true, dataType = "ArticleDTO")
    })
    @PutMapping("articles/{articleId}")
    public RespUtil<ArticleDTO> updateArticle(@PathVariable Long articleId, @RequestBody ArticleDTO articleDTO){
        articleDTO.setId(articleId);
        articleService.updateArticle(articleDTO);
        return RespUtil.success();
    }

    /**
     * 获取所有文章
     *
     * @return 文章列表
     */
    @ApiOperation("获取所有文章")
    @GetMapping("articles")
    public RespUtil<List<ArticleDTO>> listAll(){
        List<ArticleDTO> articleDTOS = articleService.listAll();
        return RespUtil.success(articleDTOS);
    }

    /**
     * 获取某一分类下的所有文章
     *
     * @param categoryId 分类ID
     * @return 文章列表
     */
    @ApiOperation("")
    @ApiImplicitParam(name = "categoryId", value = "分类ID", required = true, dataType = "Long", paramType = "path")
    @GetMapping("articles/{categoryId}")
    public RespUtil<List<ArticleDTO>> listByCategoryId(@PathVariable Long categoryId){
        List<ArticleDTO> articleDTOS = articleService.listByCategoryId(categoryId);
        return RespUtil.success(articleDTOS);

    }

    /**
     * 获取最新的文章
     *
     * @return
     */
    @ApiOperation("获取最新文章")
    @GetMapping("articles/lastest")
    public RespUtil<List<ArticleDTO>> listLastest(){
        List<ArticleDTO> articleDTOS = articleService.listLastest();
        return RespUtil.success(articleDTOS);
    }

    /**
     * 根据文章ID获取文章详细信息
     *
     * @param articleId 文章ID
     * @return 文章详细信息
     */
    @ApiOperation("根据文章ID获取文章详细信息")
    @ApiImplicitParam(name = "articleId", value = "文章ID", required = true, dataType = "Long", paramType = "path")
    @GetMapping("articles/{articleId}")
    public RespUtil<ArticleDTO> getArticleDtoById(@PathVariable Long articleId){
        ArticleDTO articleDTO = articleService.getArticleDtoById(articleId);
        //将文章内容由markdown转成html
        articleDTO.setContent(MarkdownToHtmlUtil.markdownToHtml( articleDTO.getContent()));
        return RespUtil.success(articleDTO);
    }
}
