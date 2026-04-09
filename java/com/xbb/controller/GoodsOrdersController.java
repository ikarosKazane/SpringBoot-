package com.xbb.controller;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.xbb.common.RespResult;
import com.xbb.constant.SessionConstant;
import com.xbb.entity.Goods;
import com.xbb.entity.User;
import com.xbb.entity.GoodsOrders;
import com.xbb.service.GoodsOrdersService;
import com.xbb.service.GoodsService;
import com.xbb.service.UserService;
import com.xbb.util.DateUtils;
import com.xbb.util.FileUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 租赁订单Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/goodsOrders")
public class GoodsOrdersController {

    @Resource
    private GoodsOrdersService goodsOrdersService;
    @Resource
    private GoodsService goodsService;
    @Resource
    private UserService userService;

    // 根据条件查询分页数据及条数
    @RequestMapping("/data")
    public RespResult data(@RequestParam("page") int page,
                           @RequestParam("limit") int limit,
                           @RequestParam(value = "goodsId", required = false) Integer goodsId,
                           @RequestParam(value = "number", required = false) String number,
                           @RequestParam(value = "creatDate", required = false) Date creatDate,
                           @RequestParam(value = "userId", required = false) Integer userId,
                           @RequestParam(value = "status", required = false) Integer status,
                           @RequestParam(value = "staffId", required = false) Integer staffId,
                           HttpSession session) {
        User user = (User) session.getAttribute(SessionConstant.KEY_USER);
        List<GoodsOrders> goodsOrdersList = goodsOrdersService.selectListByPaging(
                page,
                limit,
                goodsId,
                number,
                creatDate,
                userId,
                status,
                staffId
        );
        int count = goodsOrdersService.selectCountByPaging(
                goodsId,
                number,
                creatDate,
                userId,
                status,
                staffId
        );
        RespResult respResult = new RespResult();
        respResult.success(goodsOrdersList, count);
        return respResult;
    }

    // 查询全部数据
    @RequestMapping("/all")
    public RespResult all() {
        List<GoodsOrders> goodsOrdersList = goodsOrdersService.selectAll();
        RespResult respResult = new RespResult();
        respResult.success(goodsOrdersList);
        return respResult;
    }

    // 根据条件查询列表数据
    @RequestMapping("/list")
    public RespResult list(@RequestBody GoodsOrders goodsOrders) {
        List<GoodsOrders> goodsOrdersList = goodsOrdersService.selectList(goodsOrders);
        RespResult respResult = new RespResult();
        respResult.success(goodsOrdersList);
        return respResult;
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @RequestMapping("/list/limit")
    public RespResult selectListByLimit(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "sort", required = false) String sort,
                                        @RequestParam(value = "limit", required = false) Integer limit) {
        List<GoodsOrders> goodsOrdersList = goodsOrdersService.selectListByLimit(
                 field, sort, limit
        );
        RespResult respResult = new RespResult();
        respResult.success(goodsOrdersList);
        return respResult;
    }

