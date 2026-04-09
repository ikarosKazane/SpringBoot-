package com.xbb.controller;

import com.xbb.common.RespResult;
import com.xbb.constant.SessionConstant;
import com.xbb.entity.User;
import com.xbb.entity.Banner;
import com.xbb.service.BannerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 轮播图Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/banner")
public class BannerController {

    @Resource
    private BannerService bannerService;

    // 根据条件查询分页数据及条数
    @RequestMapping("/data")
    public RespResult data(@RequestParam("page") int page,
                           @RequestParam("limit") int limit,
                           @RequestParam(value = "status", required = false) Boolean status,
                           @RequestParam(value = "name", required = false) String name,
                           HttpSession session) {
        User user = (User) session.getAttribute(SessionConstant.KEY_USER);
        List<Banner> bannerList = bannerService.selectListByPaging(
                page,
                limit,
                status,
                name
        );
        int count = bannerService.selectCountByPaging(
                status,
                name
        );
        RespResult respResult = new RespResult();
        respResult.success(bannerList, count);
        return respResult;
    }

    // 查询全部数据
    @RequestMapping("/all")
    public RespResult all() {
        List<Banner> bannerList = bannerService.selectAll();
        RespResult respResult = new RespResult();
        respResult.success(bannerList);
        return respResult;
    }

    // 根据条件查询列表数据
    @RequestMapping("/list")
    public RespResult list(@RequestBody Banner banner) {
        List<Banner> bannerList = bannerService.selectList(banner);
        RespResult respResult = new RespResult();
        respResult.success(bannerList);
        return respResult;
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @RequestMapping("/list/limit")
    public RespResult selectListByLimit(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "sort", required = false) String sort,
                                        @RequestParam(value = "limit", required = false) Integer limit) {
        List<Banner> bannerList = bannerService.selectListByLimit(
                 field, sort, limit
        );
        RespResult respResult = new RespResult();
        respResult.success(bannerList);
        return respResult;
    }

    // 根据字段查询列表数据
    @RequestMapping("/list/field")
    public RespResult selectListByField(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "value", required = false) Object value) {
        List<Banner> bannerList = bannerService.selectListByField(
                field, value
        );
        RespResult respResult = new RespResult();
        respResult.success(bannerList);
        return respResult;
    }

    // 根据条件查询单个数据
    @RequestMapping("/info/dynamic")
    public RespResult infoDynamic(@RequestBody Banner data) {
        Banner banner = bannerService.selectOne(data);
        RespResult respResult = new RespResult();
        respResult.success(banner);
        return respResult;
    }

    // 根据ID查询单个数据
    @RequestMapping("/info")
    public RespResult info(@RequestParam("id") Integer id) {
        Banner banner = bannerService.selectByPrimaryKey(id);
        RespResult respResult = new RespResult();
        respResult.success(banner);
        return respResult;
    }

    // 根据ID查询数据详情
    @RequestMapping("/details")
    public RespResult details(@RequestParam("id") Integer id) {
        Banner banner = bannerService.selectOneByDetails(id);
        RespResult respResult = new RespResult();
        respResult.success(banner);
        return respResult;
    }

    // 全部条数
    @RequestMapping("/count")
    public RespResult count() {
        int count = bannerService.selectAllCount();
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件查询数据条数
    @RequestMapping("/count/dynamic")
    public RespResult countDynamic(@RequestBody Banner banner) {
        int count = bannerService.selectCount(banner);
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件修改全部数据
    @RequestMapping("/update/all")
    public RespResult updateAll(@RequestBody Banner banner) {
        bannerService.updateAll(banner);
        RespResult respResult = new RespResult();
        return respResult;
    }

    // 添加数据
    @RequestMapping("/add")
    public RespResult add(@RequestBody Banner banner) {
        bannerService.insertSelective(banner);
        RespResult respResult = new RespResult();
        respResult.success(banner);
        return respResult;
    }

    // 修改数据
    @RequestMapping("/edit")
    public RespResult edit(@RequestBody Banner banner) {
        bannerService.updateByPrimaryKeySelective(banner);
        RespResult respResult = new RespResult();
        respResult.success(banner);
        return respResult;
    }

    // 单个删除
    @RequestMapping("/delete")
    public RespResult delete(@RequestParam("id") Integer id) {
        bannerService.deleteByPrimaryKey(id);
        return new RespResult();
    }

    // 批量删除
    @RequestMapping("/delete/list")
    public RespResult deleteList(@RequestBody Integer[] idList) {
        for (Integer id : idList) {
            bannerService.deleteByPrimaryKey(id);
        }
        return new RespResult();
    }

}
