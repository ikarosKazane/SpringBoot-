package com.xbb.service;

import java.util.Date;
import java.util.List;
import com.xbb.entity.GoodsComment;

public interface GoodsCommentService {

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

    // 根据条件查询分页数据
    List<GoodsComment> selectListByPaging(
            Integer page,
            Integer limit,
            Integer goodsId,
            Integer userId,
            String content,
            String name,
            Integer staffId
    );

    // 根据条件查询分页数据条数
    int selectCountByPaging(
            Integer goodsId,
            Integer userId,
            String content,
            String name,
            Integer staffId
    );

    // 查询全部数据
    List<GoodsComment> selectAll();

    // 根据条件查询列表数据
    List<GoodsComment> selectList(GoodsComment goodsComment);

    // 根据字段、排序方式、limit条 查询列表数据
    List<GoodsComment> selectListByLimit(
            String field,
            String sort,
            Integer limit
    );

    // 根据字段查询列表数据
    List<GoodsComment> selectListByField(
            String field,
            Object value
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
