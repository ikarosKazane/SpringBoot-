package com.xbb.controller;

import com.xbb.common.RespResult;
import com.xbb.constant.SessionConstant;
import com.xbb.entity.User;
import com.xbb.entity.Links;
import com.xbb.service.LinksService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 友情链接Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/links")
public class LinksController {

    @Resource
    private LinksService linksService;

    // 根据条件查询分页数据及条数
    @RequestMapping("/data")
    public RespResult data(@RequestParam("page") int page,
                           @RequestParam("limit") int limit,
                           @RequestParam(value = "name", required = false) String name,
                           HttpSession session) {
        User user = (User) session.getAttribute(SessionConstant.KEY_USER);
        List<Links> linksList = linksService.selectListByPaging(
                page,
                limit,
                name
        );
        int count = linksService.selectCountByPaging(
                name
        );
        RespResult respResult = new RespResult();
        respResult.success(linksList, count);
        return respResult;
    }

    // 查询全部数据
    @RequestMapping("/all")
    public RespResult all() {
        List<Links> linksList = linksService.selectAll();
        RespResult respResult = new RespResult();
        respResult.success(linksList);
        return respResult;
    }

    // 根据条件查询列表数据
    @RequestMapping("/list")
    public RespResult list(@RequestBody Links links) {
        List<Links> linksList = linksService.selectList(links);
        RespResult respResult = new RespResult();
        respResult.success(linksList);
        return respResult;
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @RequestMapping("/list/limit")
    public RespResult selectListByLimit(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "sort", required = false) String sort,
                                        @RequestParam(value = "limit", required = false) Integer limit) {
        List<Links> linksList = linksService.selectListByLimit(
                 field, sort, limit
        );
        RespResult respResult = new RespResult();
        respResult.success(linksList);
        return respResult;
    }

    // 根据字段查询列表数据
    @RequestMapping("/list/field")
    public RespResult selectListByField(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "value", required = false) Object value) {
        List<Links> linksList = linksService.selectListByField(
                field, value
        );
        RespResult respResult = new RespResult();
        respResult.success(linksList);
        return respResult;
    }

    // 根据条件查询单个数据
    @RequestMapping("/info/dynamic")
    public RespResult infoDynamic(@RequestBody Links data) {
        Links links = linksService.selectOne(data);
        RespResult respResult = new RespResult();
        respResult.success(links);
        return respResult;
    }

    // 根据ID查询单个数据
    @RequestMapping("/info")
    public RespResult info(@RequestParam("id") Integer id) {
        Links links = linksService.selectByPrimaryKey(id);
        RespResult respResult = new RespResult();
        respResult.success(links);
        return respResult;
    }

    // 根据ID查询数据详情
    @RequestMapping("/details")
    public RespResult details(@RequestParam("id") Integer id) {
        Links links = linksService.selectOneByDetails(id);
        RespResult respResult = new RespResult();
        respResult.success(links);
        return respResult;
    }

    // 全部条数
    @RequestMapping("/count")
    public RespResult count() {
        int count = linksService.selectAllCount();
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件查询数据条数
    @RequestMapping("/count/dynamic")
    public RespResult countDynamic(@RequestBody Links links) {
        int count = linksService.selectCount(links);
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件修改全部数据
    @RequestMapping("/update/all")
    public RespResult updateAll(@RequestBody Links links) {
        linksService.updateAll(links);
        RespResult respResult = new RespResult();
        return respResult;
    }

    // 添加数据
    @RequestMapping("/add")
    public RespResult add(@RequestBody Links links) {
        linksService.insertSelective(links);
        RespResult respResult = new RespResult();
        respResult.success(links);
        return respResult;
    }

    // 修改数据
    @RequestMapping("/edit")
    public RespResult edit(@RequestBody Links links) {
        linksService.updateByPrimaryKeySelective(links);
        RespResult respResult = new RespResult();
        respResult.success(links);
        return respResult;
    }

    // 单个删除
    @RequestMapping("/delete")
    public RespResult delete(@RequestParam("id") Integer id) {
        linksService.deleteByPrimaryKey(id);
        return new RespResult();
    }

    // 批量删除
    @RequestMapping("/delete/list")
    public RespResult deleteList(@RequestBody Integer[] idList) {
        for (Integer id : idList) {
            linksService.deleteByPrimaryKey(id);
        }
        return new RespResult();
    }

}
