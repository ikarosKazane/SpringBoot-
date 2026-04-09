package com.xbb.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import com.xbb.mapper.LeavesMapper;
import com.xbb.entity.Leaves;
import com.xbb.service.LeavesService;
import org.springframework.stereotype.Service;

@Service
public class LeavesServiceImpl implements LeavesService {

    @Resource
    private LeavesMapper leavesMapper;

    // 删除数据
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return leavesMapper.deleteByPrimaryKey(id);
    }

    // 插入数据
    @Override
    public int insert(Leaves leaves) {
        return leavesMapper.insert(leaves);
    }

    // 插入数据
    @Override
    public int insertSelective(Leaves leaves) {
        return leavesMapper.insertSelective(leaves);
    }

    // 根据ID查询单个数据
    @Override
    public Leaves selectByPrimaryKey(Integer id) {
        return leavesMapper.selectByPrimaryKey(id);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKeySelective(Leaves leaves) {
        return leavesMapper.updateByPrimaryKeySelective(leaves);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKey(Leaves leaves) {
        return leavesMapper.updateByPrimaryKey(leaves);
    }

    // 根据条件查询分页数据
    @Override
    public List<Leaves> selectListByPaging(Integer page, Integer limit,Integer userId, String content, String replyCon) {
        return leavesMapper.selectListByPaging(
            (page - 1) * limit,
            limit,
            userId,
            content,
            replyCon
        );
    }

    // 根据条件查询数据条数
    @Override
    public int selectCountByPaging(Integer userId, String content, String replyCon) {
        return leavesMapper.selectCountByPaging(
            userId,
            content,
            replyCon
        );
    }

    // 查询全部数据
    @Override
    public List<Leaves> selectAll() {
        return leavesMapper.selectAll();
    }

    // 根据条件查询列表数据
    @Override
    public List<Leaves> selectList(Leaves leaves) {
        return leavesMapper.selectList(leaves);
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @Override
    public List<Leaves> selectListByLimit(String field, String sort, Integer limit) {
        return leavesMapper.selectListByLimit(field, sort, limit);
    }

    // 根据字段查询列表数据
    @Override
    public List<Leaves> selectListByField(String field, Object value) {
        return leavesMapper.selectListByField(field, value);
    }

    // 根据条件查询单个数据
    @Override
    public Leaves selectOne(Leaves leaves) {
        return leavesMapper.selectOne(leaves);
    }

    // 根据ID查询详情数据
    @Override
    public Leaves selectOneByDetails(Integer id) {
        return leavesMapper.selectOneByDetails(id);
    }

    // 查询全部条数
    @Override
    public int selectAllCount() {
        return leavesMapper.selectAllCount();
    }

    // 根据条件查询数据条数
    @Override
    public int selectCount(Leaves leaves) {
        return leavesMapper.selectCount(leaves);
    }

    // 根据条件修改全部数据
    @Override
    public int updateAll(Leaves leaves) {
        return leavesMapper.updateAll(leaves);
    }

}
