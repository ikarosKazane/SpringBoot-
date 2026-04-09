package com.xbb.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.xbb.entity.GoodsType;
import com.xbb.entity.User;

public class Goods{

    private static final long serialVersionUID = 1L;

    //  汽车ID
    private Integer id;

    //  名称
    private String name;

    //  类型ID
    private Integer goodsTypeId;

    //  状态
    private Boolean status;

    //  描述
    private String describes;

    //  展示图
    private String img;

    //  用户ID
    private Integer userId;

    //  价格
    private Double price;

    //  库存
    private Integer inventory;

    //  预警值
    private Integer warning;

    //  内容
    private String content;

    //  租赁量
    private Integer salesVolume;

    //  押金
    private Double deposit;

    //  创建日期
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date creatDate;

    //  评分
    private Integer score;

    //  品牌
    private String brand;

    //  型号
    private String model;

    private GoodsType goodsType;

    private User user;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setGoodsTypeId(Integer goodsTypeId){
        this.goodsTypeId = goodsTypeId;
    }

    public Integer getGoodsTypeId(){
        return goodsTypeId;
    }

    public void setStatus(Boolean status){
        this.status = status;
    }

    public Boolean getStatus(){
        return status;
    }

    public void setDescribes(String describes){
        this.describes = describes;
    }

    public String getDescribes(){
        return describes;
    }

    public void setImg(String img){
        this.img = img;
    }

    public String getImg(){
        return img;
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }

    public Integer getUserId(){
        return userId;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public Double getPrice(){
        return price;
    }

    public void setInventory(Integer inventory){
        this.inventory = inventory;
    }

    public Integer getInventory(){
        return inventory;
    }

    public void setWarning(Integer warning){
        this.warning = warning;
    }

    public Integer getWarning(){
        return warning;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){
        return content;
    }

    public void setSalesVolume(Integer salesVolume){
        this.salesVolume = salesVolume;
    }

    public Integer getSalesVolume(){
        return salesVolume;
    }

    public void setDeposit(Double deposit){
        this.deposit = deposit;
    }

    public Double getDeposit(){
        return deposit;
    }

    public void setCreatDate(Date creatDate){
        this.creatDate = creatDate;
    }

    public Date getCreatDate(){
        return creatDate;
    }

    public void setScore(Integer score){
        this.score = score;
    }

    public Integer getScore(){
        return score;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getBrand(){
        return brand;
    }

    public void setModel(String model){
        this.model = model;
    }

    public String getModel(){
        return model;
    }

    public GoodsType getGoodsType(){
        return goodsType;
    }

    public void setGoodsType(GoodsType goodsType){
        this.goodsType = goodsType;
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
                .append("name", getName())
                .append("goodsTypeId", getGoodsTypeId())
                .append("status", getStatus())
                .append("describes", getDescribes())
                .append("img", getImg())
                .append("userId", getUserId())
                .append("price", getPrice())
                .append("inventory", getInventory())
                .append("warning", getWarning())
                .append("content", getContent())
                .append("salesVolume", getSalesVolume())
                .append("deposit", getDeposit())
                .append("creatDate", getCreatDate())
                .append("score", getScore())
                .append("brand", getBrand())
                .append("model", getModel())
                .toString();
    }
}
