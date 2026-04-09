package com.xbb.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class About{

    private static final long serialVersionUID = 1L;

    //  关于我们ID
    private Integer id;

    //  电话
    private String cellphone;

    //  邮箱
    private String email;

    //  地址
    private String address;

    //  成立时间
    private String creatDate;

    //  状态
    private Boolean status;

    //  简介
    private String introduce;

    //  图片
    private String img;

    //  名称
    private String name;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public void setCellphone(String cellphone){
        this.cellphone = cellphone;
    }

    public String getCellphone(){
        return cellphone;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    public void setCreatDate(String creatDate){
        this.creatDate = creatDate;
    }

    public String getCreatDate(){
        return creatDate;
    }

    public void setStatus(Boolean status){
        this.status = status;
    }

    public Boolean getStatus(){
        return status;
    }

    public void setIntroduce(String introduce){
        this.introduce = introduce;
    }

    public String getIntroduce(){
        return introduce;
    }

    public void setImg(String img){
        this.img = img;
    }

    public String getImg(){
        return img;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("cellphone", getCellphone())
            .append("email", getEmail())
            .append("address", getAddress())
            .append("creatDate", getCreatDate())
            .append("status", getStatus())
            .append("introduce", getIntroduce())
            .append("img", getImg())
            .append("name", getName())
            .toString();
    }
}
