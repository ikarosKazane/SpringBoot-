package com.xbb.controller;

import com.xbb.common.RespResult;
import com.xbb.constant.SessionConstant;
import com.xbb.entity.User;
import com.xbb.service.UserService;
import com.xbb.util.FileUtils;
import com.xbb.util.TokenUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 登录、注册API
@RestController
@CrossOrigin
public class LoginController {

    @Resource
    private UserService userService;

    // 注册
    @RequestMapping("/register")
    public RespResult register(@RequestBody User user) {
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

    // 登录
    @RequestMapping("/login")
    public RespResult login(@RequestBody User user, HttpSession session) {
        RespResult respResult = new RespResult();
        User u = userService.selectOneByUsername(user.getUsername());
        // 判断用户名是否存在
        if (u == null) {
            respResult.error("登陆失败：用户名不存在");
        } else {
            // 判断密码是否正确
            if (u.getPassword().equals(user.getPassword())) {
                respResult.success(u);
                session.setAttribute(SessionConstant.KEY_USER, u);
            } else {
                respResult.error("登陆失败：密码错误");
            }
        }
        return respResult;
    }

    // 登出
    @RequestMapping("/logout")
    public RespResult loginOut(HttpSession session) {
        session.removeAttribute(SessionConstant.KEY_USER);
        return new RespResult();
    }

}
