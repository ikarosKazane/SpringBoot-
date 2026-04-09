package com.xbb.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.xbb.entity.Goods;
import com.xbb.entity.User;

public class GoodsCollect{

    private static final long serialVersionUID = 1L;

    //  汽车收藏ID
    private Integer id;

    //  汽车ID
    private Integer goodsId;

    //  用户ID
    private Integer userId;

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
            .toString();
    }
}
