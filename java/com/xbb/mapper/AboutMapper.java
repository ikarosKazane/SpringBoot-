package com.xbb.mapper;

import java.util.Date;
import java.util.List;
import com.xbb.entity.About;
import org.apache.ibatis.annotations.Param;

public interface AboutMapper {

    // 删除数据
    int deleteByPrimaryKey(Integer id);

    // 插入数据
    int insert(About about);

    // 插入数据
    int insertSelective(About about);

    // 根据ID查询单个数据
    About selectByPrimaryKey(Integer id);

    // 修改数据
    int updateByPrimaryKeySelective(About about);

    // 修改数据
    int updateByPrimaryKey(About about);

    // 查询分页数据
    List<About> selectListByPaging(
            @Param("page") Integer page,
            @Param("limit") Integer limit,
            @Param("cellphone") String cellphone,
            @Param("creatDate") String creatDate,
            @Param("status") Integer status,
            @Param("name") String name
    );

    // 查询分页数据条数
    int selectCountByPaging(
            @Param("cellphone") String cellphone,
            @Param("creatDate") String creatDate,
            @Param("status") Integer status,
            @Param("name") String name
    );

    // 查询全部数据
    List<About> selectAll();

    // 根据条件查询列表数据
    List<About> selectList(About about);

    // 根据字段、排序方式、limit条 查询列表数据
    List<About> selectListByLimit(
            @Param("field") String field,
            @Param("sort") String sort,
            @Param("limit") Integer limit
    );

    // 根据字段查询列表数据
    List<About> selectListByField(
            @Param("field") String field,
            @Param("value") Object value
    );

    // 根据条件查询单个数据
    About selectOne(About about);

    // 根据ID查询详情数据
    About selectOneByDetails(Integer id);

    // 查询全部条数
    int selectAllCount();

    // 根据条件查询数据条数
    int selectCount(About about);

    // 根据条件修改全部数据
    int updateAll(About about);


}
