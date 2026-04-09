package com.xbb.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.xbb.entity.Goods;
import com.xbb.entity.User;

public class GoodsOrders{

    private static final long serialVersionUID = 1L;

    //  租赁订单ID
    private Integer id;

    //  汽车ID
    private Integer goodsId;

    //  订单编号
    private String number;

    //  合计金额
    private Double money;

    //  创建日期
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date creatDate;

    //  年份
    private Integer year;

    //  月份
    private Integer month;

    //  用户ID
    private Integer userId;

    //  租赁数量
    private Integer quantity;

    //  开始时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    //  结束时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    //  租赁时长
    private Integer duration;

    //  审核状态
    private Integer status;

    //  审核意见
    private String opinion;

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

    public void setNumber(String number){
        this.number = number;
    }

    public String getNumber(){
        return number;
    }

    public void setMoney(Double money){
        this.money = money;
    }

    public Double getMoney(){
        return money;
    }

    public void setCreatDate(Date creatDate){
        this.creatDate = creatDate;
    }

    public Date getCreatDate(){
        return creatDate;
    }

    public void setYear(Integer year){
        this.year = year;
    }

    public Integer getYear(){
        return year;
    }

    public void setMonth(Integer month){
        this.month = month;
    }

    public Integer getMonth(){
        return month;
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }

    public Integer getUserId(){
        return userId;
    }

    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }

    public Integer getQuantity(){
        return quantity;
    }

    public void setStartTime(Date startTime){
        this.startTime = startTime;
    }

    public Date getStartTime(){
        return startTime;
    }

    public void setEndTime(Date endTime){
        this.endTime = endTime;
    }

    public Date getEndTime(){
        return endTime;
    }

    public void setDuration(Integer duration){
        this.duration = duration;
    }

    public Integer getDuration(){
        return duration;
    }

    public void setStatus(Integer status){
        this.status = status;
    }

    public Integer getStatus(){
        return status;
    }

    public void setOpinion(String opinion){
        this.opinion = opinion;
    }

    public String getOpinion(){
        return opinion;
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
                .append("number", getNumber())
                .append("money", getMoney())
                .append("creatDate", getCreatDate())
                .append("year", getYear())
                .append("month", getMonth())
                .append("userId", getUserId())
                .append("quantity", getQuantity())
                .append("startTime", getStartTime())
                .append("endTime", getEndTime())
                .append("duration", getDuration())
                .append("status", getStatus())
                .append("opinion", getOpinion())
                .toString();
    }
}
