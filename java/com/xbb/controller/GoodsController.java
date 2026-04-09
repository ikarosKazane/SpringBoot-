package com.xbb.controller;

import com.xbb.common.RespResult;
import com.xbb.constant.SessionConstant;
import com.xbb.entity.Statistics;
import com.xbb.entity.User;
import com.xbb.entity.Goods;
import com.xbb.service.GoodsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 汽车Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    // 根据条件查询分页数据及条数
    @RequestMapping("/data")
    public RespResult data(@RequestParam("page") int page,
                           @RequestParam("limit") int limit,
                           @RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "goodsTypeId", required = false) Integer goodsTypeId,
                           @RequestParam(value = "status", required = false) Boolean status,
                           @RequestParam(value = "userId", required = false) Integer userId,
                           @RequestParam(value = "creatDate", required = false) Date creatDate,
                           @RequestParam(value = "brand", required = false) String brand,
                           @RequestParam(value = "model", required = false) String model,
                           HttpSession session) {
        User user = (User) session.getAttribute(SessionConstant.KEY_USER);
        List<Goods> goodsList = goodsService.selectListByPaging(
                page,
                limit,
                name,
                goodsTypeId,
                status,
                userId,
                creatDate,
                brand,
                model
        );
        int count = goodsService.selectCountByPaging(
                name,
                goodsTypeId,
                status,
                userId,
                creatDate,
                brand,
                model
        );
        RespResult respResult = new RespResult();
        respResult.success(goodsList, count);
        return respResult;
    }

    // 查询全部数据
    @RequestMapping("/all")
    public RespResult all() {
        List<Goods> goodsList = goodsService.selectAll();
        RespResult respResult = new RespResult();
        respResult.success(goodsList);
        return respResult;
    }

    // 根据条件查询列表数据
    @RequestMapping("/list")
    public RespResult list(@RequestBody Goods goods) {
        List<Goods> goodsList = goodsService.selectList(goods);
        RespResult respResult = new RespResult();
        respResult.success(goodsList);
        return respResult;
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @RequestMapping("/list/limit")
    public RespResult selectListByLimit(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "sort", required = false) String sort,
                                        @RequestParam(value = "limit", required = false) Integer limit) {
        List<Goods> goodsList = goodsService.selectListByLimit(
                 field, sort, limit
        );
        RespResult respResult = new RespResult();
        respResult.success(goodsList);
        return respResult;
    }

    // 根据字段查询列表数据
    @RequestMapping("/list/field")
    public RespResult selectListByField(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "value", required = false) Object value) {
        List<Goods> goodsList = goodsService.selectListByField(
                field, value
        );
        RespResult respResult = new RespResult();
        respResult.success(goodsList);
        return respResult;
    }

    // 根据条件查询单个数据
    @RequestMapping("/info/dynamic")
    public RespResult infoDynamic(@RequestBody Goods data) {
        Goods goods = goodsService.selectOne(data);
        RespResult respResult = new RespResult();
        respResult.success(goods);
        return respResult;
    }

    // 根据ID查询单个数据
    @RequestMapping("/info")
    public RespResult info(@RequestParam("id") Integer id) {
        Goods goods = goodsService.selectByPrimaryKey(id);
        RespResult respResult = new RespResult();
        respResult.success(goods);
        return respResult;
    }

    // 根据ID查询数据详情
    @RequestMapping("/details")
    public RespResult details(@RequestParam("id") Integer id) {
        Goods goods = goodsService.selectOneByDetails(id);
        RespResult respResult = new RespResult();
        respResult.success(goods);
        return respResult;
    }

    // 全部条数
    @RequestMapping("/count")
    public RespResult count() {
        int count = goodsService.selectAllCount();
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件查询数据条数
    @RequestMapping("/count/dynamic")
    public RespResult countDynamic(@RequestBody Goods goods) {
        int count = goodsService.selectCount(goods);
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件修改全部数据
    @RequestMapping("/update/all")
    public RespResult updateAll(@RequestBody Goods goods) {
        goodsService.updateAll(goods);
        RespResult respResult = new RespResult();
        return respResult;
    }

    // 添加数据
    @RequestMapping("/add")
    public RespResult add(@RequestBody Goods goods) {
        goods.setCreatDate(new Date());
        goodsService.insertSelective(goods);
        RespResult respResult = new RespResult();
        respResult.success(goods);
        return respResult;
    }

    // 修改数据
    @RequestMapping("/edit")
    public RespResult edit(@RequestBody Goods goods) {
        goodsService.updateByPrimaryKeySelective(goods);
        RespResult respResult = new RespResult();
        respResult.success(goods);
        return respResult;
    }

    // 单个删除
    @RequestMapping("/delete")
    public RespResult delete(@RequestParam("id") Integer id) {
        goodsService.deleteByPrimaryKey(id);
        return new RespResult();
    }

    // 批量删除
    @RequestMapping("/delete/list")
    public RespResult deleteList(@RequestBody Integer[] idList) {
        for (Integer id : idList) {
            goodsService.deleteByPrimaryKey(id);
        }
        return new RespResult();
    }

    // 类型统计
    @ResponseBody
    @RequestMapping("/statistics/type")
    public RespResult statisticsType () {
        // 饼图数据
        List<Statistics> statisticsList = goodsService.selectStatisticsByType();

        // 柱图数据
        List<String> nameList = new ArrayList<>();
        List<Object> valueList = new ArrayList<>();
        for (Statistics data : statisticsList) {
            nameList.add(data.getName());
            valueList.add(data.getValue());
        }

        Map<String, Object> data = new HashMap<>();
        data.put("statisticsList", statisticsList);
        data.put("nameList", nameList);
        data.put("valueList", valueList);

        RespResult respResult = new RespResult();
        respResult.success(data);
        return respResult;
    }

    // 租赁次数统计
    @ResponseBody
    @RequestMapping("/statistics/salesVolume")
    public RespResult statisticsSalesVolume () {
        // 饼图数据
        List<Statistics> statisticsList = goodsService.selectStatisticsBySalesVolume();

        // 柱图数据
        List<String> nameList = new ArrayList<>();
        List<Object> valueList = new ArrayList<>();
        for (Statistics data : statisticsList) {
            nameList.add(data.getName());
            valueList.add(data.getValue());
        }

        Map<String, Object> data = new HashMap<>();
        data.put("statisticsList", statisticsList);
        data.put("nameList", nameList);
        data.put("valueList", valueList);

        RespResult respResult = new RespResult();
        respResult.success(data);
        return respResult;
    }

    // 租赁金额统计
    @ResponseBody
    @RequestMapping("/statistics/money")
    public RespResult statisticsMoney () {
        // 饼图数据
        List<Statistics> statisticsList = goodsService.selectStatisticsByMoney();

        // 柱图数据
        List<String> nameList = new ArrayList<>();
        List<Object> valueList = new ArrayList<>();
        for (Statistics data : statisticsList) {
            nameList.add(data.getName());
            valueList.add(data.getValue());
        }

        Map<String, Object> data = new HashMap<>();
        data.put("statisticsList", statisticsList);
        data.put("nameList", nameList);
        data.put("valueList", valueList);

        RespResult respResult = new RespResult();
        respResult.success(data);
        return respResult;
    }

    // 租赁时长统计
    @ResponseBody
    @RequestMapping("/statistics/duration")
    public RespResult statisticsDuration () {
        // 饼图数据
        List<Statistics> statisticsList = goodsService.selectStatisticsByDuration();

        // 柱图数据
        List<String> nameList = new ArrayList<>();
        List<Object> valueList = new ArrayList<>();
        for (Statistics data : statisticsList) {
            nameList.add(data.getName());
            valueList.add(data.getValue());
        }

        Map<String, Object> data = new HashMap<>();
        data.put("statisticsList", statisticsList);
        data.put("nameList", nameList);
        data.put("valueList", valueList);

        RespResult respResult = new RespResult();
        respResult.success(data);
        return respResult;
    }

    // 维护次数统计
    @ResponseBody
    @RequestMapping("/statistics/repair")
    public RespResult statisticsRepair () {
        // 饼图数据
        List<Statistics> statisticsList = goodsService.selectStatisticsByRepair();

        // 柱图数据
        List<String> nameList = new ArrayList<>();
        List<Object> valueList = new ArrayList<>();
        for (Statistics data : statisticsList) {
            nameList.add(data.getName());
            valueList.add(data.getValue());
        }

        Map<String, Object> data = new HashMap<>();
        data.put("statisticsList", statisticsList);
        data.put("nameList", nameList);
        data.put("valueList", valueList);

        RespResult respResult = new RespResult();
        respResult.success(data);
        return respResult;
    }

}
