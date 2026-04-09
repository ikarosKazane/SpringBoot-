package com.xbb.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import com.xbb.mapper.LinksMapper;
import com.xbb.entity.Links;
import com.xbb.service.LinksService;
import org.springframework.stereotype.Service;

@Service
public class LinksServiceImpl implements LinksService {

    @Resource
    private LinksMapper linksMapper;

    // 删除数据
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return linksMapper.deleteByPrimaryKey(id);
    }

    // 插入数据
    @Override
    public int insert(Links links) {
        return linksMapper.insert(links);
    }

    // 插入数据
    @Override
    public int insertSelective(Links links) {
        return linksMapper.insertSelective(links);
    }

    // 根据ID查询单个数据
    @Override
    public Links selectByPrimaryKey(Integer id) {
        return linksMapper.selectByPrimaryKey(id);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKeySelective(Links links) {
        return linksMapper.updateByPrimaryKeySelective(links);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKey(Links links) {
        return linksMapper.updateByPrimaryKey(links);
    }

    // 根据条件查询分页数据
    @Override
    public List<Links> selectListByPaging(Integer page, Integer limit,String name) {
        return linksMapper.selectListByPaging(
            (page - 1) * limit,
            limit,
            name
        );
    }

    // 根据条件查询数据条数
    @Override
    public int selectCountByPaging(String name) {
        return linksMapper.selectCountByPaging(
            name
        );
    }

    // 查询全部数据
    @Override
    public List<Links> selectAll() {
        return linksMapper.selectAll();
    }

    // 根据条件查询列表数据
    @Override
    public List<Links> selectList(Links links) {
        return linksMapper.selectList(links);
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @Override
    public List<Links> selectListByLimit(String field, String sort, Integer limit) {
        return linksMapper.selectListByLimit(field, sort, limit);
    }

    // 根据字段查询列表数据
    @Override
    public List<Links> selectListByField(String field, Object value) {
        return linksMapper.selectListByField(field, value);
    }

    // 根据条件查询单个数据
    @Override
    public Links selectOne(Links links) {
        return linksMapper.selectOne(links);
    }

    // 根据ID查询详情数据
    @Override
    public Links selectOneByDetails(Integer id) {
        return linksMapper.selectOneByDetails(id);
    }

    // 查询全部条数
    @Override
    public int selectAllCount() {
        return linksMapper.selectAllCount();
    }

    // 根据条件查询数据条数
    @Override
    public int selectCount(Links links) {
        return linksMapper.selectCount(links);
    }

    // 根据条件修改全部数据
    @Override
    public int updateAll(Links links) {
        return linksMapper.updateAll(links);
    }


}
