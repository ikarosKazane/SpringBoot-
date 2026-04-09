package com.xbb.controller;

import com.xbb.common.RespResult;
import com.xbb.constant.SessionConstant;
import com.xbb.entity.User;
import com.xbb.entity.GoodsType;
import com.xbb.service.GoodsTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 汽车类型Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/goodsType")
public class GoodsTypeController {

    @Resource
    private GoodsTypeService goodsTypeService;

    // 根据条件查询分页数据及条数
    @RequestMapping("/data")
    public RespResult data(@RequestParam("page") int page,
                           @RequestParam("limit") int limit,
                           @RequestParam(value = "name", required = false) String name,
                           HttpSession session) {
        User user = (User) session.getAttribute(SessionConstant.KEY_USER);
        List<GoodsType> goodsTypeList = goodsTypeService.selectListByPaging(
                page,
                limit,
                name
        );
        int count = goodsTypeService.selectCountByPaging(
                name
        );
        RespResult respResult = new RespResult();
        respResult.success(goodsTypeList, count);
        return respResult;
    }

    // 查询全部数据
    @RequestMapping("/all")
    public RespResult all() {
        List<GoodsType> goodsTypeList = goodsTypeService.selectAll();
        RespResult respResult = new RespResult();
        respResult.success(goodsTypeList);
        return respResult;
    }

    // 根据条件查询列表数据
    @RequestMapping("/list")
    public RespResult list(@RequestBody GoodsType goodsType) {
        List<GoodsType> goodsTypeList = goodsTypeService.selectList(goodsType);
        RespResult respResult = new RespResult();
        respResult.success(goodsTypeList);
        return respResult;
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @RequestMapping("/list/limit")
    public RespResult selectListByLimit(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "sort", required = false) String sort,
                                        @RequestParam(value = "limit", required = false) Integer limit) {
        List<GoodsType> goodsTypeList = goodsTypeService.selectListByLimit(
                 field, sort, limit
        );
        RespResult respResult = new RespResult();
        respResult.success(goodsTypeList);
        return respResult;
    }

    // 根据字段查询列表数据
    @RequestMapping("/list/field")
    public RespResult selectListByField(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "value", required = false) Object value) {
        List<GoodsType> goodsTypeList = goodsTypeService.selectListByField(
                field, value
        );
        RespResult respResult = new RespResult();
        respResult.success(goodsTypeList);
        return respResult;
    }

    // 根据条件查询单个数据
    @RequestMapping("/info/dynamic")
    public RespResult infoDynamic(@RequestBody GoodsType data) {
        GoodsType goodsType = goodsTypeService.selectOne(data);
        RespResult respResult = new RespResult();
        respResult.success(goodsType);
        return respResult;
    }

    // 根据ID查询单个数据
    @RequestMapping("/info")
    public RespResult info(@RequestParam("id") Integer id) {
        GoodsType goodsType = goodsTypeService.selectByPrimaryKey(id);
        RespResult respResult = new RespResult();
        respResult.success(goodsType);
        return respResult;
    }

    // 根据ID查询数据详情
    @RequestMapping("/details")
    public RespResult details(@RequestParam("id") Integer id) {
        GoodsType goodsType = goodsTypeService.selectOneByDetails(id);
        RespResult respResult = new RespResult();
        respResult.success(goodsType);
        return respResult;
    }

    // 全部条数
    @RequestMapping("/count")
    public RespResult count() {
        int count = goodsTypeService.selectAllCount();
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件查询数据条数
    @RequestMapping("/count/dynamic")
    public RespResult countDynamic(@RequestBody GoodsType goodsType) {
        int count = goodsTypeService.selectCount(goodsType);
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件修改全部数据
    @RequestMapping("/update/all")
    public RespResult updateAll(@RequestBody GoodsType goodsType) {
        goodsTypeService.updateAll(goodsType);
        RespResult respResult = new RespResult();
        return respResult;
    }

    // 添加数据
    @RequestMapping("/add")
    public RespResult add(@RequestBody GoodsType goodsType) {
        goodsTypeService.insertSelective(goodsType);
        RespResult respResult = new RespResult();
        respResult.success(goodsType);
        return respResult;
    }

    // 修改数据
    @RequestMapping("/edit")
    public RespResult edit(@RequestBody GoodsType goodsType) {
        goodsTypeService.updateByPrimaryKeySelective(goodsType);
        RespResult respResult = new RespResult();
        respResult.success(goodsType);
        return respResult;
    }

    // 单个删除
    @RequestMapping("/delete")
    public RespResult delete(@RequestParam("id") Integer id) {
        goodsTypeService.deleteByPrimaryKey(id);
        return new RespResult();
    }

    // 批量删除
    @RequestMapping("/delete/list")
    public RespResult deleteList(@RequestBody Integer[] idList) {
        for (Integer id : idList) {
            goodsTypeService.deleteByPrimaryKey(id);
        }
        return new RespResult();
    }

}
