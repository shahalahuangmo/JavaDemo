package com.example.demo.system.mapper.basemapper;

import com.example.demo.system.model.entity.RoleAccessPathPermission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 角色访问路径权限 Mapper 接口
 */
public interface RoleAccessPathPermissionMapper {
    /**
     * 获取角色访问路径信息通过Id
     * @param id 角色访问路径Id
     * @return
     */
    @Select("select * from roleAccessPathPermission where id = #{id}")
    RoleAccessPathPermission getRoleAccessPathPermissionById(long id);

    /**
     * 获取角色访问路径信息通过功能编码
     * @param accessPathId 访问路径Id
     * @return
     */
    @Select("select * from roleAccessPathPermission where accessPathId = #{accessPathId}")
    List<RoleAccessPathPermission> getRoleRoleAccessPathPermissionByAccessPath(long accessPathId);

    /**
     * 获取角色访问路径信息通过角色Id
     * @param roleId  角色Id
     * @return
     */
    @Select("select * from roleAccessPathPermission where roleId = #{roleId}")
    List<RoleAccessPathPermission> getRoleAccessPathPermissionByRoleId(long roleId);
}
