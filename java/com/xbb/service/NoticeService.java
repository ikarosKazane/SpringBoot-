package com.xbb.service;

import java.util.Date;
import java.util.List;
import com.xbb.entity.Notice;

public interface NoticeService {

    // 删除数据
    int deleteByPrimaryKey(Integer id);

    // 插入数据
    int insert(Notice notice);

    // 插入数据
    int insertSelective(Notice notice);

    // 根据ID查询单个数据
    Notice selectByPrimaryKey(Integer id);

    // 修改数据
    int updateByPrimaryKeySelective(Notice notice);

    // 修改数据
    int updateByPrimaryKey(Notice notice);

    // 根据条件查询分页数据
    List<Notice> selectListByPaging(
            Integer page,
            Integer limit,
            String title,
            Integer userId
    );

    // 根据条件查询分页数据条数
    int selectCountByPaging(
            String title,
            Integer userId
    );

    // 查询全部数据
    List<Notice> selectAll();

    // 根据条件查询列表数据
    List<Notice> selectList(Notice notice);

    // 根据字段、排序方式、limit条 查询列表数据
    List<Notice> selectListByLimit(
            String field,
            String sort,
            Integer limit
    );

    // 根据字段查询列表数据
    List<Notice> selectListByField(
            String field,
            Object value
    );

    // 根据条件查询单个数据
    Notice selectOne(Notice notice);

    // 根据ID查询详情数据
    Notice selectOneByDetails(Integer id);

    // 查询全部条数
    int selectAllCount();

    // 根据条件查询数据条数
    int selectCount(Notice notice);

    // 根据条件修改全部数据
    int updateAll(Notice notice);

}
