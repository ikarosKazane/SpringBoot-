package com.xbb.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Banner{

    private static final long serialVersionUID = 1L;

    //  轮播图ID
    private Integer id;

    //  图片
    private String img;

    //  是否展示
    private Boolean status;

    //  名称
    private String name;

    //  简介
    private String introduce;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public void setImg(String img){
        this.img = img;
    }

    public String getImg(){
        return img;
    }

    public void setStatus(Boolean status){
        this.status = status;
    }

    public Boolean getStatus(){
        return status;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setIntroduce(String introduce){
        this.introduce = introduce;
    }

    public String getIntroduce(){
        return introduce;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("img", getImg())
            .append("status", getStatus())
            .append("name", getName())
            .append("introduce", getIntroduce())
            .toString();
    }
}
