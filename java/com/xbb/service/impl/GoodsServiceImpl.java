package com.xbb.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.xbb.entity.Statistics;
import com.xbb.mapper.GoodsMapper;
import com.xbb.entity.Goods;
import com.xbb.service.GoodsService;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    // 删除数据
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return goodsMapper.deleteByPrimaryKey(id);
    }

    // 插入数据
    @Override
    public int insert(Goods goods) {
        return goodsMapper.insert(goods);
    }

    // 插入数据
    @Override
    public int insertSelective(Goods goods) {
        return goodsMapper.insertSelective(goods);
    }

    // 根据ID查询单个数据
    @Override
    public Goods selectByPrimaryKey(Integer id) {
        return goodsMapper.selectByPrimaryKey(id);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKeySelective(Goods goods) {
        return goodsMapper.updateByPrimaryKeySelective(goods);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKey(Goods goods) {
        return goodsMapper.updateByPrimaryKey(goods);
    }

    // 根据条件查询分页数据
    @Override
    public List<Goods> selectListByPaging(Integer page, Integer limit,String name, Integer goodsTypeId, Boolean status, Integer userId, Date creatDate, String brand, String model) {
        return goodsMapper.selectListByPaging(
                (page - 1) * limit,
                limit,
                name,
                goodsTypeId,
                status,
                userId,
                creatDate,
                brand,
                model
        );
    }

    // 根据条件查询数据条数
    @Override
    public int selectCountByPaging(String name, Integer goodsTypeId, Boolean status, Integer userId, Date creatDate, String brand, String model) {
        return goodsMapper.selectCountByPaging(
                name,
                goodsTypeId,
                status,
                userId,
                creatDate,
                brand,
                model
        );
    }

    // 查询全部数据
    @Override
    public List<Goods> selectAll() {
        return goodsMapper.selectAll();
    }

    // 根据条件查询列表数据
    @Override
    public List<Goods> selectList(Goods goods) {
        return goodsMapper.selectList(goods);
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @Override
    public List<Goods> selectListByLimit(String field, String sort, Integer limit) {
        return goodsMapper.selectListByLimit(field, sort, limit);
    }

    // 根据字段查询列表数据
    @Override
    public List<Goods> selectListByField(String field, Object value) {
        return goodsMapper.selectListByField(field, value);
    }

    // 根据条件查询单个数据
    @Override
    public Goods selectOne(Goods goods) {
        return goodsMapper.selectOne(goods);
    }

    // 根据ID查询详情数据
    @Override
    public Goods selectOneByDetails(Integer id) {
        return goodsMapper.selectOneByDetails(id);
    }

    // 查询全部条数
    @Override
    public int selectAllCount() {
        return goodsMapper.selectAllCount();
    }

    // 根据条件查询数据条数
    @Override
    public int selectCount(Goods goods) {
        return goodsMapper.selectCount(goods);
    }

    // 根据条件修改全部数据
    @Override
    public int updateAll(Goods goods) {
        return goodsMapper.updateAll(goods);
    }

    @Override
    public List<Statistics> selectStatisticsByType() {
        return goodsMapper.selectStatisticsByType();
    }

    @Override
    public List<Statistics> selectStatisticsBySalesVolume() {
        return goodsMapper.selectStatisticsBySalesVolume();
    }

    @Override
    public List<Statistics> selectStatisticsByMoney() {
        return goodsMapper.selectStatisticsByMoney();
    }

    @Override
    public List<Statistics> selectStatisticsByDuration() {
        return goodsMapper.selectStatisticsByDuration();
    }

    @Override
    public List<Statistics> selectStatisticsByRepair() {
        return goodsMapper.selectStatisticsByRepair();
    }
}

