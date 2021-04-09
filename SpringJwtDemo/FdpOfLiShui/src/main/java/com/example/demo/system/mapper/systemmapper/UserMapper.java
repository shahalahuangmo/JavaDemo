package com.example.demo.system.mapper.systemmapper;

import com.example.demo.dynamicmapper.BaseMapper;
import com.example.demo.system.model.domain.system.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 *  系统用户 Mapper 接口
 */
public interface UserMapper extends BaseMapper<User> {
/*    *//**
     * 获取用户通过用户Id
     * @param id 用户Id
     * @return User
     */
    @Select("select * from user where id = #{id}")
    User getUserById(Long id);

    /**
     * 获取用户通过用户名
     * @param username 用户名
     * @return User getUserByUserName
     */
    @Select("select * from user where username = #{username}")
    List<User> getUserByUserName(String username);

    /**
     * 获取用户通过用户名
     * @param username 用户名
     * @return User getUserByUserName
     */
    @Select("select * from user where username = #{username} and phone = #{phone}")
    List<User> getUserByUserName(String username,String phone);

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
  /*  @Insert("INSERT INTO `test`.`user`( `username`, `password`, `email`, `phoneNumber`, `token`, `createTime`, " +
            "`deleteTime`, `isDelete`, `creator`, `deleter`)" +
            " VALUES (#{username}, #{password}, #{email},  #{phoneNumber}, #{token},#{createTime},NULL, b'0',#{creator},NULL)")*/
    @Insert("INSERT INTO user\n" +
            " (`username`, `password`, `email`, `phonenumber`, `token`, `creator`, `isdelete`, `createtime`)\n" +
            "VALUES (#{username}, #{password}, #{email}, #{phonenumber}, #{token}, #{creator}, #{isdelete}, #{createtime}))")
    int insertUser(User user);

    @Update("update user set password = #{newPwd} where id = #{id}")
    int updatePassword(Long id, String newPwd);
}
