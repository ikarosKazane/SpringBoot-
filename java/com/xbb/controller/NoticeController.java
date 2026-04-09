package com.xbb.controller;

import com.xbb.common.RespResult;
import com.xbb.constant.SessionConstant;
import com.xbb.entity.User;
import com.xbb.entity.Notice;
import com.xbb.service.NoticeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 公告Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/notice")
public class NoticeController {

    @Resource
    private NoticeService noticeService;

    // 根据条件查询分页数据及条数
    @RequestMapping("/data")
    public RespResult data(@RequestParam("page") int page,
                           @RequestParam("limit") int limit,
                           @RequestParam(value = "title", required = false) String title,
                           @RequestParam(value = "userId", required = false) Integer userId,
                           HttpSession session) {
        User user = (User) session.getAttribute(SessionConstant.KEY_USER);
        List<Notice> noticeList = noticeService.selectListByPaging(
                page,
                limit,
                title,
                userId
        );
        int count = noticeService.selectCountByPaging(
                title,
                userId
        );
        RespResult respResult = new RespResult();
        respResult.success(noticeList, count);
        return respResult;
    }

    // 查询全部数据
    @RequestMapping("/all")
    public RespResult all() {
        List<Notice> noticeList = noticeService.selectAll();
        RespResult respResult = new RespResult();
        respResult.success(noticeList);
        return respResult;
    }

    // 根据条件查询列表数据
    @RequestMapping("/list")
    public RespResult list(@RequestBody Notice notice) {
        List<Notice> noticeList = noticeService.selectList(notice);
        RespResult respResult = new RespResult();
        respResult.success(noticeList);
        return respResult;
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @RequestMapping("/list/limit")
    public RespResult selectListByLimit(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "sort", required = false) String sort,
                                        @RequestParam(value = "limit", required = false) Integer limit) {
        List<Notice> noticeList = noticeService.selectListByLimit(
                 field, sort, limit
        );
        RespResult respResult = new RespResult();
        respResult.success(noticeList);
        return respResult;
    }

    // 根据字段查询列表数据
    @RequestMapping("/list/field")
    public RespResult selectListByField(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "value", required = false) Object value) {
        List<Notice> noticeList = noticeService.selectListByField(
                field, value
        );
        RespResult respResult = new RespResult();
        respResult.success(noticeList);
        return respResult;
    }

    // 根据条件查询单个数据
    @RequestMapping("/info/dynamic")
    public RespResult infoDynamic(@RequestBody Notice data) {
        Notice notice = noticeService.selectOne(data);
        RespResult respResult = new RespResult();
        respResult.success(notice);
        return respResult;
    }

    // 根据ID查询单个数据
    @RequestMapping("/info")
    public RespResult info(@RequestParam("id") Integer id) {
        Notice notice = noticeService.selectByPrimaryKey(id);
        RespResult respResult = new RespResult();
        respResult.success(notice);
        return respResult;
    }

    // 根据ID查询数据详情
    @RequestMapping("/details")
    public RespResult details(@RequestParam("id") Integer id) {
        Notice notice = noticeService.selectOneByDetails(id);
        notice.setReadCount(notice.getReadCount() + 1);
        noticeService.updateByPrimaryKeySelective(notice);
        RespResult respResult = new RespResult();
        respResult.success(notice);
        return respResult;
    }

    // 全部条数
    @RequestMapping("/count")
    public RespResult count() {
        int count = noticeService.selectAllCount();
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件查询数据条数
    @RequestMapping("/count/dynamic")
    public RespResult countDynamic(@RequestBody Notice notice) {
        int count = noticeService.selectCount(notice);
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件修改全部数据
    @RequestMapping("/update/all")
    public RespResult updateAll(@RequestBody Notice notice) {
        noticeService.updateAll(notice);
        RespResult respResult = new RespResult();
        return respResult;
    }

    // 添加数据
    @RequestMapping("/add")
    public RespResult add(@RequestBody Notice notice) {
        notice.setCreatTime(new Date());
        noticeService.insertSelective(notice);
        RespResult respResult = new RespResult();
        respResult.success(notice);
        return respResult;
    }

    // 修改数据
    @RequestMapping("/edit")
    public RespResult edit(@RequestBody Notice notice) {
        noticeService.updateByPrimaryKeySelective(notice);
        RespResult respResult = new RespResult();
        respResult.success(notice);
        return respResult;
    }

    // 单个删除
    @RequestMapping("/delete")
    public RespResult delete(@RequestParam("id") Integer id) {
        noticeService.deleteByPrimaryKey(id);
        return new RespResult();
    }

    // 批量删除
    @RequestMapping("/delete/list")
    public RespResult deleteList(@RequestBody Integer[] idList) {
        for (Integer id : idList) {
            noticeService.deleteByPrimaryKey(id);
        }
        return new RespResult();
    }

}