    // 根据字段查询列表数据
    @RequestMapping("/list/field")
    public RespResult selectListByField(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "value", required = false) Object value) {
        List<GoodsOrders> goodsOrdersList = goodsOrdersService.selectListByField(
                field, value
        );
        RespResult respResult = new RespResult();
        respResult.success(goodsOrdersList);
        return respResult;
    }

    // 根据条件查询单个数据
    @RequestMapping("/info/dynamic")
    public RespResult infoDynamic(@RequestBody GoodsOrders data) {
        GoodsOrders goodsOrders = goodsOrdersService.selectOne(data);
        RespResult respResult = new RespResult();
        respResult.success(goodsOrders);
        return respResult;
    }

    // 根据ID查询单个数据
    @RequestMapping("/info")
    public RespResult info(@RequestParam("id") Integer id) {
        GoodsOrders goodsOrders = goodsOrdersService.selectByPrimaryKey(id);
        RespResult respResult = new RespResult();
        respResult.success(goodsOrders);
        return respResult;
    }

    // 根据ID查询数据详情
    @RequestMapping("/details")
    public RespResult details(@RequestParam("id") Integer id) {
        GoodsOrders goodsOrders = goodsOrdersService.selectOneByDetails(id);
        RespResult respResult = new RespResult();
        respResult.success(goodsOrders);
        return respResult;
    }

    // 全部条数
    @RequestMapping("/count")
    public RespResult count() {
        int count = goodsOrdersService.selectAllCount();
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件查询数据条数
    @RequestMapping("/count/dynamic")
    public RespResult countDynamic(@RequestBody GoodsOrders goodsOrders) {
        int count = goodsOrdersService.selectCount(goodsOrders);
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件修改全部数据
    @RequestMapping("/update/all")
    public RespResult updateAll(@RequestBody GoodsOrders goodsOrders) {
        goodsOrdersService.updateAll(goodsOrders);
        RespResult respResult = new RespResult();
        return respResult;
    }

    // 添加数据
    @RequestMapping("/add")
    public RespResult add(@RequestBody GoodsOrders goodsOrders) {
        RespResult respResult = new RespResult();
        Goods goods = goodsService.selectByPrimaryKey(goodsOrders.getGoodsId());
        if (goods.getInventory() >= goodsOrders.getQuantity()) {
            int duration =  (int) DateUtil.between(
                    goodsOrders.getEndTime(),
                    goodsOrders.getStartTime(),
                    DateUnit.HOUR
            );
            goodsOrders.setDuration(duration);
            goodsOrders.setMoney(goods.getPrice() * goodsOrders.getQuantity() * duration);
            goodsOrders.setYear(DateUtils.getYear());
            goodsOrders.setMonth(DateUtils.getMonth());
            goodsOrders.setNumber(FileUtils.createUUID());
            goodsOrders.setCreatDate(new Date());
            goodsOrdersService.insertSelective(goodsOrders);

            respResult.success(goodsOrders);
        } else {
            respResult.error("操作失败：库存不足");
        }
        return respResult;
    }

    // 修改数据
    @RequestMapping("/edit")
    public RespResult edit(@RequestBody GoodsOrders goodsOrders) {
        RespResult respResult = new RespResult();
        if (goodsOrders.getStatus() != null) {
            // 如果审核通过，判断库存是够足够
            if (goodsOrders.getStatus() == 1) {
                Goods goods = goodsService.selectByPrimaryKey(goodsOrders.getGoodsId());
                if (goods.getInventory() >= goodsOrders.getQuantity()) {
                    // 库存数量减少、租赁量增加
                    goods.setInventory(goods.getInventory() - goodsOrders.getQuantity());
                    goods.setSalesVolume(goods.getSalesVolume() + goodsOrders.getQuantity());
                    goodsService.updateByPrimaryKeySelective(goods);
                    goodsOrdersService.updateByPrimaryKeySelective(goodsOrders);
                } else {
                    respResult.error("操作失败：库存不足");
                }
            }
            // 审核驳回、支付
            if (goodsOrders.getStatus() == 2 || goodsOrders.getStatus() == 3) {
                goodsOrdersService.updateByPrimaryKeySelective(goodsOrders);
            }
            // 归还
            if (goodsOrders.getStatus() == 4) {
                // 库存数量增加
                Goods goods = goodsService.selectByPrimaryKey(goodsOrders.getGoodsId());
                goods.setInventory(goods.getInventory() + goodsOrders.getQuantity());
                goodsService.updateByPrimaryKeySelective(goods);
                goodsOrdersService.updateByPrimaryKeySelective(goodsOrders);
            }
        }
        respResult.success(goodsOrders);
        return respResult;
    }

    // 单个删除
    @RequestMapping("/delete")
    public RespResult delete(@RequestParam("id") Integer id) {
        goodsOrdersService.deleteByPrimaryKey(id);
        return new RespResult();
    }

    // 批量删除
    @RequestMapping("/delete/list")
    public RespResult deleteList(@RequestBody Integer[] idList) {
        for (Integer id : idList) {
            goodsOrdersService.deleteByPrimaryKey(id);
        }
        return new RespResult();
    }

    // 提醒
    @RequestMapping("/remind")
    public RespResult remind(@RequestParam("userId") int userId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<GoodsOrders> goodsOrdersList = goodsOrdersService.selectListByUserId(userId, sdf.format(new Date()));
        List<GoodsOrders> dataList = new ArrayList<>();
        for (GoodsOrders data : goodsOrdersList) {
            // 计算时间
            int duration =  (int) DateUtil.between(
                    new Date(),
                    data.getEndTime(),
                    DateUnit.HOUR
            );
            // 距离前3小时进行提醒
            if (duration <= 3) {
                data.setDuration(duration);
                dataList.add(data);
            }
        }
        RespResult respResult = new RespResult();
        respResult.success(dataList);
        return respResult;
    }

}
