package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public List<User> getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Transactional
    public int insertAndUpdateUser(List<User> users)
    {
        User addUser = users.get(0);
        User updateUser = users.get(1);
        userMapper.insert(addUser);
        return  userMapper.update(updateUser);
    }

    public int insertUser(User user)
    {
        return  userMapper.insert(user);
    }

    public int updateUser(User user)
    {
        return  userMapper.update(user);
    }
}
