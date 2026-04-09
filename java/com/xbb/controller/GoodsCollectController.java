package com.xbb.controller;

import com.xbb.common.RespResult;
import com.xbb.constant.SessionConstant;
import com.xbb.entity.User;
import com.xbb.entity.GoodsCollect;
import com.xbb.service.GoodsCollectService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 汽车收藏Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/goodsCollect")
public class GoodsCollectController {

    @Resource
    private GoodsCollectService goodsCollectService;

    // 根据条件查询分页数据及条数
    @RequestMapping("/data")
    public RespResult data(@RequestParam("page") int page,
                           @RequestParam("limit") int limit,
                           @RequestParam(value = "goodsId", required = false) Integer goodsId,
                           @RequestParam(value = "userId", required = false) Integer userId,
                           @RequestParam(value = "name", required = false) String name,
                           HttpSession session) {
        User user = (User) session.getAttribute(SessionConstant.KEY_USER);
        List<GoodsCollect> goodsCollectList = goodsCollectService.selectListByPaging(
                page,
                limit,
                goodsId,
                userId,
                name
        );
        int count = goodsCollectService.selectCountByPaging(
                goodsId,
                userId,
                name
        );
        RespResult respResult = new RespResult();
        respResult.success(goodsCollectList, count);
        return respResult;
    }

    // 查询全部数据
    @RequestMapping("/all")
    public RespResult all() {
        List<GoodsCollect> goodsCollectList = goodsCollectService.selectAll();
        RespResult respResult = new RespResult();
        respResult.success(goodsCollectList);
        return respResult;
    }

    // 根据条件查询列表数据
    @RequestMapping("/list")
    public RespResult list(@RequestBody GoodsCollect goodsCollect) {
        List<GoodsCollect> goodsCollectList = goodsCollectService.selectList(goodsCollect);
        RespResult respResult = new RespResult();
        respResult.success(goodsCollectList);
        return respResult;
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @RequestMapping("/list/limit")
    public RespResult selectListByLimit(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "sort", required = false) String sort,
                                        @RequestParam(value = "limit", required = false) Integer limit) {
        List<GoodsCollect> goodsCollectList = goodsCollectService.selectListByLimit(
                 field, sort, limit
        );
        RespResult respResult = new RespResult();
        respResult.success(goodsCollectList);
        return respResult;
    }

    // 根据字段查询列表数据
    @RequestMapping("/list/field")
    public RespResult selectListByField(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "value", required = false) Object value) {
        List<GoodsCollect> goodsCollectList = goodsCollectService.selectListByField(
                field, value
        );
        RespResult respResult = new RespResult();
        respResult.success(goodsCollectList);
        return respResult;
    }

    // 根据条件查询单个数据
    @RequestMapping("/info/dynamic")
    public RespResult infoDynamic(@RequestBody GoodsCollect data) {
        GoodsCollect goodsCollect = goodsCollectService.selectOne(data);
        RespResult respResult = new RespResult();
        respResult.success(goodsCollect);
        return respResult;
    }

    // 根据ID查询单个数据
    @RequestMapping("/info")
    public RespResult info(@RequestParam("id") Integer id) {
        GoodsCollect goodsCollect = goodsCollectService.selectByPrimaryKey(id);
        RespResult respResult = new RespResult();
        respResult.success(goodsCollect);
        return respResult;
    }

    // 根据ID查询数据详情
    @RequestMapping("/details")
    public RespResult details(@RequestParam("id") Integer id) {
        GoodsCollect goodsCollect = goodsCollectService.selectOneByDetails(id);
        RespResult respResult = new RespResult();
        respResult.success(goodsCollect);
        return respResult;
    }

    // 全部条数
    @RequestMapping("/count")
    public RespResult count() {
        int count = goodsCollectService.selectAllCount();
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件查询数据条数
    @RequestMapping("/count/dynamic")
    public RespResult countDynamic(@RequestBody GoodsCollect goodsCollect) {
        int count = goodsCollectService.selectCount(goodsCollect);
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件修改全部数据
    @RequestMapping("/update/all")
    public RespResult updateAll(@RequestBody GoodsCollect goodsCollect) {
        goodsCollectService.updateAll(goodsCollect);
        RespResult respResult = new RespResult();
        return respResult;
    }

    // 添加数据
    @RequestMapping("/add")
    public RespResult add(@RequestBody GoodsCollect goodsCollect) {
        goodsCollectService.insertSelective(goodsCollect);
        RespResult respResult = new RespResult();
        respResult.success(goodsCollect);
        return respResult;
    }

    // 修改数据
    @RequestMapping("/edit")
    public RespResult edit(@RequestBody GoodsCollect goodsCollect) {
        goodsCollectService.updateByPrimaryKeySelective(goodsCollect);
        RespResult respResult = new RespResult();
        respResult.success(goodsCollect);
        return respResult;
    }

    // 单个删除
    @RequestMapping("/delete")
    public RespResult delete(@RequestParam("id") Integer id) {
        goodsCollectService.deleteByPrimaryKey(id);
        return new RespResult();
    }

    // 批量删除
    @RequestMapping("/delete/list")
    public RespResult deleteList(@RequestBody Integer[] idList) {
        for (Integer id : idList) {
            goodsCollectService.deleteByPrimaryKey(id);
        }
        return new RespResult();
    }

}
