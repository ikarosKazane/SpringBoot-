package com.xbb.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import com.xbb.mapper.GoodsCollectMapper;
import com.xbb.entity.GoodsCollect;
import com.xbb.service.GoodsCollectService;
import org.springframework.stereotype.Service;

@Service
public class GoodsCollectServiceImpl implements GoodsCollectService {

    @Resource
    private GoodsCollectMapper goodsCollectMapper;

    // 删除数据
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return goodsCollectMapper.deleteByPrimaryKey(id);
    }

    // 插入数据
    @Override
    public int insert(GoodsCollect goodsCollect) {
        return goodsCollectMapper.insert(goodsCollect);
    }

    // 插入数据
    @Override
    public int insertSelective(GoodsCollect goodsCollect) {
        return goodsCollectMapper.insertSelective(goodsCollect);
    }

    // 根据ID查询单个数据
    @Override
    public GoodsCollect selectByPrimaryKey(Integer id) {
        return goodsCollectMapper.selectByPrimaryKey(id);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKeySelective(GoodsCollect goodsCollect) {
        return goodsCollectMapper.updateByPrimaryKeySelective(goodsCollect);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKey(GoodsCollect goodsCollect) {
        return goodsCollectMapper.updateByPrimaryKey(goodsCollect);
    }

    // 根据条件查询分页数据
    @Override
    public List<GoodsCollect> selectListByPaging(Integer page, Integer limit,Integer goodsId, Integer userId, String name) {
        return goodsCollectMapper.selectListByPaging(
            (page - 1) * limit,
            limit,
            goodsId,
            userId,
                name
        );
    }

    // 根据条件查询数据条数
    @Override
    public int selectCountByPaging(Integer goodsId, Integer userId, String name) {
        return goodsCollectMapper.selectCountByPaging(
            goodsId,
            userId,
                name
        );
    }

    // 查询全部数据
    @Override
    public List<GoodsCollect> selectAll() {
        return goodsCollectMapper.selectAll();
    }

    // 根据条件查询列表数据
    @Override
    public List<GoodsCollect> selectList(GoodsCollect goodsCollect) {
        return goodsCollectMapper.selectList(goodsCollect);
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @Override
    public List<GoodsCollect> selectListByLimit(String field, String sort, Integer limit) {
        return goodsCollectMapper.selectListByLimit(field, sort, limit);
    }

    // 根据字段查询列表数据
    @Override
    public List<GoodsCollect> selectListByField(String field, Object value) {
        return goodsCollectMapper.selectListByField(field, value);
    }

    // 根据条件查询单个数据
    @Override
    public GoodsCollect selectOne(GoodsCollect goodsCollect) {
        return goodsCollectMapper.selectOne(goodsCollect);
    }

    // 根据ID查询详情数据
    @Override
    public GoodsCollect selectOneByDetails(Integer id) {
        return goodsCollectMapper.selectOneByDetails(id);
    }

    // 查询全部条数
    @Override
    public int selectAllCount() {
        return goodsCollectMapper.selectAllCount();
    }

    // 根据条件查询数据条数
    @Override
    public int selectCount(GoodsCollect goodsCollect) {
        return goodsCollectMapper.selectCount(goodsCollect);
    }

    // 根据条件修改全部数据
    @Override
    public int updateAll(GoodsCollect goodsCollect) {
        return goodsCollectMapper.updateAll(goodsCollect);
    }


}
