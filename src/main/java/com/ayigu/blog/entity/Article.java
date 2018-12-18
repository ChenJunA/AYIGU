package com.ayigu.blog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Article {
    /**
     * 文章ID
     */
    private Long id;

    /**
     *创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtModified;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章简介
     */
    private String summary;

    /**
     * 浏览量
     */
    private Integer pageView;

    /**
     * 分类ID
     */
    private Long categoryId;

    /**
     * 是否置顶
     */
    private Boolean top;

    /**
     * 是否删除
     */
    private Boolean delete;

    public Article(Long id, Date gmtCreate, Date gmtModified, String title, String summary, Integer pageView, Long categoryId, Boolean top, Boolean delete) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.title = title;
        this.summary = summary;
        this.pageView = pageView;
        this.categoryId = categoryId;
        this.top = top;
        this.delete = delete;
    }

    public Article() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public Integer getPageView() {
        return pageView;
    }

    public void setPageView(Integer pageView) {
        this.pageView = pageView;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Boolean getIsTop() {
        return top;
    }

    public void setIsTop(Boolean top) {
        this.top = top;
    }

    public Boolean getIsDelete() {
        return delete;
    }

    public void setIsDelete(Boolean delete) {
        this.delete = delete;
    }
}