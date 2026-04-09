package com.xbb.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.xbb.mapper.ArticleCommentMapper;
import com.xbb.entity.ArticleComment;
import com.xbb.service.ArticleCommentService;
import org.springframework.stereotype.Service;

@Service
public class ArticleCommentServiceImpl implements ArticleCommentService {

    @Resource
    private ArticleCommentMapper articleCommentMapper;

    // 删除数据
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return articleCommentMapper.deleteByPrimaryKey(id);
    }

    // 插入数据
    @Override
    public int insert(ArticleComment articleComment) {
        return articleCommentMapper.insert(articleComment);
    }

    // 插入数据
    @Override
    public int insertSelective(ArticleComment articleComment) {
        return articleCommentMapper.insertSelective(articleComment);
    }

    // 根据ID查询单个数据
    @Override
    public ArticleComment selectByPrimaryKey(Integer id) {
        return articleCommentMapper.selectByPrimaryKey(id);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKeySelective(ArticleComment articleComment) {
        return articleCommentMapper.updateByPrimaryKeySelective(articleComment);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKey(ArticleComment articleComment) {
        return articleCommentMapper.updateByPrimaryKey(articleComment);
    }

    // 根据条件查询分页数据
    @Override
    public List<ArticleComment> selectListByPaging(Integer page, Integer limit, Integer userId, Integer articleId, String title, String content) {
        return articleCommentMapper.selectListByPaging(
                (page - 1) * limit,
                limit,
                userId,
                articleId,
                title,
                content
        );
    }

    // 根据条件查询数据条数
    @Override
    public int selectCountByPaging(Integer userId, Integer articleId, String title, String content) {
        return articleCommentMapper.selectCountByPaging(
                userId,
                articleId,
                title,
                content
        );
    }

    // 查询全部数据
    @Override
    public List<ArticleComment> selectAll() {
        return articleCommentMapper.selectAll();
    }

    // 根据条件查询列表数据
    @Override
    public List<ArticleComment> selectList(ArticleComment articleComment) {
        return articleCommentMapper.selectList(articleComment);
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @Override
    public List<ArticleComment> selectListByLimit(String field, String sort, Integer limit) {
        return articleCommentMapper.selectListByLimit(field, sort, limit);
    }

    // 根据字段查询列表数据
    @Override
    public List<ArticleComment> selectListByField(String field, Object value) {
        return articleCommentMapper.selectListByField(field, value);
    }

    // 根据条件查询单个数据
    @Override
    public ArticleComment selectOne(ArticleComment articleComment) {
        return articleCommentMapper.selectOne(articleComment);
    }

    // 根据ID查询详情数据
    @Override
    public ArticleComment selectOneByDetails(Integer id) {
        return articleCommentMapper.selectOneByDetails(id);
    }

    // 查询全部条数
    @Override
    public int selectAllCount() {
        return articleCommentMapper.selectAllCount();
    }

    // 根据条件查询数据条数
    @Override
    public int selectCount(ArticleComment articleComment) {
        return articleCommentMapper.selectCount(articleComment);
    }

    // 根据条件修改全部数据
    @Override
    public int updateAll(ArticleComment articleComment) {
        return articleCommentMapper.updateAll(articleComment);
    }


}
