package com.xbb.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import com.xbb.mapper.NoticeMapper;
import com.xbb.entity.Notice;
import com.xbb.service.NoticeService;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Resource
    private NoticeMapper noticeMapper;

    // 删除数据
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return noticeMapper.deleteByPrimaryKey(id);
    }

    // 插入数据
    @Override
    public int insert(Notice notice) {
        return noticeMapper.insert(notice);
    }

    // 插入数据
    @Override
    public int insertSelective(Notice notice) {
        return noticeMapper.insertSelective(notice);
    }

    // 根据ID查询单个数据
    @Override
    public Notice selectByPrimaryKey(Integer id) {
        return noticeMapper.selectByPrimaryKey(id);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKeySelective(Notice notice) {
        return noticeMapper.updateByPrimaryKeySelective(notice);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKey(Notice notice) {
        return noticeMapper.updateByPrimaryKey(notice);
    }

    // 根据条件查询分页数据
    @Override
    public List<Notice> selectListByPaging(Integer page, Integer limit,String title, Integer userId) {
        return noticeMapper.selectListByPaging(
            (page - 1) * limit,
            limit,
            title,
            userId
        );
    }

    // 根据条件查询数据条数
    @Override
    public int selectCountByPaging(String title, Integer userId) {
        return noticeMapper.selectCountByPaging(
            title,
            userId
        );
    }

    // 查询全部数据
    @Override
    public List<Notice> selectAll() {
        return noticeMapper.selectAll();
    }

    // 根据条件查询列表数据
    @Override
    public List<Notice> selectList(Notice notice) {
        return noticeMapper.selectList(notice);
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @Override
    public List<Notice> selectListByLimit(String field, String sort, Integer limit) {
        return noticeMapper.selectListByLimit(field, sort, limit);
    }

    // 根据字段查询列表数据
    @Override
    public List<Notice> selectListByField(String field, Object value) {
        return noticeMapper.selectListByField(field, value);
    }

    // 根据条件查询单个数据
    @Override
    public Notice selectOne(Notice notice) {
        return noticeMapper.selectOne(notice);
    }

    // 根据ID查询详情数据
    @Override
    public Notice selectOneByDetails(Integer id) {
        return noticeMapper.selectOneByDetails(id);
    }

    // 查询全部条数
    @Override
    public int selectAllCount() {
        return noticeMapper.selectAllCount();
    }

    // 根据条件查询数据条数
    @Override
    public int selectCount(Notice notice) {
        return noticeMapper.selectCount(notice);
    }

    // 根据条件修改全部数据
    @Override
    public int updateAll(Notice notice) {
        return noticeMapper.updateAll(notice);
    }


}
