package com.gouli.user.biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gouli.user.biz.beans.Users;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

/**
 * <p>
 * 用户表	 Mapper 接口
 * </p>
 *
 * @author pengnanfa
 * @since 2021-01-14
 */
public interface UsersMapper extends BaseMapper<Users> {

    @Insert(
            {   "<script>",
                   "INSERT INTO `users`(`username`, `password`, `enabled`) ",
                    "VALUES",
                    "<foreach collection ='list' item='users' separator =','>",
                    "(#{users.username},#{users.password},1)",
                    "</foreach> ",
                    "</script>"
            }
    )
    int addUser(List<Users> users);

}
