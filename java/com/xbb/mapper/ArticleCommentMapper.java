package com.xbb.mapper;

import java.util.Date;
import java.util.List;
import com.xbb.entity.ArticleComment;
import org.apache.ibatis.annotations.Param;

public interface ArticleCommentMapper {

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

    // 查询分页数据
    List<ArticleComment> selectListByPaging(
            @Param("page") Integer page,
            @Param("limit") Integer limit,
            @Param("userId") Integer userId,
            @Param("articleId") Integer articleId,
            @Param("title") String title,
            @Param("content") String content
    );

    // 查询分页数据条数
    int selectCountByPaging(
            @Param("userId") Integer userId,
            @Param("articleId") Integer articleId,
            @Param("title") String title,
            @Param("content") String content
    );

    // 查询全部数据
    List<ArticleComment> selectAll();

    // 根据条件查询列表数据
    List<ArticleComment> selectList(ArticleComment articleComment);

    // 根据字段、排序方式、limit条 查询列表数据
    List<ArticleComment> selectListByLimit(
            @Param("field") String field,
            @Param("sort") String sort,
            @Param("limit") Integer limit
    );

    // 根据字段查询列表数据
    List<ArticleComment> selectListByField(
            @Param("field") String field,
            @Param("value") Object value
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
