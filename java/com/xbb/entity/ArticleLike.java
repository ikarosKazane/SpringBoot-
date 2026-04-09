package com.xbb.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.xbb.entity.Article;
import com.xbb.entity.User;

public class ArticleLike{

    private static final long serialVersionUID = 1L;

    //  文章点赞ID
    private Integer id;

    //  文章ID
    private Integer articleId;

    //  用户ID
    private Integer userId;

    private Article article;

    private User user;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public void setArticleId(Integer articleId){
        this.articleId = articleId;
    }

    public Integer getArticleId(){
        return articleId;
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }

    public Integer getUserId(){
        return userId;
    }

    public Article getArticle(){
        return article;
    }

    public void setArticle(Article article){
        this.article = article;
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
            .append("articleId", getArticleId())
            .append("userId", getUserId())
            .toString();
    }
}
