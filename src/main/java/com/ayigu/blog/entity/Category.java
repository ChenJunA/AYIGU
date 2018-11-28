package com.ayigu.blog.entity;

import java.util.Date;

public class Category {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String name;

    private Byte number;

    private Boolean delete;

    public Category(Long id, Date gmtCreate, Date gmtModified, String name, Byte number, Boolean delete) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.name = name;
        this.number = number;
        this.delete = delete;
    }

    public Category() {
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

    public Byte getNumber() {
        return number;
    }

    public void setNumber(Byte number) {
        this.number = number;
    }

    public Boolean getIsDelete() {
        return delete;
    }

    public void setIsDelete(Boolean delete) {
        this.delete = delete;
    }
}