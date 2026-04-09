package com.xbb.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import com.xbb.mapper.ArticleMapper;
import com.xbb.entity.Article;
import com.xbb.service.ArticleService;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    // 删除数据
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return articleMapper.deleteByPrimaryKey(id);
    }

    // 插入数据
    @Override
    public int insert(Article article) {
        return articleMapper.insert(article);
    }

    // 插入数据
    @Override
    public int insertSelective(Article article) {
        return articleMapper.insertSelective(article);
    }

    // 根据ID查询单个数据
    @Override
    public Article selectByPrimaryKey(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKeySelective(Article article) {
        return articleMapper.updateByPrimaryKeySelective(article);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKey(Article article) {
        return articleMapper.updateByPrimaryKey(article);
    }

    // 根据条件查询分页数据
    @Override
    public List<Article> selectListByPaging(Integer page, Integer limit,String title, Integer userId) {
        return articleMapper.selectListByPaging(
            (page - 1) * limit,
            limit,
            title,
            userId
        );
    }

    // 根据条件查询数据条数
    @Override
    public int selectCountByPaging(String title, Integer userId) {
        return articleMapper.selectCountByPaging(
            title,
            userId
        );
    }

    // 查询全部数据
    @Override
    public List<Article> selectAll() {
        return articleMapper.selectAll();
    }

    // 根据条件查询列表数据
    @Override
    public List<Article> selectList(Article article) {
        return articleMapper.selectList(article);
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @Override
    public List<Article> selectListByLimit(String field, String sort, Integer limit) {
        return articleMapper.selectListByLimit(field, sort, limit);
    }

    // 根据字段查询列表数据
    @Override
    public List<Article> selectListByField(String field, Object value) {
        return articleMapper.selectListByField(field, value);
    }

    // 根据条件查询单个数据
    @Override
    public Article selectOne(Article article) {
        return articleMapper.selectOne(article);
    }

    // 根据ID查询详情数据
    @Override
    public Article selectOneByDetails(Integer id) {
        return articleMapper.selectOneByDetails(id);
    }

    // 查询全部条数
    @Override
    public int selectAllCount() {
        return articleMapper.selectAllCount();
    }

    // 根据条件查询数据条数
    @Override
    public int selectCount(Article article) {
        return articleMapper.selectCount(article);
    }

    // 根据条件修改全部数据
    @Override
    public int updateAll(Article article) {
        return articleMapper.updateAll(article);
    }


}
