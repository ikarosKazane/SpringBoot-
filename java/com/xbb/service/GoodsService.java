package com.xbb.service;

import java.util.Date;
import java.util.List;
import com.xbb.entity.Goods;
import com.xbb.entity.Statistics;

public interface GoodsService {

    // 删除数据
    int deleteByPrimaryKey(Integer id);

    // 插入数据
    int insert(Goods goods);

    // 插入数据
    int insertSelective(Goods goods);

    // 根据ID查询单个数据
    Goods selectByPrimaryKey(Integer id);

    // 修改数据
    int updateByPrimaryKeySelective(Goods goods);

    // 修改数据
    int updateByPrimaryKey(Goods goods);

    // 根据条件查询分页数据
    List<Goods> selectListByPaging(
            Integer page,
            Integer limit,
            String name,
            Integer goodsTypeId,
            Boolean status,
            Integer userId,
            Date creatDate,
            String brand,
            String model
    );

    // 根据条件查询分页数据条数
    int selectCountByPaging(
            String name,
            Integer goodsTypeId,
            Boolean status,
            Integer userId,
            Date creatDate,
            String brand,
            String model
    );

    // 查询全部数据
    List<Goods> selectAll();

    // 根据条件查询列表数据
    List<Goods> selectList(Goods goods);

    // 根据字段、排序方式、limit条 查询列表数据
    List<Goods> selectListByLimit(
            String field,
            String sort,
            Integer limit
    );

    // 根据字段查询列表数据
    List<Goods> selectListByField(
            String field,
            Object value
    );

    // 根据条件查询单个数据
    Goods selectOne(Goods goods);

    // 根据ID查询详情数据
    Goods selectOneByDetails(Integer id);

    // 查询全部条数
    int selectAllCount();

    // 根据条件查询数据条数
    int selectCount(Goods goods);

    // 根据条件修改全部数据
    int updateAll(Goods goods);

    List<Statistics> selectStatisticsByType();

    List<Statistics> selectStatisticsBySalesVolume();

    List<Statistics> selectStatisticsByMoney();

    List<Statistics> selectStatisticsByDuration();

    List<Statistics> selectStatisticsByRepair();
}
