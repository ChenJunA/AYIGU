package com.ayigu.blog.entity;

import java.util.Date;

public class Comment {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String name;

    private String email;

    private String content;

    private String ip;

    private Long articleId;

    private Boolean delete;

    public Comment(Long id, Date gmtCreate, Date gmtModified, String name, String email, String content, String ip, Long articleId, Boolean delete) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.name = name;
        this.email = email;
        this.content = content;
        this.ip = ip;
        this.articleId = articleId;
        this.delete = delete;
    }

    public Comment() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Boolean getIsDelete() {
        return delete;
    }

    public void setIsDelete(Boolean delete) {
        this.delete = delete;
    }
}