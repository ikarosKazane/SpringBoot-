package com.xbb.controller;

import com.xbb.common.RespResult;
import com.xbb.constant.SessionConstant;
import com.xbb.entity.User;
import com.xbb.entity.ArticleLike;
import com.xbb.service.ArticleLikeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 文章点赞Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/articleLike")
public class ArticleLikeController {

    @Resource
    private ArticleLikeService articleLikeService;

    // 根据条件查询分页数据及条数
    @RequestMapping("/data")
    public RespResult data(@RequestParam("page") int page,
                           @RequestParam("limit") int limit,
                           @RequestParam(value = "articleId", required = false) Integer articleId,
                           @RequestParam(value = "userId", required = false) Integer userId,
                           @RequestParam(value = "title", required = false) String title,
                           HttpSession session) {
        User user = (User) session.getAttribute(SessionConstant.KEY_USER);
        List<ArticleLike> articleLikeList = articleLikeService.selectListByPaging(
                page,
                limit,
                articleId,
                userId,
                title
        );
        int count = articleLikeService.selectCountByPaging(
                articleId,
                userId,
                title
        );
        RespResult respResult = new RespResult();
        respResult.success(articleLikeList, count);
        return respResult;
    }

    // 查询全部数据
    @RequestMapping("/all")
    public RespResult all() {
        List<ArticleLike> articleLikeList = articleLikeService.selectAll();
        RespResult respResult = new RespResult();
        respResult.success(articleLikeList);
        return respResult;
    }

    // 根据条件查询列表数据
    @RequestMapping("/list")
    public RespResult list(@RequestBody ArticleLike articleLike) {
        List<ArticleLike> articleLikeList = articleLikeService.selectList(articleLike);
        RespResult respResult = new RespResult();
        respResult.success(articleLikeList);
        return respResult;
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @RequestMapping("/list/limit")
    public RespResult selectListByLimit(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "sort", required = false) String sort,
                                        @RequestParam(value = "limit", required = false) Integer limit) {
        List<ArticleLike> articleLikeList = articleLikeService.selectListByLimit(
                 field, sort, limit
        );
        RespResult respResult = new RespResult();
        respResult.success(articleLikeList);
        return respResult;
    }

    // 根据字段查询列表数据
    @RequestMapping("/list/field")
    public RespResult selectListByField(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "value", required = false) Object value) {
        List<ArticleLike> articleLikeList = articleLikeService.selectListByField(
                field, value
        );
        RespResult respResult = new RespResult();
        respResult.success(articleLikeList);
        return respResult;
    }

    // 根据条件查询单个数据
    @RequestMapping("/info/dynamic")
    public RespResult infoDynamic(@RequestBody ArticleLike data) {
        ArticleLike articleLike = articleLikeService.selectOne(data);
        RespResult respResult = new RespResult();
        respResult.success(articleLike);
        return respResult;
    }

    // 根据ID查询单个数据
    @RequestMapping("/info")
    public RespResult info(@RequestParam("id") Integer id) {
        ArticleLike articleLike = articleLikeService.selectByPrimaryKey(id);
        RespResult respResult = new RespResult();
        respResult.success(articleLike);
        return respResult;
    }

    // 根据ID查询数据详情
    @RequestMapping("/details")
    public RespResult details(@RequestParam("id") Integer id) {
        ArticleLike articleLike = articleLikeService.selectOneByDetails(id);
        RespResult respResult = new RespResult();
        respResult.success(articleLike);
        return respResult;
    }

    // 全部条数
    @RequestMapping("/count")
    public RespResult count() {
        int count = articleLikeService.selectAllCount();
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件查询数据条数
    @RequestMapping("/count/dynamic")
    public RespResult countDynamic(@RequestBody ArticleLike articleLike) {
        int count = articleLikeService.selectCount(articleLike);
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件修改全部数据
    @RequestMapping("/update/all")
    public RespResult updateAll(@RequestBody ArticleLike articleLike) {
        articleLikeService.updateAll(articleLike);
        RespResult respResult = new RespResult();
        return respResult;
    }

    // 添加数据
    @RequestMapping("/add")
    public RespResult add(@RequestBody ArticleLike articleLike) {
        articleLikeService.insertSelective(articleLike);
        RespResult respResult = new RespResult();
        respResult.success(articleLike);
        return respResult;
    }

    // 修改数据
    @RequestMapping("/edit")
    public RespResult edit(@RequestBody ArticleLike articleLike) {
        articleLikeService.updateByPrimaryKeySelective(articleLike);
        RespResult respResult = new RespResult();
        respResult.success(articleLike);
        return respResult;
    }

    // 单个删除
    @RequestMapping("/delete")
    public RespResult delete(@RequestParam("id") Integer id) {
        articleLikeService.deleteByPrimaryKey(id);
        return new RespResult();
    }

    // 批量删除
    @RequestMapping("/delete/list")
    public RespResult deleteList(@RequestBody Integer[] idList) {
        for (Integer id : idList) {
            articleLikeService.deleteByPrimaryKey(id);
        }
        return new RespResult();
    }

}
