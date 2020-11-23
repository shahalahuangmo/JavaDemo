package com.example.demo.system.mapper.basemapper;

import com.example.demo.system.model.entity.RoleFunctionPermission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 角色功能权限 Mapper 接口
 */
public interface RoleFunctionPermissionMapper {
    /**
     * 获取角色功能权限信息通过Id
     * @param id 角色功能权限Id
     * @return
     */
    @Select("select * from roleFunctionPermission where id = #{id}")
    RoleFunctionPermission getRoleFunctionPermissionById(long id);

    /**
     * 获取角色功能权限信息通过功能编码
     * @param functionCode 功能编码
     * @return
     */
    @Select("select * from roleFunctionPermission where functionCode = #{functionCode}")
    List<RoleFunctionPermission> getRoleFunctionPermissionByFunctionCode(String functionCode);

    /**
     * 获取角色功能权限信息通过角色Id
     * @param roleId  角色Id
     * @return
     */
    @Select("select * from roleFunctionPermission where roleId = #{roleId}")
    List<RoleFunctionPermission> getRoleFunctionPermissionByRoleId(long roleId);
}
