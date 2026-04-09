package com.xbb.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import com.xbb.mapper.BannerMapper;
import com.xbb.entity.Banner;
import com.xbb.service.BannerService;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImpl implements BannerService {

    @Resource
    private BannerMapper bannerMapper;

    // 删除数据
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return bannerMapper.deleteByPrimaryKey(id);
    }

    // 插入数据
    @Override
    public int insert(Banner banner) {
        return bannerMapper.insert(banner);
    }

    // 插入数据
    @Override
    public int insertSelective(Banner banner) {
        return bannerMapper.insertSelective(banner);
    }

    // 根据ID查询单个数据
    @Override
    public Banner selectByPrimaryKey(Integer id) {
        return bannerMapper.selectByPrimaryKey(id);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKeySelective(Banner banner) {
        return bannerMapper.updateByPrimaryKeySelective(banner);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKey(Banner banner) {
        return bannerMapper.updateByPrimaryKey(banner);
    }

    // 根据条件查询分页数据
    @Override
    public List<Banner> selectListByPaging(Integer page, Integer limit,Boolean status, String name) {
        return bannerMapper.selectListByPaging(
            (page - 1) * limit,
            limit,
            status,
            name
        );
    }

    // 根据条件查询数据条数
    @Override
    public int selectCountByPaging(Boolean status, String name) {
        return bannerMapper.selectCountByPaging(
            status,
            name
        );
    }

    // 查询全部数据
    @Override
    public List<Banner> selectAll() {
        return bannerMapper.selectAll();
    }

    // 根据条件查询列表数据
    @Override
    public List<Banner> selectList(Banner banner) {
        return bannerMapper.selectList(banner);
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @Override
    public List<Banner> selectListByLimit(String field, String sort, Integer limit) {
        return bannerMapper.selectListByLimit(field, sort, limit);
    }

    // 根据字段查询列表数据
    @Override
    public List<Banner> selectListByField(String field, Object value) {
        return bannerMapper.selectListByField(field, value);
    }

    // 根据条件查询单个数据
    @Override
    public Banner selectOne(Banner banner) {
        return bannerMapper.selectOne(banner);
    }

    // 根据ID查询详情数据
    @Override
    public Banner selectOneByDetails(Integer id) {
        return bannerMapper.selectOneByDetails(id);
    }

    // 查询全部条数
    @Override
    public int selectAllCount() {
        return bannerMapper.selectAllCount();
    }

    // 根据条件查询数据条数
    @Override
    public int selectCount(Banner banner) {
        return bannerMapper.selectCount(banner);
    }

    // 根据条件修改全部数据
    @Override
    public int updateAll(Banner banner) {
        return bannerMapper.updateAll(banner);
    }

}
