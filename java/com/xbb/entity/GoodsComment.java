package com.xbb.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.xbb.entity.Goods;
import com.xbb.entity.User;

public class GoodsComment{

    private static final long serialVersionUID = 1L;

    //  汽车评价ID
    private Integer id;

    //  汽车ID
    private Integer goodsId;

    //  用户ID
    private Integer userId;

    //  评价分数
    private Integer score;

    //  评价内容
    private String content;

    //  评价时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date creatTime;

    private Goods goods;

    private User user;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public void setGoodsId(Integer goodsId){
        this.goodsId = goodsId;
    }

    public Integer getGoodsId(){
        return goodsId;
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }

    public Integer getUserId(){
        return userId;
    }

    public void setScore(Integer score){
        this.score = score;
    }

    public Integer getScore(){
        return score;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){
        return content;
    }

    public void setCreatTime(Date creatTime){
        this.creatTime = creatTime;
    }

    public Date getCreatTime(){
        return creatTime;
    }

    public Goods getGoods(){
        return goods;
    }

    public void setGoods(Goods goods){
        this.goods = goods;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("goodsId", getGoodsId())
                .append("userId", getUserId())
                .append("score", getScore())
                .append("content", getContent())
                .append("creatTime", getCreatTime())
                .toString();
    }
}
