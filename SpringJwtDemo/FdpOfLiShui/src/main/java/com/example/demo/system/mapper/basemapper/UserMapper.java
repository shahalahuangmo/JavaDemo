package com.example.demo.system.mapper.basemapper;

import cn.hutool.system.UserInfo;
import com.example.demo.system.model.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 *  系统用户 Mapper 接口
 */
public interface UserMapper {
    /**
     * 获取用户通过用户Id
     * @param id 用户Id
     * @return User
     */
    @Select("select * from user where id = #{id}")
    User getUserById(long id);

    /**
     * 获取用户通过用户名
     * @param username 用户名
     * @return User getUserByUserName
     */
    @Select("select * from user where username = #{username}")
    List<User> getUserByUserName(String username);

    /**
     *  更新用户token信息通过用户Id
     * @param id 用户Id
     * @param token 用户token信息
     * @return
     */
    @Update("update user set token = #{token}  where id =#{id}")
    int updateUserToken(Long id,String token);

    /**
     * 获取用户通过用户token
     * @param token 用户token
     * @return
     */
    @Select("select * from user where token = #{token} limit 1 ")
    User getUserByToken(String token);

    // 插入用户
    @Insert("INSERT INTO `test`.`user`(`username`, `password`, `email`, `phoneNumber`, `orderId`, `token`, `createTime`, `deleteTime`, `isDelete`)" +
            " VALUES (#{username}, #{password}, #{email},  #{phoneNumber}, #{orderId}, #{token},#{createTime}, NULL, b'0')")
    int insertUser(User user);

    @Update("update user set password = #{newPwd} where id = #{id}")
    int updatePassword(long id, String newPwd);
}
