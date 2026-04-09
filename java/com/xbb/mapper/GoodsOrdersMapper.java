package com.xbb.mapper;

import java.util.Date;
import java.util.List;
import com.xbb.entity.GoodsOrders;
import org.apache.ibatis.annotations.Param;

public interface GoodsOrdersMapper {

    // 删除数据
    int deleteByPrimaryKey(Integer id);

    // 插入数据
    int insert(GoodsOrders goodsOrders);

    // 插入数据
    int insertSelective(GoodsOrders goodsOrders);

    // 根据ID查询单个数据
    GoodsOrders selectByPrimaryKey(Integer id);

    // 修改数据
    int updateByPrimaryKeySelective(GoodsOrders goodsOrders);

    // 修改数据
    int updateByPrimaryKey(GoodsOrders goodsOrders);

    // 查询分页数据
    List<GoodsOrders> selectListByPaging(
            @Param("page") Integer page,
            @Param("limit") Integer limit,
            @Param("goodsId") Integer goodsId,
            @Param("number") String number,
            @Param("creatDate") Date creatDate,
            @Param("userId") Integer userId,
            @Param("status") Integer status,
            @Param("staffId") Integer staffId
    );

    // 查询分页数据条数
    int selectCountByPaging(
            @Param("goodsId") Integer goodsId,
            @Param("number") String number,
            @Param("creatDate") Date creatDate,
            @Param("userId") Integer userId,
            @Param("status") Integer status,
            @Param("staffId") Integer staffId
    );

    // 查询全部数据
    List<GoodsOrders> selectAll();

    // 根据条件查询列表数据
    List<GoodsOrders> selectList(GoodsOrders goodsOrders);

    // 根据字段、排序方式、limit条 查询列表数据
    List<GoodsOrders> selectListByLimit(
            @Param("field") String field,
            @Param("sort") String sort,
            @Param("limit") Integer limit
    );

    // 根据字段查询列表数据
    List<GoodsOrders> selectListByField(
            @Param("field") String field,
            @Param("value") Object value
    );

    // 根据条件查询单个数据
    GoodsOrders selectOne(GoodsOrders goodsOrders);

    // 根据ID查询详情数据
    GoodsOrders selectOneByDetails(Integer id);

    // 查询全部条数
    int selectAllCount();

    // 根据条件查询数据条数
    int selectCount(GoodsOrders goodsOrders);

    // 根据条件修改全部数据
    int updateAll(GoodsOrders goodsOrders);

    List<GoodsOrders> selectListByUserId(
            @Param("userId") Integer userId,
            @Param("date") String date
    );
}
