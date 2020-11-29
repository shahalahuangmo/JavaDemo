package com.example.demo.system.mapper.systemmapper;

import com.example.demo.dynamicmapper.BaseMapper;
import com.example.demo.system.model.domain.system.AccessPath;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 访问路径 Mapper 接口
 */

public interface AccessPathMapper extends BaseMapper<AccessPathMapper> {
    /**
     *  获取访问路径信息通过Id
     * @param id 功能Id
     * @return
     */
    @Select("select * from accessPath where id = #{id}")
    AccessPath getAccessPathById(long id);

    /**
     * 获取所有的访问路径信息
     * @return
     */
    @Select("select * from accessPath")
    List<AccessPath> selectAllAccessPath();

    /**
     * 获取所有的访问路径信息
     * @return
             */
    @Select("select * from accessPath where  accessPath =#{url}")
    List<AccessPath> getAccessPathByUrl(String url);
}
