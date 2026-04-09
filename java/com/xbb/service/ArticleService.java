package com.xbb.service;

import java.util.Date;
import java.util.List;
import com.xbb.entity.Article;

public interface ArticleService {

    // 删除数据
    int deleteByPrimaryKey(Integer id);

    // 插入数据
    int insert(Article article);

    // 插入数据
    int insertSelective(Article article);

    // 根据ID查询单个数据
    Article selectByPrimaryKey(Integer id);

    // 修改数据
    int updateByPrimaryKeySelective(Article article);

    // 修改数据
    int updateByPrimaryKey(Article article);

    // 根据条件查询分页数据
    List<Article> selectListByPaging(
            Integer page,
            Integer limit,
            String title,
            Integer userId
    );

    // 根据条件查询分页数据条数
    int selectCountByPaging(
            String title,
            Integer userId
    );

    // 查询全部数据
    List<Article> selectAll();

    // 根据条件查询列表数据
    List<Article> selectList(Article article);

    // 根据字段、排序方式、limit条 查询列表数据
    List<Article> selectListByLimit(
            String field,
            String sort,
            Integer limit
    );

    // 根据字段查询列表数据
    List<Article> selectListByField(
            String field,
            Object value
    );

    // 根据条件查询单个数据
    Article selectOne(Article article);

    // 根据ID查询详情数据
    Article selectOneByDetails(Integer id);

    // 查询全部条数
    int selectAllCount();

    // 根据条件查询数据条数
    int selectCount(Article article);

    // 根据条件修改全部数据
    int updateAll(Article article);

}
