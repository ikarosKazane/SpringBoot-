package com.xbb.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class User{

    private static final long serialVersionUID = 1L;

    //  用户ID
    private Integer id;

    //  用户名
    private String username;

    //  密码
    private String password;

    //  性别
    private String sex;

    //  邮箱
    private String email;

    //  手机号
    private String cellphone;

    //  地址
    private String address;

    //  名称
    private String name;

    //  注册时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date registerTime;

    //  角色
    private Integer role;

    //  头像
    private String avatar;

    //  令牌
    private String token;

    //  身份证
    private String identity;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setSex(String sex){
        this.sex = sex;
    }

    public String getSex(){
        return sex;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setCellphone(String cellphone){
        this.cellphone = cellphone;
    }

    public String getCellphone(){
        return cellphone;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setRegisterTime(Date registerTime){
        this.registerTime = registerTime;
    }

    public Date getRegisterTime(){
        return registerTime;
    }

    public void setRole(Integer role){
        this.role = role;
    }

    public Integer getRole(){
        return role;
    }

    public void setAvatar(String avatar){
        this.avatar = avatar;
    }

    public String getAvatar(){
        return avatar;
    }

    public void setToken(String token){
        this.token = token;
    }

    public String getToken(){
        return token;
    }

    public void setIdentity(String identity){
        this.identity = identity;
    }

    public String getIdentity(){
        return identity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("username", getUsername())
                .append("password", getPassword())
                .append("sex", getSex())
                .append("email", getEmail())
                .append("cellphone", getCellphone())
                .append("address", getAddress())
                .append("name", getName())
                .append("registerTime", getRegisterTime())
                .append("role", getRole())
                .append("avatar", getAvatar())
                .append("token", getToken())
                .append("identity", getIdentity())
                .toString();
    }
}
