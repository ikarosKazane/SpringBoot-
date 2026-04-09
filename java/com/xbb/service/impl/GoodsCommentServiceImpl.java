package com.xbb.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import com.xbb.mapper.GoodsCommentMapper;
import com.xbb.entity.GoodsComment;
import com.xbb.service.GoodsCommentService;
import org.springframework.stereotype.Service;

@Service
public class GoodsCommentServiceImpl implements GoodsCommentService {

    @Resource
    private GoodsCommentMapper goodsCommentMapper;

    // 删除数据
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return goodsCommentMapper.deleteByPrimaryKey(id);
    }

    // 插入数据
    @Override
    public int insert(GoodsComment goodsComment) {
        return goodsCommentMapper.insert(goodsComment);
    }

    // 插入数据
    @Override
    public int insertSelective(GoodsComment goodsComment) {
        return goodsCommentMapper.insertSelective(goodsComment);
    }

    // 根据ID查询单个数据
    @Override
    public GoodsComment selectByPrimaryKey(Integer id) {
        return goodsCommentMapper.selectByPrimaryKey(id);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKeySelective(GoodsComment goodsComment) {
        return goodsCommentMapper.updateByPrimaryKeySelective(goodsComment);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKey(GoodsComment goodsComment) {
        return goodsCommentMapper.updateByPrimaryKey(goodsComment);
    }

    // 根据条件查询分页数据
    @Override
    public List<GoodsComment> selectListByPaging(Integer page, Integer limit,Integer goodsId, Integer userId, String content,String name,Integer staffId) {
        return goodsCommentMapper.selectListByPaging(
            (page - 1) * limit,
            limit,
            goodsId,
            userId,
            content,
                name,
                staffId
        );
    }

    // 根据条件查询数据条数
    @Override
    public int selectCountByPaging(Integer goodsId, Integer userId, String content,String name,Integer staffId) {
        return goodsCommentMapper.selectCountByPaging(
            goodsId,
            userId,
            content,
                name,
                staffId
        );
    }

    // 查询全部数据
    @Override
    public List<GoodsComment> selectAll() {
        return goodsCommentMapper.selectAll();
    }

    // 根据条件查询列表数据
    @Override
    public List<GoodsComment> selectList(GoodsComment goodsComment) {
        return goodsCommentMapper.selectList(goodsComment);
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @Override
    public List<GoodsComment> selectListByLimit(String field, String sort, Integer limit) {
        return goodsCommentMapper.selectListByLimit(field, sort, limit);
    }

    // 根据字段查询列表数据
    @Override
    public List<GoodsComment> selectListByField(String field, Object value) {
        return goodsCommentMapper.selectListByField(field, value);
    }

    // 根据条件查询单个数据
    @Override
    public GoodsComment selectOne(GoodsComment goodsComment) {
        return goodsCommentMapper.selectOne(goodsComment);
    }

    // 根据ID查询详情数据
    @Override
    public GoodsComment selectOneByDetails(Integer id) {
        return goodsCommentMapper.selectOneByDetails(id);
    }

    // 查询全部条数
    @Override
    public int selectAllCount() {
        return goodsCommentMapper.selectAllCount();
    }

    // 根据条件查询数据条数
    @Override
    public int selectCount(GoodsComment goodsComment) {
        return goodsCommentMapper.selectCount(goodsComment);
    }

    // 根据条件修改全部数据
    @Override
    public int updateAll(GoodsComment goodsComment) {
        return goodsCommentMapper.updateAll(goodsComment);
    }


}
