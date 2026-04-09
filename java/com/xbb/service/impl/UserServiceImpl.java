package com.xbb.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import com.xbb.mapper.UserMapper;
import com.xbb.entity.User;
import com.xbb.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    // 删除数据
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    // 插入数据
    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    // 插入数据
    @Override
    public int insertSelective(User user) {
        return userMapper.insertSelective(user);
    }

    // 根据ID查询单个数据
    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKeySelective(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKey(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    // 根据条件查询分页数据
    @Override
    public List<User> selectListByPaging(Integer page, Integer limit,String sex, String cellphone, String name, Integer role) {
        return userMapper.selectListByPaging(
            (page - 1) * limit,
            limit,
            sex,
            cellphone,
            name,
            role
        );
    }

    // 根据条件查询数据条数
    @Override
    public int selectCountByPaging(String sex, String cellphone, String name, Integer role) {
        return userMapper.selectCountByPaging(
            sex,
            cellphone,
            name,
            role
        );
    }

    // 查询全部数据
    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    // 根据条件查询列表数据
    @Override
    public List<User> selectList(User user) {
        return userMapper.selectList(user);
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @Override
    public List<User> selectListByLimit(String field, String sort, Integer limit) {
        return userMapper.selectListByLimit(field, sort, limit);
    }

    // 根据字段查询列表数据
    @Override
    public List<User> selectListByField(String field, Object value) {
        return userMapper.selectListByField(field, value);
    }

    // 根据条件查询单个数据
    @Override
    public User selectOne(User user) {
        return userMapper.selectOne(user);
    }

    // 根据ID查询详情数据
    @Override
    public User selectOneByDetails(Integer id) {
        return userMapper.selectOneByDetails(id);
    }

    // 查询全部条数
    @Override
    public int selectAllCount() {
        return userMapper.selectAllCount();
    }

    // 根据条件查询数据条数
    @Override
    public int selectCount(User user) {
        return userMapper.selectCount(user);
    }

    // 根据条件修改全部数据
    @Override
    public int updateAll(User user) {
        return userMapper.updateAll(user);
    }

    // 根据用户名查询单个数据
    @Override
    public User selectOneByUsername(String username) {
        return userMapper.selectOneByUsername(username);
    }

    // 根据token查询单个数据
    @Override
    public User selectOneByToken(String token) {
        return userMapper.selectOneByToken(token);
    }
}
