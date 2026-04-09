package com.xbb.mapper;

import java.util.Date;
import java.util.List;
import com.xbb.entity.GoodsCollect;
import org.apache.ibatis.annotations.Param;

public interface GoodsCollectMapper {

    // 删除数据
    int deleteByPrimaryKey(Integer id);

    // 插入数据
    int insert(GoodsCollect goodsCollect);

    // 插入数据
    int insertSelective(GoodsCollect goodsCollect);

    // 根据ID查询单个数据
    GoodsCollect selectByPrimaryKey(Integer id);

    // 修改数据
    int updateByPrimaryKeySelective(GoodsCollect goodsCollect);

    // 修改数据
    int updateByPrimaryKey(GoodsCollect goodsCollect);

    // 查询分页数据
    List<GoodsCollect> selectListByPaging(
            @Param("page") Integer page,
            @Param("limit") Integer limit,
            @Param("goodsId") Integer goodsId,
            @Param("userId") Integer userId,
            @Param("name") String name
    );

    // 查询分页数据条数
    int selectCountByPaging(
            @Param("goodsId") Integer goodsId,
            @Param("userId") Integer userId,
            @Param("name") String name
    );

    // 查询全部数据
    List<GoodsCollect> selectAll();

    // 根据条件查询列表数据
    List<GoodsCollect> selectList(GoodsCollect goodsCollect);

    // 根据字段、排序方式、limit条 查询列表数据
    List<GoodsCollect> selectListByLimit(
            @Param("field") String field,
            @Param("sort") String sort,
            @Param("limit") Integer limit
    );

    // 根据字段查询列表数据
    List<GoodsCollect> selectListByField(
            @Param("field") String field,
            @Param("value") Object value
    );

    // 根据条件查询单个数据
    GoodsCollect selectOne(GoodsCollect goodsCollect);

    // 根据ID查询详情数据
    GoodsCollect selectOneByDetails(Integer id);

    // 查询全部条数
    int selectAllCount();

    // 根据条件查询数据条数
    int selectCount(GoodsCollect goodsCollect);

    // 根据条件修改全部数据
    int updateAll(GoodsCollect goodsCollect);


}
