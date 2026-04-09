package com.xbb.mapper;

import java.util.Date;
import java.util.List;
import com.xbb.entity.Links;
import org.apache.ibatis.annotations.Param;

public interface LinksMapper {

    // 删除数据
    int deleteByPrimaryKey(Integer id);

    // 插入数据
    int insert(Links links);

    // 插入数据
    int insertSelective(Links links);

    // 根据ID查询单个数据
    Links selectByPrimaryKey(Integer id);

    // 修改数据
    int updateByPrimaryKeySelective(Links links);

    // 修改数据
    int updateByPrimaryKey(Links links);

    // 查询分页数据
    List<Links> selectListByPaging(
            @Param("page") Integer page,
            @Param("limit") Integer limit,
            @Param("name") String name
    );

    // 查询分页数据条数
    int selectCountByPaging(
            @Param("name") String name
    );

    // 查询全部数据
    List<Links> selectAll();

    // 根据条件查询列表数据
    List<Links> selectList(Links links);

    // 根据字段、排序方式、limit条 查询列表数据
    List<Links> selectListByLimit(
            @Param("field") String field,
            @Param("sort") String sort,
            @Param("limit") Integer limit
    );

    // 根据字段查询列表数据
    List<Links> selectListByField(
            @Param("field") String field,
            @Param("value") Object value
    );

    // 根据条件查询单个数据
    Links selectOne(Links links);

    // 根据ID查询详情数据
    Links selectOneByDetails(Integer id);

    // 查询全部条数
    int selectAllCount();

    // 根据条件查询数据条数
    int selectCount(Links links);

    // 根据条件修改全部数据
    int updateAll(Links links);


}
