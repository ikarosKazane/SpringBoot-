package com.xbb.controller;

import com.xbb.common.RespResult;
import com.xbb.constant.SessionConstant;
import com.xbb.entity.User;
import com.xbb.entity.ArticleComment;
import com.xbb.service.ArticleCommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 文章评论Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/articleComment")
public class ArticleCommentController {

    @Resource
    private ArticleCommentService articleCommentService;

    // 根据条件查询分页数据及条数
    @RequestMapping("/data")
    public RespResult data(@RequestParam("page") int page,
                           @RequestParam("limit") int limit,
                           @RequestParam(value = "userId", required = false) Integer userId,
                           @RequestParam(value = "articleId", required = false) Integer articleId,
                           @RequestParam(value = "title", required = false) String title,
                           @RequestParam(value = "content", required = false) String content,
                           HttpSession session) {
        User user = (User) session.getAttribute(SessionConstant.KEY_USER);
        List<ArticleComment> articleCommentList = articleCommentService.selectListByPaging(
                page,
                limit,
                userId,
                articleId,
                title,
                content
        );
        int count = articleCommentService.selectCountByPaging(
                userId,
                articleId,
                title,
                content
        );
        RespResult respResult = new RespResult();
        respResult.success(articleCommentList, count);
        return respResult;
    }

    // 查询全部数据
    @RequestMapping("/all")
    public RespResult all() {
        List<ArticleComment> articleCommentList = articleCommentService.selectAll();
        RespResult respResult = new RespResult();
        respResult.success(articleCommentList);
        return respResult;
    }

    // 根据条件查询列表数据
    @RequestMapping("/list")
    public RespResult list(@RequestBody ArticleComment articleComment) {
        List<ArticleComment> articleCommentList = articleCommentService.selectList(articleComment);
        RespResult respResult = new RespResult();
        respResult.success(articleCommentList);
        return respResult;
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @RequestMapping("/list/limit")
    public RespResult selectListByLimit(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "sort", required = false) String sort,
                                        @RequestParam(value = "limit", required = false) Integer limit) {
        List<ArticleComment> articleCommentList = articleCommentService.selectListByLimit(
                 field, sort, limit
        );
        RespResult respResult = new RespResult();
        respResult.success(articleCommentList);
        return respResult;
    }

    // 根据字段查询列表数据
    @RequestMapping("/list/field")
    public RespResult selectListByField(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "value", required = false) Object value) {
        List<ArticleComment> articleCommentList = articleCommentService.selectListByField(
                field, value
        );
        RespResult respResult = new RespResult();
        respResult.success(articleCommentList);
        return respResult;
    }

    // 根据条件查询单个数据
    @RequestMapping("/info/dynamic")
    public RespResult infoDynamic(@RequestBody ArticleComment data) {
        ArticleComment articleComment = articleCommentService.selectOne(data);
        RespResult respResult = new RespResult();
        respResult.success(articleComment);
        return respResult;
    }

    // 根据ID查询单个数据
    @RequestMapping("/info")
    public RespResult info(@RequestParam("id") Integer id) {
        ArticleComment articleComment = articleCommentService.selectByPrimaryKey(id);
        RespResult respResult = new RespResult();
        respResult.success(articleComment);
        return respResult;
    }

    // 根据ID查询数据详情
    @RequestMapping("/details")
    public RespResult details(@RequestParam("id") Integer id) {
        ArticleComment articleComment = articleCommentService.selectOneByDetails(id);
        RespResult respResult = new RespResult();
        respResult.success(articleComment);
        return respResult;
    }

    // 全部条数
    @RequestMapping("/count")
    public RespResult count() {
        int count = articleCommentService.selectAllCount();
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件查询数据条数
    @RequestMapping("/count/dynamic")
    public RespResult countDynamic(@RequestBody ArticleComment articleComment) {
        int count = articleCommentService.selectCount(articleComment);
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件修改全部数据
    @RequestMapping("/update/all")
    public RespResult updateAll(@RequestBody ArticleComment articleComment) {
        articleCommentService.updateAll(articleComment);
        RespResult respResult = new RespResult();
        return respResult;
    }

    // 添加数据
    @RequestMapping("/add")
    public RespResult add(@RequestBody ArticleComment articleComment) {
        RespResult respResult = new RespResult();
        articleComment.setCreatTime(new Date());
        articleCommentService.insertSelective(articleComment);
        respResult.success(articleComment);
        return respResult;
    }

    // 修改数据
    @RequestMapping("/edit")
    public RespResult edit(@RequestBody ArticleComment articleComment) {
        articleCommentService.updateByPrimaryKeySelective(articleComment);
        RespResult respResult = new RespResult();
        respResult.success(articleComment);
        return respResult;
    }

    // 单个删除
    @RequestMapping("/delete")
    public RespResult delete(@RequestParam("id") Integer id) {
        articleCommentService.deleteByPrimaryKey(id);
        return new RespResult();
    }

    // 批量删除
    @RequestMapping("/delete/list")
    public RespResult deleteList(@RequestBody Integer[] idList) {
        for (Integer id : idList) {
            articleCommentService.deleteByPrimaryKey(id);
        }
        return new RespResult();
    }

}
