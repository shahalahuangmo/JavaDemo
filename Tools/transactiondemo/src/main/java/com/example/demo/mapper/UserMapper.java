package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User getUserById(Integer id);

    @Select("select * from user where name = #{name}")
    List<User> getUserByName(String name);

    @Insert("INSERT INTO `demo`.`user`(`name`, `age`, `address`) VALUES (#{name}, #{age}, #{address});")
    int insert(User user);

    @Update("UPDATE `demo`.`user` SET `name` = #{name}, `age` = #{age}, `address` = #{address} WHERE `id` = #{id};")
    int update(User user);
}
