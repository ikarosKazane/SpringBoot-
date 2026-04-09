package com.xbb.mapper;

import java.util.Date;
import java.util.List;
import com.xbb.entity.GoodsType;
import org.apache.ibatis.annotations.Param;

public interface GoodsTypeMapper {

    // 删除数据
    int deleteByPrimaryKey(Integer id);

    // 插入数据
    int insert(GoodsType goodsType);

    // 插入数据
    int insertSelective(GoodsType goodsType);

    // 根据ID查询单个数据
    GoodsType selectByPrimaryKey(Integer id);

    // 修改数据
    int updateByPrimaryKeySelective(GoodsType goodsType);

    // 修改数据
    int updateByPrimaryKey(GoodsType goodsType);

    // 查询分页数据
    List<GoodsType> selectListByPaging(
            @Param("page") Integer page,
            @Param("limit") Integer limit,
            @Param("name") String name
    );

    // 查询分页数据条数
    int selectCountByPaging(
            @Param("name") String name
    );

    // 查询全部数据
    List<GoodsType> selectAll();

    // 根据条件查询列表数据
    List<GoodsType> selectList(GoodsType goodsType);

    // 根据字段、排序方式、limit条 查询列表数据
    List<GoodsType> selectListByLimit(
            @Param("field") String field,
            @Param("sort") String sort,
            @Param("limit") Integer limit
    );

    // 根据字段查询列表数据
    List<GoodsType> selectListByField(
            @Param("field") String field,
            @Param("value") Object value
    );

    // 根据条件查询单个数据
    GoodsType selectOne(GoodsType goodsType);

    // 根据ID查询详情数据
    GoodsType selectOneByDetails(Integer id);

    // 查询全部条数
    int selectAllCount();

    // 根据条件查询数据条数
    int selectCount(GoodsType goodsType);

    // 根据条件修改全部数据
    int updateAll(GoodsType goodsType);


}
