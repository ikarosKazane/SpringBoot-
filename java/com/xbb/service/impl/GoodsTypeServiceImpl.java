package com.xbb.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import com.xbb.mapper.GoodsTypeMapper;
import com.xbb.entity.GoodsType;
import com.xbb.service.GoodsTypeService;
import org.springframework.stereotype.Service;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Resource
    private GoodsTypeMapper goodsTypeMapper;

    // 删除数据
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return goodsTypeMapper.deleteByPrimaryKey(id);
    }

    // 插入数据
    @Override
    public int insert(GoodsType goodsType) {
        return goodsTypeMapper.insert(goodsType);
    }

    // 插入数据
    @Override
    public int insertSelective(GoodsType goodsType) {
        return goodsTypeMapper.insertSelective(goodsType);
    }

    // 根据ID查询单个数据
    @Override
    public GoodsType selectByPrimaryKey(Integer id) {
        return goodsTypeMapper.selectByPrimaryKey(id);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKeySelective(GoodsType goodsType) {
        return goodsTypeMapper.updateByPrimaryKeySelective(goodsType);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKey(GoodsType goodsType) {
        return goodsTypeMapper.updateByPrimaryKey(goodsType);
    }

    // 根据条件查询分页数据
    @Override
    public List<GoodsType> selectListByPaging(Integer page, Integer limit,String name) {
        return goodsTypeMapper.selectListByPaging(
            (page - 1) * limit,
            limit,
            name
        );
    }

    // 根据条件查询数据条数
    @Override
    public int selectCountByPaging(String name) {
        return goodsTypeMapper.selectCountByPaging(
            name
        );
    }

    // 查询全部数据
    @Override
    public List<GoodsType> selectAll() {
        return goodsTypeMapper.selectAll();
    }

    // 根据条件查询列表数据
    @Override
    public List<GoodsType> selectList(GoodsType goodsType) {
        return goodsTypeMapper.selectList(goodsType);
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @Override
    public List<GoodsType> selectListByLimit(String field, String sort, Integer limit) {
        return goodsTypeMapper.selectListByLimit(field, sort, limit);
    }

    // 根据字段查询列表数据
    @Override
    public List<GoodsType> selectListByField(String field, Object value) {
        return goodsTypeMapper.selectListByField(field, value);
    }

    // 根据条件查询单个数据
    @Override
    public GoodsType selectOne(GoodsType goodsType) {
        return goodsTypeMapper.selectOne(goodsType);
    }

    // 根据ID查询详情数据
    @Override
    public GoodsType selectOneByDetails(Integer id) {
        return goodsTypeMapper.selectOneByDetails(id);
    }

    // 查询全部条数
    @Override
    public int selectAllCount() {
        return goodsTypeMapper.selectAllCount();
    }

    // 根据条件查询数据条数
    @Override
    public int selectCount(GoodsType goodsType) {
        return goodsTypeMapper.selectCount(goodsType);
    }

    // 根据条件修改全部数据
    @Override
    public int updateAll(GoodsType goodsType) {
        return goodsTypeMapper.updateAll(goodsType);
    }


}
