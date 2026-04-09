package com.xbb.service;

import java.util.Date;
import java.util.List;
import com.xbb.entity.User;

public interface UserService {

    // 删除数据
    int deleteByPrimaryKey(Integer id);

    // 插入数据
    int insert(User user);

    // 插入数据
    int insertSelective(User user);

    // 根据ID查询单个数据
    User selectByPrimaryKey(Integer id);

    // 修改数据
    int updateByPrimaryKeySelective(User user);

    // 修改数据
    int updateByPrimaryKey(User user);

    // 根据条件查询分页数据
    List<User> selectListByPaging(
            Integer page,
            Integer limit,
            String sex,
            String cellphone,
            String name,
            Integer role
    );

    // 根据条件查询分页数据条数
    int selectCountByPaging(
            String sex,
            String cellphone,
            String name,
            Integer role
    );

    // 查询全部数据
    List<User> selectAll();

    // 根据条件查询列表数据
    List<User> selectList(User user);

    // 根据字段、排序方式、limit条 查询列表数据
    List<User> selectListByLimit(
            String field,
            String sort,
            Integer limit
    );

    // 根据字段查询列表数据
    List<User> selectListByField(
            String field,
            Object value
    );

    // 根据条件查询单个数据
    User selectOne(User user);

    // 根据ID查询详情数据
    User selectOneByDetails(Integer id);

    // 查询全部条数
    int selectAllCount();

    // 根据条件查询数据条数
    int selectCount(User user);

    // 根据条件修改全部数据
    int updateAll(User user);

    // 根据用户名查询单个数据
    User selectOneByUsername(String username);

    // 根据token查询单个数据
    User selectOneByToken(String token);
}
