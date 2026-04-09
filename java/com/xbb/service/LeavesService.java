package com.xbb.service;

import java.util.Date;
import java.util.List;
import com.xbb.entity.Leaves;

public interface LeavesService {

    // 删除数据
    int deleteByPrimaryKey(Integer id);

    // 插入数据
    int insert(Leaves leaves);

    // 插入数据
    int insertSelective(Leaves leaves);

    // 根据ID查询单个数据
    Leaves selectByPrimaryKey(Integer id);

    // 修改数据
    int updateByPrimaryKeySelective(Leaves leaves);

    // 修改数据
    int updateByPrimaryKey(Leaves leaves);

    // 根据条件查询分页数据
    List<Leaves> selectListByPaging(
            Integer page,
            Integer limit,
            Integer userId,
            String content,
            String replyCon
    );

    // 根据条件查询分页数据条数
    int selectCountByPaging(
            Integer userId,
            String content,
            String replyCon
    );

    // 查询全部数据
    List<Leaves> selectAll();

    // 根据条件查询列表数据
    List<Leaves> selectList(Leaves leaves);

    // 根据字段、排序方式、limit条 查询列表数据
    List<Leaves> selectListByLimit(
            String field,
            String sort,
            Integer limit
    );

    // 根据字段查询列表数据
    List<Leaves> selectListByField(
            String field,
            Object value
    );

    // 根据条件查询单个数据
    Leaves selectOne(Leaves leaves);

    // 根据ID查询详情数据
    Leaves selectOneByDetails(Integer id);

    // 查询全部条数
    int selectAllCount();

    // 根据条件查询数据条数
    int selectCount(Leaves leaves);

    // 根据条件修改全部数据
    int updateAll(Leaves leaves);

}
