package com.ayigu.blog.service.impl;

import com.ayigu.blog.dto.ArticleDTO;
import com.ayigu.blog.entity.*;
import com.ayigu.blog.mapper.ArticleMapper;
import com.ayigu.blog.mapper.CategoryMapper;
import com.ayigu.blog.mapper.ContentMapper;
import com.ayigu.blog.mapper.PictureMapper;
import com.ayigu.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    ContentMapper contentMapper;
    @Autowired
    PictureMapper pictureMapper;
    @Autowired
    CategoryMapper categoryMapper;

    public static final int LASTEST_ARTICLE_COUNT = 5;

    @Override
    public void insetArticle(ArticleDTO articleDTO) {
        //数据插入blog_article
        Article article = new Article();
        article.setTitle(articleDTO.getTitle());
        article.setSummary(articleDTO.getSummary());
        article.setCategoryId(articleDTO.getCategoryId());
        article.setIsTop(articleDTO.getTop());
        articleMapper.insertSelective(article);

        //获取文章ID
        Long articleId = getLastestArticleId();

        //数据插入blog_content
        Content content = new Content();
        content.setContent(articleDTO.getContent());
        content.setArticleId(articleId);
        contentMapper.insertSelective(content);

        //数据插入blog_picture
        Picture picture = new Picture();
        picture.setArticleId(articleId);
        picture.setPictureUrl(articleDTO.getPictureUrl());
        pictureMapper.insertSelective(picture);

        //对应分类下文章数量+1
        Category category = categoryMapper.selectByPrimaryKey(articleDTO.getCategoryId());
        category.setNumber((byte) (category.getNumber() + 1));
        categoryMapper.updateByPrimaryKeySelective(category);
    }

    @Override
    public void deleteArticle(Long articleId) {
        //删除文章信息（delete属性置为true)
        Article article = articleMapper.selectByPrimaryKey(articleId);
        if(article != null){
            article.setIsDelete(true);
            articleMapper.updateByPrimaryKeySelective(article);
        }
        //对应分类下文章数量-1
        Category category = categoryMapper.selectByPrimaryKey(article.getCategoryId());
        category.setNumber((byte) (category.getNumber() - 1));
        categoryMapper.updateByPrimaryKeySelective(category);

    }

    @Override
    public void updateArticle(ArticleDTO articleDTO) {
        //获取文章
        Article article = articleMapper.selectByPrimaryKey(articleDTO.getId());

        //更新blog_article
        article.setTitle(articleDTO.getTitle());
        article.setSummary(articleDTO.getSummary());
        article.setCategoryId(articleDTO.getCategoryId());
        article.setIsTop(articleDTO.getTop());
        articleMapper.updateByPrimaryKeySelective(article);

        //如果修改了文章分类，原分类下文章数量-1，新分类下文章数量+1
        if(article.getCategoryId() != articleDTO.getCategoryId()){
            Category oldCategory = categoryMapper.selectByPrimaryKey(article.getCategoryId());
            oldCategory.setNumber((byte) (oldCategory.getNumber() - 1));
            Category newCategory = categoryMapper.selectByPrimaryKey(articleDTO.getCategoryId());
            newCategory.setNumber((byte) (newCategory.getNumber() + 1));
            categoryMapper.updateByPrimaryKeySelective(oldCategory);
            categoryMapper.updateByPrimaryKeySelective(newCategory);
        }

        //获取文章内容
        ContentExample contentExample = new ContentExample();
        ContentExample.Criteria contentCriteria = contentExample.createCriteria();
        contentCriteria.andArticleIdEqualTo(articleDTO.getId());
        List<Content> contents = contentMapper.selectByExample(contentExample);
        Content content = contents.get(0);
        //更新blog_content
        content.setContent(articleDTO.getContent());
        contentMapper.updateByPrimaryKeySelective(content);

        //获取文章题图
        PictureExample pictureExample = new PictureExample();
        PictureExample.Criteria criteria = pictureExample.createCriteria();
        criteria.andArticleIdEqualTo(articleDTO.getId());
        List<Picture> pictures = pictureMapper.selectByExample(pictureExample);
        Picture picture = pictures.get(0);
        //更新blog_picture
        picture.setPictureUrl(articleDTO.getPictureUrl());
        pictureMapper.updateByPrimaryKeySelective(picture);
    }

    @Override
    public ArticleDTO getArticleDtoById(Long articleId) {
        ArticleDTO articleDTO = new ArticleDTO();

        Article article = articleMapper.selectByPrimaryKey(articleId);
        articleDTO.setId(article.getId());
        articleDTO.setTitle(article.getTitle());
        articleDTO.setSummary(article.getSummary());
        articleDTO.setGmtCreate(article.getGmtCreate());
        articleDTO.setGmtModified(article.getGmtModified());
        articleDTO.setCategoryId(article.getCategoryId());
        articleDTO.setDelete(article.getIsDelete());
        articleDTO.setTop(article.getIsTop());
        articleDTO.setPageView(article.getPageView());

        ContentExample contentExample = new ContentExample();
        ContentExample.Criteria contentCriteria = contentExample.createCriteria();
        contentCriteria.andArticleIdEqualTo(articleDTO.getId());
        //检索text文件时需要使用selectByExampleWithBLOBs
        List<Content> contents = contentMapper.selectByExampleWithBLOBs(contentExample);
        Content content = contents.get(0);
        articleDTO.setContent(content.getContent());

        PictureExample pictureExample = new PictureExample();
        PictureExample.Criteria criteria = pictureExample.createCriteria();
        criteria.andArticleIdEqualTo(articleDTO.getId());
        List<Picture> pictures = pictureMapper.selectByExample(pictureExample);
        Picture picture = pictures.get(0);
        articleDTO.setPictureUrl(picture.getPictureUrl());

        return articleDTO;
    }

    @Override
    public List<ArticleDTO> listAll() {
        //获取所有文章
        ArticleExample articleExample = new ArticleExample();
        articleExample.setOrderByClause("id asc");
        List<Article> articles = articleMapper.selectByExample(articleExample);
        LinkedList<ArticleDTO> articleDTOs = new LinkedList<>();

        //转成articleDTO,如果置顶，放在链表前面
        for(Article article : articles){
            if(article.getIsTop()){
                articleDTOs.addFirst(getArticleDtoById(article.getId()));
            } else {
                articleDTOs.addLast(getArticleDtoById(article.getId()));
            }
        }

        return articleDTOs;
    }

    @Override
    public List<ArticleDTO> listByCategoryId(Long categoryId) {
        List<ArticleDTO> articleDTOs = listAll();
        for(ArticleDTO articleDTO : articleDTOs){
            if(articleDTO.getCategoryId() != categoryId){
                articleDTOs.remove(articleDTO);
            }
        }
        return articleDTOs;
    }

    @Override
    public List<ArticleDTO> listLastest() {
        //获取所有文章
        List<ArticleDTO> articleDTOs = listAll();
        //判断是否大于五篇
        if(articleDTOs.size() >= LASTEST_ARTICLE_COUNT){
            //大于五篇返回前五篇文章
            return articleDTOs.subList(0,LASTEST_ARTICLE_COUNT);
        }
        //不大于五篇直接返回
        return articleDTOs;
    }

    private Long getLastestArticleId() {
        //因为文章ID自增，降序排序取第一个即为新增的文章
        ArticleExample articleExample = new ArticleExample();
        articleExample.setOrderByClause("id desc");
        Long articleId = articleMapper.selectByExample(articleExample).get(0).getId();
        return articleId;
    }
}
