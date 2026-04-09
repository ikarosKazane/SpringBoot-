package com.xbb.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import com.xbb.mapper.GoodsOrdersMapper;
import com.xbb.entity.GoodsOrders;
import com.xbb.service.GoodsOrdersService;
import org.springframework.stereotype.Service;

@Service
public class GoodsOrdersServiceImpl implements GoodsOrdersService {

    @Resource
    private GoodsOrdersMapper goodsOrdersMapper;

    // 删除数据
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return goodsOrdersMapper.deleteByPrimaryKey(id);
    }

    // 插入数据
    @Override
    public int insert(GoodsOrders goodsOrders) {
        return goodsOrdersMapper.insert(goodsOrders);
    }

    // 插入数据
    @Override
    public int insertSelective(GoodsOrders goodsOrders) {
        return goodsOrdersMapper.insertSelective(goodsOrders);
    }

    // 根据ID查询单个数据
    @Override
    public GoodsOrders selectByPrimaryKey(Integer id) {
        return goodsOrdersMapper.selectByPrimaryKey(id);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKeySelective(GoodsOrders goodsOrders) {
        return goodsOrdersMapper.updateByPrimaryKeySelective(goodsOrders);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKey(GoodsOrders goodsOrders) {
        return goodsOrdersMapper.updateByPrimaryKey(goodsOrders);
    }

    // 根据条件查询分页数据
    @Override
    public List<GoodsOrders> selectListByPaging(Integer page, Integer limit,Integer goodsId, String number, Date creatDate, Integer userId, Integer status,Integer staffId) {
        return goodsOrdersMapper.selectListByPaging(
            (page - 1) * limit,
            limit,
            goodsId,
            number,
            creatDate,
            userId,
            status,
                staffId
        );
    }

    // 根据条件查询数据条数
    @Override
    public int selectCountByPaging(Integer goodsId, String number, Date creatDate, Integer userId, Integer status,Integer staffId) {
        return goodsOrdersMapper.selectCountByPaging(
            goodsId,
            number,
            creatDate,
            userId,
            status,
                staffId
        );
    }

    // 查询全部数据
    @Override
    public List<GoodsOrders> selectAll() {
        return goodsOrdersMapper.selectAll();
    }

    // 根据条件查询列表数据
    @Override
    public List<GoodsOrders> selectList(GoodsOrders goodsOrders) {
        return goodsOrdersMapper.selectList(goodsOrders);
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @Override
    public List<GoodsOrders> selectListByLimit(String field, String sort, Integer limit) {
        return goodsOrdersMapper.selectListByLimit(field, sort, limit);
    }

    // 根据字段查询列表数据
    @Override
    public List<GoodsOrders> selectListByField(String field, Object value) {
        return goodsOrdersMapper.selectListByField(field, value);
    }

    // 根据条件查询单个数据
    @Override
    public GoodsOrders selectOne(GoodsOrders goodsOrders) {
        return goodsOrdersMapper.selectOne(goodsOrders);
    }

    // 根据ID查询详情数据
    @Override
    public GoodsOrders selectOneByDetails(Integer id) {
        return goodsOrdersMapper.selectOneByDetails(id);
    }

    // 查询全部条数
    @Override
    public int selectAllCount() {
        return goodsOrdersMapper.selectAllCount();
    }

    // 根据条件查询数据条数
    @Override
    public int selectCount(GoodsOrders goodsOrders) {
        return goodsOrdersMapper.selectCount(goodsOrders);
    }

    // 根据条件修改全部数据
    @Override
    public int updateAll(GoodsOrders goodsOrders) {
        return goodsOrdersMapper.updateAll(goodsOrders);
    }

    @Override
    public List<GoodsOrders> selectListByUserId(Integer userId, String date) {
        return goodsOrdersMapper.selectListByUserId(userId, date);
    }
}
