package com.example.demo.system.mapper.basemapper;

import com.example.demo.system.model.domain.Role;
import com.example.demo.system.model.entity.UserRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户角色 Mapper 接口
 */
public interface UserRoleMapper {
    /**
     * 获取用户角色信息通过Id
     * @param id
     * @return
     */
    @Select("select * from userRole where id = #{id}")
    UserRole getUserRoleById(long id);

    /**
     * 获取用户角色信息通过用户Id
     * @param userId
     * @return
     */
    @Select("select * from userRole where userId = #{userId}")
    List<UserRole> getUserRoleByUserId(long userId);

    /**
     * 获取用户角色信息通过角色Id
     * @param roleId
     * @return
     */
    @Select("select * from userRole where roleId = #{roleId}")
    List<UserRole> getUserRoleByRoleId(long roleId);

    /**
     * 获取角色信息通过用户Id
     * @param userId
     * @return
     */
    @Select("select a.`id`,a.`name`,a.`orderId`,a.`displayName` from role a  inner join  userRole b on a.id = b.roleId where b.userId = #{userId}")
    List<Role> getRoleByUserId(long userId);
}
