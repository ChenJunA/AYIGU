package com.ayigu.blog.entity;

import java.util.Date;

public class Article {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String title;

    private String summary;

    private Integer pageView;

    private Long categoryId;

    private Boolean isTop;

    private Boolean delete;

    public Article(Long id, Date gmtCreate, Date gmtModified, String title, String summary, Integer pageView, Long categoryId, Boolean isTop, Boolean delete) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.title = title;
        this.summary = summary;
        this.pageView = pageView;
        this.categoryId = categoryId;
        this.isTop = isTop;
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
        return isTop;
    }

    public void setIsTop(Boolean isTop) {
        this.isTop = isTop;
    }

    public Boolean getIsDelete() {
        return delete;
    }

    public void setIsDelete(Boolean delete) {
        this.delete = delete;
    }
}