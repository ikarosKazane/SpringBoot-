package com.xbb.controller;

import com.xbb.common.RespResult;
import com.xbb.constant.SessionConstant;
import com.xbb.entity.User;
import com.xbb.entity.About;
import com.xbb.service.AboutService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 关于我们Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/about")
public class AboutController {

    @Resource
    private AboutService aboutService;

    // 根据条件查询分页数据及条数
    @RequestMapping("/data")
    public RespResult data(@RequestParam("page") int page,
                           @RequestParam("limit") int limit,
                           @RequestParam(value = "cellphone", required = false) String cellphone,
                           @RequestParam(value = "creatDate", required = false) String creatDate,
                           @RequestParam(value = "status", required = false) Integer status,
                           @RequestParam(value = "name", required = false) String name,
                           HttpSession session) {
        User user = (User) session.getAttribute(SessionConstant.KEY_USER);
        List<About> aboutList = aboutService.selectListByPaging(
                page,
                limit,
                cellphone,
                creatDate,
                status,
                name
        );
        int count = aboutService.selectCountByPaging(
                cellphone,
                creatDate,
                status,
                name
        );
        RespResult respResult = new RespResult();
        respResult.success(aboutList, count);
        return respResult;
    }

    // 查询全部数据
    @RequestMapping("/all")
    public RespResult all() {
        List<About> aboutList = aboutService.selectAll();
        RespResult respResult = new RespResult();
        respResult.success(aboutList);
        return respResult;
    }

    // 根据条件查询列表数据
    @RequestMapping("/list")
    public RespResult list(@RequestBody About about) {
        List<About> aboutList = aboutService.selectList(about);
        RespResult respResult = new RespResult();
        respResult.success(aboutList);
        return respResult;
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @RequestMapping("/list/limit")
    public RespResult selectListByLimit(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "sort", required = false) String sort,
                                        @RequestParam(value = "limit", required = false) Integer limit) {
        List<About> aboutList = aboutService.selectListByLimit(
                 field, sort, limit
        );
        RespResult respResult = new RespResult();
        respResult.success(aboutList);
        return respResult;
    }

    // 根据字段查询列表数据
    @RequestMapping("/list/field")
    public RespResult selectListByField(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "value", required = false) Object value) {
        List<About> aboutList = aboutService.selectListByField(
                field, value
        );
        RespResult respResult = new RespResult();
        respResult.success(aboutList);
        return respResult;
    }

    // 根据条件查询单个数据
    @RequestMapping("/info/dynamic")
    public RespResult infoDynamic(@RequestBody About data) {
        About about = aboutService.selectOne(data);
        RespResult respResult = new RespResult();
        respResult.success(about);
        return respResult;
    }

    // 根据ID查询单个数据
    @RequestMapping("/info")
    public RespResult info(@RequestParam("id") Integer id) {
        About about = aboutService.selectByPrimaryKey(id);
        RespResult respResult = new RespResult();
        respResult.success(about);
        return respResult;
    }

    // 根据ID查询数据详情
    @RequestMapping("/details")
    public RespResult details(@RequestParam("id") Integer id) {
        About about = aboutService.selectOneByDetails(id);
        RespResult respResult = new RespResult();
        respResult.success(about);
        return respResult;
    }

    // 全部条数
    @RequestMapping("/count")
    public RespResult count() {
        int count = aboutService.selectAllCount();
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件查询数据条数
    @RequestMapping("/count/dynamic")
    public RespResult countDynamic(@RequestBody About about) {
        int count = aboutService.selectCount(about);
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件修改全部数据
    @RequestMapping("/update/all")
    public RespResult updateAll(@RequestBody About about) {
        aboutService.updateAll(about);
        RespResult respResult = new RespResult();
        return respResult;
    }

    // 提交数据设为展示，其他数据为待展示
    @RequestMapping("/set")
    public RespResult set(@RequestBody About about) {
        About a = new About();
        a.setStatus(false);
        aboutService.updateAll(a);
        aboutService.updateByPrimaryKeySelective(about);
        RespResult respResult = new RespResult();
        return respResult;
    }

    // 添加数据
    @RequestMapping("/add")
    public RespResult add(@RequestBody About about) {
        aboutService.insertSelective(about);
        RespResult respResult = new RespResult();
        respResult.success(about);
        return respResult;
    }

    // 修改数据
    @RequestMapping("/edit")
    public RespResult edit(@RequestBody About about) {
        aboutService.updateByPrimaryKeySelective(about);
        RespResult respResult = new RespResult();
        respResult.success(about);
        return respResult;
    }

    // 单个删除
    @RequestMapping("/delete")
    public RespResult delete(@RequestParam("id") Integer id) {
        aboutService.deleteByPrimaryKey(id);
        return new RespResult();
    }

    // 批量删除
    @RequestMapping("/delete/list")
    public RespResult deleteList(@RequestBody Integer[] idList) {
        for (Integer id : idList) {
            aboutService.deleteByPrimaryKey(id);
        }
        return new RespResult();
    }

}
