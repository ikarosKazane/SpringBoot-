package com.xbb.service;

import java.util.Date;
import java.util.List;
import com.xbb.entity.ArticleComment;

public interface ArticleCommentService {

    // 删除数据
    int deleteByPrimaryKey(Integer id);

    // 插入数据
    int insert(ArticleComment articleComment);

    // 插入数据
    int insertSelective(ArticleComment articleComment);

    // 根据ID查询单个数据
    ArticleComment selectByPrimaryKey(Integer id);

    // 修改数据
    int updateByPrimaryKeySelective(ArticleComment articleComment);

    // 修改数据
    int updateByPrimaryKey(ArticleComment articleComment);

    // 根据条件查询分页数据
    List<ArticleComment> selectListByPaging(
            Integer page,
            Integer limit,
            Integer userId,
            Integer articleId,
            String title,
            String content
    );

    // 根据条件查询分页数据条数
    int selectCountByPaging(
            Integer userId,
            Integer articleId,
            String title,
            String content
    );

    // 查询全部数据
    List<ArticleComment> selectAll();

    // 根据条件查询列表数据
    List<ArticleComment> selectList(ArticleComment articleComment);

    // 根据字段、排序方式、limit条 查询列表数据
    List<ArticleComment> selectListByLimit(
            String field,
            String sort,
            Integer limit
    );

    // 根据字段查询列表数据
    List<ArticleComment> selectListByField(
            String field,
            Object value
    );

    // 根据条件查询单个数据
    ArticleComment selectOne(ArticleComment articleComment);

    // 根据ID查询详情数据
    ArticleComment selectOneByDetails(Integer id);

    // 查询全部条数
    int selectAllCount();

    // 根据条件查询数据条数
    int selectCount(ArticleComment articleComment);

    // 根据条件修改全部数据
    int updateAll(ArticleComment articleComment);

}
