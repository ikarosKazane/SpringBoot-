package com.xbb.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import com.xbb.mapper.AboutMapper;
import com.xbb.entity.About;
import com.xbb.service.AboutService;
import org.springframework.stereotype.Service;

@Service
public class AboutServiceImpl implements AboutService {

    @Resource
    private AboutMapper aboutMapper;

    // 删除数据
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return aboutMapper.deleteByPrimaryKey(id);
    }

    // 插入数据
    @Override
    public int insert(About about) {
        return aboutMapper.insert(about);
    }

    // 插入数据
    @Override
    public int insertSelective(About about) {
        return aboutMapper.insertSelective(about);
    }

    // 根据ID查询单个数据
    @Override
    public About selectByPrimaryKey(Integer id) {
        return aboutMapper.selectByPrimaryKey(id);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKeySelective(About about) {
        return aboutMapper.updateByPrimaryKeySelective(about);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKey(About about) {
        return aboutMapper.updateByPrimaryKey(about);
    }

    // 根据条件查询分页数据
    @Override
    public List<About> selectListByPaging(Integer page, Integer limit,String cellphone, String creatDate, Integer status, String name) {
        return aboutMapper.selectListByPaging(
            (page - 1) * limit,
            limit,
            cellphone,
            creatDate,
            status,
            name
        );
    }

    // 根据条件查询数据条数
    @Override
    public int selectCountByPaging(String cellphone, String creatDate, Integer status, String name) {
        return aboutMapper.selectCountByPaging(
            cellphone,
            creatDate,
            status,
            name
        );
    }

    // 查询全部数据
    @Override
    public List<About> selectAll() {
        return aboutMapper.selectAll();
    }

    // 根据条件查询列表数据
    @Override
    public List<About> selectList(About about) {
        return aboutMapper.selectList(about);
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @Override
    public List<About> selectListByLimit(String field, String sort, Integer limit) {
        return aboutMapper.selectListByLimit(field, sort, limit);
    }

    // 根据字段查询列表数据
    @Override
    public List<About> selectListByField(String field, Object value) {
        return aboutMapper.selectListByField(field, value);
    }

    // 根据条件查询单个数据
    @Override
    public About selectOne(About about) {
        return aboutMapper.selectOne(about);
    }

    // 根据ID查询详情数据
    @Override
    public About selectOneByDetails(Integer id) {
        return aboutMapper.selectOneByDetails(id);
    }

    // 查询全部条数
    @Override
    public int selectAllCount() {
        return aboutMapper.selectAllCount();
    }

    // 根据条件查询数据条数
    @Override
    public int selectCount(About about) {
        return aboutMapper.selectCount(about);
    }

    // 根据条件修改全部数据
    @Override
    public int updateAll(About about) {
        return aboutMapper.updateAll(about);
    }


}
