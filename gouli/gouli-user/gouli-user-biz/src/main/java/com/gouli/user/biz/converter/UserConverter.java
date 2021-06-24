package com.gouli.user.biz.converter;

import com.gouli.common.dto.output.user.UsersDTO;
import com.gouli.user.biz.beans.Users;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户转化类
 * @author pengnanfa
 * @date 2021/1/14 16:22
 */
@Mapper(componentModel = "spring")
@Component
public interface UserConverter
{
    /**
     *  字段数量类型相同,数量少：仅能让多的转换成少的，
     * @param users
     * @return
     */
    UsersDTO usersToUsersDTO(Users users);

    /**
     *
     * @param usersDTO
     * @return Users
     */
    Users UsersDTOToUsers(UsersDTO usersDTO);


    /**
     * Students 转化为 Users
     * @param usersDTOList
     * @return
     */
    List<Users> UsersDTOToUsersList(List<UsersDTO> usersDTOList);

    /**
     * Students 转化为 Users
     * @param usersList
     * @return
     */
    List<UsersDTO> usersToUsersDTOList(List<Users> usersList);
}
