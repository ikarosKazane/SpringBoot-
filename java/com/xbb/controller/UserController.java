package com.xbb.controller;

import com.xbb.common.RespResult;
import com.xbb.constant.SessionConstant;
import com.xbb.entity.User;
import com.xbb.entity.User;
import com.xbb.service.UserService;
import com.xbb.util.TokenUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 用户Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    // 根据条件查询分页数据及条数
    @RequestMapping("/data")
    public RespResult data(@RequestParam("page") int page,
                           @RequestParam("limit") int limit,
                           @RequestParam(value = "sex", required = false) String sex,
                           @RequestParam(value = "cellphone", required = false) String cellphone,
                           @RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "role", required = false) Integer role,
                           HttpSession session) {
        User user = (User) session.getAttribute(SessionConstant.KEY_USER);
        List<User> userList = userService.selectListByPaging(
                page,
                limit,
                sex,
                cellphone,
                name,
                role
        );
        int count = userService.selectCountByPaging(
                sex,
                cellphone,
                name,
                role
        );
        RespResult respResult = new RespResult();
        respResult.success(userList, count);
        return respResult;
    }

    // 查询全部数据
    @RequestMapping("/all")
    public RespResult all() {
        List<User> userList = userService.selectAll();
        RespResult respResult = new RespResult();
        respResult.success(userList);
        return respResult;
    }

    // 根据条件查询列表数据
    @RequestMapping("/list")
    public RespResult list(@RequestBody User user) {
        List<User> userList = userService.selectList(user);
        RespResult respResult = new RespResult();
        respResult.success(userList);
        return respResult;
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @RequestMapping("/list/limit")
    public RespResult selectListByLimit(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "sort", required = false) String sort,
                                        @RequestParam(value = "limit", required = false) Integer limit) {
        List<User> userList = userService.selectListByLimit(
                 field, sort, limit
        );
        RespResult respResult = new RespResult();
        respResult.success(userList);
        return respResult;
    }

    // 根据字段查询列表数据
    @RequestMapping("/list/field")
    public RespResult selectListByField(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "value", required = false) Object value) {
        List<User> userList = userService.selectListByField(
                field, value
        );
        RespResult respResult = new RespResult();
        respResult.success(userList);
        return respResult;
    }

    // 根据条件查询单个数据
    @RequestMapping("/info/dynamic")
    public RespResult infoDynamic(@RequestBody User data) {
        User user = userService.selectOne(data);
        RespResult respResult = new RespResult();
        respResult.success(user);
        return respResult;
    }

    // 根据ID查询单个数据
    @RequestMapping("/info")
    public RespResult info(@RequestParam("id") Integer id) {
        User user = userService.selectByPrimaryKey(id);
        RespResult respResult = new RespResult();
        respResult.success(user);
        return respResult;
    }

    // 根据token查询单个数据
    @RequestMapping("/token")
    public RespResult token(@RequestParam("token") String token) {
        User user = userService.selectOneByToken(token);
        RespResult respResult = new RespResult();
        respResult.success(user);
        return respResult;
    }

    // 根据ID查询数据详情
    @RequestMapping("/details")
    public RespResult details(@RequestParam("id") Integer id) {
        User user = userService.selectOneByDetails(id);
        RespResult respResult = new RespResult();
        respResult.success(user);
        return respResult;
    }

    // 全部条数
    @RequestMapping("/count")
    public RespResult count() {
        int count = userService.selectAllCount();
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件查询数据条数
    @RequestMapping("/count/dynamic")
    public RespResult countDynamic(@RequestBody User user) {
        int count = userService.selectCount(user);
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件修改全部数据
    @RequestMapping("/update/all")
    public RespResult updateAll(@RequestBody User user) {
        userService.updateAll(user);
        RespResult respResult = new RespResult();
        return respResult;
    }

    // 添加数据
    @RequestMapping("/add")
    public RespResult add(@RequestBody User user) {
        RespResult respResult = new RespResult();
        User u = userService.selectOneByUsername(user.getUsername());
        // 判断用户名是否存在
        if (u == null) {
            user.setToken(TokenUtils.sign(user.getUsername(), user.getPassword()));
            user.setRegisterTime(new Date());
            userService.insertSelective(user);
        } else {
            respResult.error("注册失败：该用户名已注册");
        }
        return respResult;
    }

    // 修改数据
    @RequestMapping("/edit")
    public RespResult edit(@RequestBody User user) {
        userService.updateByPrimaryKeySelective(user);
        RespResult respResult = new RespResult();
        respResult.success(user);
        return respResult;
    }

    // 单个删除
    @RequestMapping("/delete")
    public RespResult delete(@RequestParam("id") Integer id) {
        userService.deleteByPrimaryKey(id);
        return new RespResult();
    }

    // 批量删除
    @RequestMapping("/delete/list")
    public RespResult deleteList(@RequestBody Integer[] idList) {
        for (Integer id : idList) {
            userService.deleteByPrimaryKey(id);
        }
        return new RespResult();
    }

}
