package com.xbb.mapper;

import java.util.Date;
import java.util.List;
import com.xbb.entity.Banner;
import org.apache.ibatis.annotations.Param;

public interface BannerMapper {

    // 删除数据
    int deleteByPrimaryKey(Integer id);

    // 插入数据
    int insert(Banner banner);

    // 插入数据
    int insertSelective(Banner banner);

    // 根据ID查询单个数据
    Banner selectByPrimaryKey(Integer id);

    // 修改数据
    int updateByPrimaryKeySelective(Banner banner);

    // 修改数据
    int updateByPrimaryKey(Banner banner);

    // 查询分页数据
    List<Banner> selectListByPaging(
            @Param("page") Integer page,
            @Param("limit") Integer limit,
            @Param("status") Boolean status,
            @Param("name") String name
    );

    // 查询分页数据条数
    int selectCountByPaging(
            @Param("status") Boolean status,
            @Param("name") String name
    );

    // 查询全部数据
    List<Banner> selectAll();

    // 根据条件查询列表数据
    List<Banner> selectList(Banner banner);

    // 根据字段、排序方式、limit条 查询列表数据
    List<Banner> selectListByLimit(
            @Param("field") String field,
            @Param("sort") String sort,
            @Param("limit") Integer limit
    );

    // 根据字段查询列表数据
    List<Banner> selectListByField(
            @Param("field") String field,
            @Param("value") Object value
    );

    // 根据条件查询单个数据
    Banner selectOne(Banner banner);

    // 根据ID查询详情数据
    Banner selectOneByDetails(Integer id);

    // 查询全部条数
    int selectAllCount();

    // 根据条件查询数据条数
    int selectCount(Banner banner);

    // 根据条件修改全部数据
    int updateAll(Banner banner);

}
