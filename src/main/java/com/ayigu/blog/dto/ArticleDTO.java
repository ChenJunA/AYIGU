package com.ayigu.blog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Description: 封装文章信息的数据传输对象
 * @Author: chenjun
 * @Date: 2018/11/29 16:28
 */
public class ArticleDTO {
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

    /**
     * 文章内容
     */
    private String Content;

    /**
     * 文章图片URL
     */
    private String pictureUrl;

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
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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

    public Boolean getTop() {
        return top;
    }

    public void setTop(Boolean top) {
        this.top = top;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Override
    public String toString() {
        return "ArticleDTO{" +
                "id=" + id +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", pageView=" + pageView +
                ", categoryId=" + categoryId +
                ", top=" + top +
                ", delete=" + delete +
                ", Content='" + Content + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                '}';
    }
}
