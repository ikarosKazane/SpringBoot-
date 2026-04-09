package com.xbb.controller;

import com.xbb.common.RespResult;
import com.xbb.constant.SessionConstant;
import com.xbb.entity.Goods;
import com.xbb.entity.GoodsOrders;
import com.xbb.entity.User;
import com.xbb.entity.GoodsComment;
import com.xbb.service.GoodsCommentService;
import com.xbb.service.GoodsOrdersService;
import com.xbb.service.GoodsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 汽车评价Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/goodsComment")
public class GoodsCommentController {

    @Resource
    private GoodsCommentService goodsCommentService;
    @Resource
    private GoodsOrdersService goodsOrdersService;
    @Resource
    private GoodsService goodsService;

    // 根据条件查询分页数据及条数
    @RequestMapping("/data")
    public RespResult data(@RequestParam("page") int page,
                           @RequestParam("limit") int limit,
                           @RequestParam(value = "goodsId", required = false) Integer goodsId,
                           @RequestParam(value = "userId", required = false) Integer userId,
                           @RequestParam(value = "content", required = false) String content,
                           @RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "staffId", required = false) Integer staffId,
                           HttpSession session) {
        User user = (User) session.getAttribute(SessionConstant.KEY_USER);
        List<GoodsComment> goodsCommentList = goodsCommentService.selectListByPaging(
                page,
                limit,
                goodsId,
                userId,
                content,
                name,
                staffId
        );
        int count = goodsCommentService.selectCountByPaging(
                goodsId,
                userId,
                content,
                name,
                staffId
        );
        RespResult respResult = new RespResult();
        respResult.success(goodsCommentList, count);
        return respResult;
    }

    // 查询全部数据
    @RequestMapping("/all")
    public RespResult all() {
        List<GoodsComment> goodsCommentList = goodsCommentService.selectAll();
        RespResult respResult = new RespResult();
        respResult.success(goodsCommentList);
        return respResult;
    }

    // 根据条件查询列表数据
    @RequestMapping("/list")
    public RespResult list(@RequestBody GoodsComment goodsComment) {
        List<GoodsComment> goodsCommentList = goodsCommentService.selectList(goodsComment);
        RespResult respResult = new RespResult();
        respResult.success(goodsCommentList);
        return respResult;
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @RequestMapping("/list/limit")
    public RespResult selectListByLimit(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "sort", required = false) String sort,
                                        @RequestParam(value = "limit", required = false) Integer limit) {
        List<GoodsComment> goodsCommentList = goodsCommentService.selectListByLimit(
                 field, sort, limit
        );
        RespResult respResult = new RespResult();
        respResult.success(goodsCommentList);
        return respResult;
    }

    // 根据字段查询列表数据
    @RequestMapping("/list/field")
    public RespResult selectListByField(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "value", required = false) Object value) {
        List<GoodsComment> goodsCommentList = goodsCommentService.selectListByField(
                field, value
        );
        RespResult respResult = new RespResult();
        respResult.success(goodsCommentList);
        return respResult;
    }

    // 根据条件查询单个数据
    @RequestMapping("/info/dynamic")
    public RespResult infoDynamic(@RequestBody GoodsComment data) {
        GoodsComment goodsComment = goodsCommentService.selectOne(data);
        RespResult respResult = new RespResult();
        respResult.success(goodsComment);
        return respResult;
    }

    // 根据ID查询单个数据
    @RequestMapping("/info")
    public RespResult info(@RequestParam("id") Integer id) {
        GoodsComment goodsComment = goodsCommentService.selectByPrimaryKey(id);
        RespResult respResult = new RespResult();
        respResult.success(goodsComment);
        return respResult;
    }

    // 根据ID查询数据详情
    @RequestMapping("/details")
    public RespResult details(@RequestParam("id") Integer id) {
        GoodsComment goodsComment = goodsCommentService.selectOneByDetails(id);
        RespResult respResult = new RespResult();
        respResult.success(goodsComment);
        return respResult;
    }

    // 全部条数
    @RequestMapping("/count")
    public RespResult count() {
        int count = goodsCommentService.selectAllCount();
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件查询数据条数
    @RequestMapping("/count/dynamic")
    public RespResult countDynamic(@RequestBody GoodsComment goodsComment) {
        int count = goodsCommentService.selectCount(goodsComment);
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件修改全部数据
    @RequestMapping("/update/all")
    public RespResult updateAll(@RequestBody GoodsComment goodsComment) {
        goodsCommentService.updateAll(goodsComment);
        RespResult respResult = new RespResult();
        return respResult;
    }

    // 添加数据
    @RequestMapping("/add")
    public RespResult add(@RequestBody GoodsComment goodsComment) {
        RespResult respResult = new RespResult();
        GoodsOrders goodsOrders = new GoodsOrders();
        goodsOrders.setUserId(goodsComment.getUserId());
        goodsOrders.setGoodsId(goodsComment.getGoodsId());
        goodsOrders.setStatus(4);
        int count = goodsOrdersService.selectCount(goodsOrders);
        // 判断是否租赁过
        if (count == 0) {
            respResult.error("操作失败：未租赁过");
        } else {
            GoodsComment comment = new GoodsComment();
            comment.setUserId(goodsComment.getUserId());
            comment.setGoodsId(goodsComment.getGoodsId());
            count = goodsCommentService.selectCount(comment);
            // 判断是否评价过
            if (count == 0) {
                goodsComment.setCreatTime(new Date());
                goodsCommentService.insertSelective(goodsComment);

                // 计算评分
                comment = new GoodsComment();
                comment.setGoodsId(goodsComment.getGoodsId());
                List<GoodsComment> commentList = goodsCommentService.selectList(comment);
                int score = 0;
                for (GoodsComment item : commentList) {
                    score += item.getScore();
                }

                // 修改评分
                Goods goods = new Goods();
                goods.setId(goodsComment.getGoodsId());
                goods.setScore(score / commentList.size());
                goodsService.updateByPrimaryKeySelective(goods);

                respResult.success(goodsComment);
            } else {
                respResult.error("评价失败：不可重复评价");
            }
        }
        return respResult;
    }

    // 修改数据
    @RequestMapping("/edit")
    public RespResult edit(@RequestBody GoodsComment goodsComment) {
        goodsCommentService.updateByPrimaryKeySelective(goodsComment);
        RespResult respResult = new RespResult();
        respResult.success(goodsComment);
        return respResult;
    }

    // 单个删除
    @RequestMapping("/delete")
    public RespResult delete(@RequestParam("id") Integer id) {
        goodsCommentService.deleteByPrimaryKey(id);
        return new RespResult();
    }

    // 批量删除
    @RequestMapping("/delete/list")
    public RespResult deleteList(@RequestBody Integer[] idList) {
        for (Integer id : idList) {
            goodsCommentService.deleteByPrimaryKey(id);
        }
        return new RespResult();
    }

}
