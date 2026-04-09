package com.xbb.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.xbb.mapper.ArticleLikeMapper;
import com.xbb.entity.ArticleLike;
import com.xbb.service.ArticleLikeService;
import org.springframework.stereotype.Service;

@Service
public class ArticleLikeServiceImpl implements ArticleLikeService {

    @Resource
    private ArticleLikeMapper articleLikeMapper;

    // 删除数据
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return articleLikeMapper.deleteByPrimaryKey(id);
    }

    // 插入数据
    @Override
    public int insert(ArticleLike articleLike) {
        return articleLikeMapper.insert(articleLike);
    }

    // 插入数据
    @Override
    public int insertSelective(ArticleLike articleLike) {
        return articleLikeMapper.insertSelective(articleLike);
    }

    // 根据ID查询单个数据
    @Override
    public ArticleLike selectByPrimaryKey(Integer id) {
        return articleLikeMapper.selectByPrimaryKey(id);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKeySelective(ArticleLike articleLike) {
        return articleLikeMapper.updateByPrimaryKeySelective(articleLike);
    }

    // 修改数据
    @Override
    public int updateByPrimaryKey(ArticleLike articleLike) {
        return articleLikeMapper.updateByPrimaryKey(articleLike);
    }

    // 根据条件查询分页数据
    @Override
    public List<ArticleLike> selectListByPaging(Integer page, Integer limit, Integer articleId, Integer userId, String title) {
        return articleLikeMapper.selectListByPaging(
                (page - 1) * limit,
                limit,
                articleId,
                userId,
                title
        );
    }

    // 根据条件查询数据条数
    @Override
    public int selectCountByPaging(Integer articleId, Integer userId, String title) {
        return articleLikeMapper.selectCountByPaging(
                articleId,
                userId,
                title
        );
    }

    // 查询全部数据
    @Override
    public List<ArticleLike> selectAll() {
        return articleLikeMapper.selectAll();
    }

    // 根据条件查询列表数据
    @Override
    public List<ArticleLike> selectList(ArticleLike articleLike) {
        return articleLikeMapper.selectList(articleLike);
    }

    // 根据字段、排序方式、limit条 查询列表数据
    @Override
    public List<ArticleLike> selectListByLimit(String field, String sort, Integer limit) {
        return articleLikeMapper.selectListByLimit(field, sort, limit);
    }

    // 根据字段查询列表数据
    @Override
    public List<ArticleLike> selectListByField(String field, Object value) {
        return articleLikeMapper.selectListByField(field, value);
    }

    // 根据条件查询单个数据
    @Override
    public ArticleLike selectOne(ArticleLike articleLike) {
        return articleLikeMapper.selectOne(articleLike);
    }

    // 根据ID查询详情数据
    @Override
    public ArticleLike selectOneByDetails(Integer id) {
        return articleLikeMapper.selectOneByDetails(id);
    }

    // 查询全部条数
    @Override
    public int selectAllCount() {
        return articleLikeMapper.selectAllCount();
    }

    // 根据条件查询数据条数
    @Override
    public int selectCount(ArticleLike articleLike) {
        return articleLikeMapper.selectCount(articleLike);
    }

    // 根据条件修改全部数据
    @Override
    public int updateAll(ArticleLike articleLike) {
        return articleLikeMapper.updateAll(articleLike);
    }


}
