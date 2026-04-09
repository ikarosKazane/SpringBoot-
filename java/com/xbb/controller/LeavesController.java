package com.xbb.controller;

import com.xbb.common.RespResult;
import com.xbb.constant.SessionConstant;
import com.xbb.entity.User;
import com.xbb.entity.Leaves;
import com.xbb.service.LeavesService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 留言Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/leaves")
public class LeavesController {

    @Resource
    private LeavesService leavesService;

    // 根据条件查询分页数据及条数
    @RequestMapping("/data")
    public RespResult data(@RequestParam("page") int page,
                           @RequestParam("limit") int limit,
                           @RequestParam(value = "userId", required = false) Integer userId,
                           @RequestParam(value = "content", required = false) String content,
                           @RequestParam(value = "replyCon", required = false) String replyCon,
                           HttpSession session) {
        User user = (User) session.getAttribute(SessionConstant.KEY_USER);
        List<Leaves> leavesList = leavesService.selectListByPaging(
                page,
                limit,
                userId,
                content,
                replyCon
        );
        int count = leavesService.selectCountByPaging(
                userId,
                content,
                replyCon
        );
        RespResult respResult = new RespResult();
        respResult.success(leavesList, count);
        return respResult;
    }

    // 查询全部数据
    @RequestMapping("/all")
    public RespResult all() {
        List<Leaves> leavesList = leavesService.selectAll();
        RespResult respResult = new RespResult();
        respResult.success(leavesList);
        return respResult;
    }

    // 根据条件查询列表数据
    @RequestMapping("/list")
    public RespResult list(@RequestBody Leaves leaves) {
        List<Leaves> leavesList = leavesService.selectList(leaves);
        RespResult respResult = new RespResult();
        respResult.success(leavesList);
        return respResult;
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @RequestMapping("/list/limit")
    public RespResult selectListByLimit(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "sort", required = false) String sort,
                                        @RequestParam(value = "limit", required = false) Integer limit) {
        List<Leaves> leavesList = leavesService.selectListByLimit(
                 field, sort, limit
        );
        RespResult respResult = new RespResult();
        respResult.success(leavesList);
        return respResult;
    }

    // 根据字段查询列表数据
    @RequestMapping("/list/field")
    public RespResult selectListByField(@RequestParam(value = "field", required = false) String field,
                                        @RequestParam(value = "value", required = false) Object value) {
        List<Leaves> leavesList = leavesService.selectListByField(
                field, value
        );
        RespResult respResult = new RespResult();
        respResult.success(leavesList);
        return respResult;
    }

    // 根据条件查询单个数据
    @RequestMapping("/info/dynamic")
    public RespResult infoDynamic(@RequestBody Leaves data) {
        Leaves leaves = leavesService.selectOne(data);
        RespResult respResult = new RespResult();
        respResult.success(leaves);
        return respResult;
    }

    // 根据ID查询单个数据
    @RequestMapping("/info")
    public RespResult info(@RequestParam("id") Integer id) {
        Leaves leaves = leavesService.selectByPrimaryKey(id);
        RespResult respResult = new RespResult();
        respResult.success(leaves);
        return respResult;
    }

    // 根据ID查询数据详情
    @RequestMapping("/details")
    public RespResult details(@RequestParam("id") Integer id) {
        Leaves leaves = leavesService.selectOneByDetails(id);
        RespResult respResult = new RespResult();
        respResult.success(leaves);
        return respResult;
    }

    // 全部条数
    @RequestMapping("/count")
    public RespResult count() {
        int count = leavesService.selectAllCount();
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件查询数据条数
    @RequestMapping("/count/dynamic")
    public RespResult countDynamic(@RequestBody Leaves leaves) {
        int count = leavesService.selectCount(leaves);
        RespResult respResult = new RespResult();
        respResult.success(count);
        return respResult;
    }

    // 根据条件修改全部数据
    @RequestMapping("/update/all")
    public RespResult updateAll(@RequestBody Leaves leaves) {
        leavesService.updateAll(leaves);
        RespResult respResult = new RespResult();
        return respResult;
    }

    // 添加数据
    @RequestMapping("/add")
    public RespResult add(@RequestBody Leaves leaves) {
        leaves.setCreatTime(new Date());
        leavesService.insertSelective(leaves);
        RespResult respResult = new RespResult();
        respResult.success(leaves);
        return respResult;
    }

    // 修改数据
    @RequestMapping("/edit")
    public RespResult edit(@RequestBody Leaves leaves) {
        leaves.setReplyTime(new Date());
        leavesService.updateByPrimaryKeySelective(leaves);
        RespResult respResult = new RespResult();
        respResult.success(leaves);
        return respResult;
    }

    // 单个删除
    @RequestMapping("/delete")
    public RespResult delete(@RequestParam("id") Integer id) {
        leavesService.deleteByPrimaryKey(id);
        return new RespResult();
    }

    // 批量删除
    @RequestMapping("/delete/list")
    public RespResult deleteList(@RequestBody Integer[] idList) {
        for (Integer id : idList) {
            leavesService.deleteByPrimaryKey(id);
        }
        return new RespResult();
    }

}
