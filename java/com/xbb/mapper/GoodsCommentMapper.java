package com.xbb.mapper;

import java.util.Date;
import java.util.List;
import com.xbb.entity.GoodsComment;
import org.apache.ibatis.annotations.Param;

public interface GoodsCommentMapper {

    // 删除数据
    int deleteByPrimaryKey(Integer id);

    // 插入数据
    int insert(GoodsComment goodsComment);

    // 插入数据
    int insertSelective(GoodsComment goodsComment);

    // 根据ID查询单个数据
    GoodsComment selectByPrimaryKey(Integer id);

    // 修改数据
    int updateByPrimaryKeySelective(GoodsComment goodsComment);

    // 修改数据
    int updateByPrimaryKey(GoodsComment goodsComment);

    // 查询分页数据
    List<GoodsComment> selectListByPaging(
            @Param("page") Integer page,
            @Param("limit") Integer limit,
            @Param("goodsId") Integer goodsId,
            @Param("userId") Integer userId,
            @Param("content") String content,
            @Param("name") String name,
            @Param("staffId") Integer staffId
    );

    // 查询分页数据条数
    int selectCountByPaging(
            @Param("goodsId") Integer goodsId,
            @Param("userId") Integer userId,
            @Param("content") String content,
            @Param("name") String name,
            @Param("staffId") Integer staffId
    );

    // 查询全部数据
    List<GoodsComment> selectAll();

    // 根据条件查询列表数据
    List<GoodsComment> selectList(GoodsComment goodsComment);

    // 根据字段、排序方式、limit条 查询列表数据
    List<GoodsComment> selectListByLimit(
            @Param("field") String field,
            @Param("sort") String sort,
            @Param("limit") Integer limit
    );

    // 根据字段查询列表数据
    List<GoodsComment> selectListByField(
            @Param("field") String field,
            @Param("value") Object value
    );

    // 根据条件查询单个数据
    GoodsComment selectOne(GoodsComment goodsComment);

    // 根据ID查询详情数据
    GoodsComment selectOneByDetails(Integer id);

    // 查询全部条数
    int selectAllCount();

    // 根据条件查询数据条数
    int selectCount(GoodsComment goodsComment);

    // 根据条件修改全部数据
    int updateAll(GoodsComment goodsComment);


}
