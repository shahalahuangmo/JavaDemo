package com.example.demo.system.mapper.systemmapper;

import com.example.demo.dynamicmapper.BaseMapper;
import com.example.demo.system.model.domain.system.Role;
import com.example.demo.system.model.domain.system.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *  系统角色 Mapper 接口
 */
public interface RoleMapper  extends BaseMapper<Role> {
    /**
     * 根据角色Id获取角色信息
     * @param id
     * @return
     */
    @Select("select * from role where id = #{id}")
    Role getRoleById(long id);


    /**
     * 根据访问路径获取其角色信息
     * @param url
     * @return
     */
    @Select("select * from role where id in (select roleId from roleAccessPathPermission where accessPathId in (select id from accessPath where  accessPath = #{url}))")
    List<Role> getRoleByAccessPathUrl(String url);

}
