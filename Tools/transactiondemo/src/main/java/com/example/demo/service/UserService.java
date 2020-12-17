package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
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
    public int insertAndUpdateUser(List<User> users) throws Exception {
        User addUser = users.get(1);
        User updateUser = users.get(0);
        int j = userMapper.insert(addUser);
        userMapper.update(updateUser);
        int i = 1 / 0;
        return j;
    }

    /**
     * 可选的事务隔离级别设置
     *
     * @param users
     * @return
     * @throws Exception
     */
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public int insertAndUpdateUserIsolation(List<User> users) throws Exception {
        User addUser = users.get(1);
        User updateUser = users.get(0);
        int j = userMapper.insert(addUser);
        userMapper.update(updateUser);
        int i = 1 / 0;
        return j;
    }

    /**
     * 事务超时时间设置
     *
     * @param users
     * @return
     * @throws Exception
     */
    @Transactional(timeout = 200)
    public int insertAndUpdateUserTimeOut(List<User> users) throws Exception {
        User addUser = users.get(1);
        User updateUser = users.get(0);
        int j = userMapper.insert(addUser);
        userMapper.update(updateUser);
        int i = 1 / 0;
        return j;
    }

    /**
     * 读写或只读事务，默认读写
     *
     * @param users
     * @return
     * @throws Exception
     */
    @Transactional(readOnly = true)
    public int insertAndUpdateUserReadOnly(List<User> users) throws Exception {
        User addUser = users.get(1);
        User updateUser = users.get(0);
        int j = userMapper.insert(addUser);
        userMapper.update(updateUser);
        int i = 1 / 0;
        return j;
    }


    /**
     * 可选的事务传播行为设置
     *
     * @param users
     * @return
     * @throws Exception
     */
    @Transactional(propagation = Propagation.NESTED)
    public int insertAndUpdateUserPropagation(List<User> users) throws Exception {
        User addUser = users.get(1);
        User updateUser = users.get(0);
        int j = userMapper.insert(addUser);
        userMapper.update(updateUser);
        int i = 1 / 0;
        return j;
    }


    /**
     * 导致事务回滚的异常类数组
     *
     * @param users
     * @return
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public int insertAndUpdateUserRollbackFor(List<User> users) throws Exception {
        User addUser = users.get(1);
        User updateUser = users.get(0);
        int j = userMapper.insert(addUser);
        userMapper.update(updateUser);
        int i = 1 / 0;
        return j;
    }


    /**
     * 导致事务回滚的异常类名字数组
     *
     * @param users
     * @return
     * @throws Exception
     */
    @Transactional(rollbackForClassName = {})
    public int insertAndUpdateUserRollbackForClassName(List<User> users) throws Exception {
        User addUser = users.get(1);
        User updateUser = users.get(0);
        int j = userMapper.insert(addUser);
        userMapper.update(updateUser);
        int i = 1 / 0;
        return j;
    }

    /**
     * 不会导致事务回滚的异常类数组
     *
     * @param users
     * @return
     * @throws Exception
     */
    @Transactional(noRollbackFor = Exception.class)
    public int insertAndUpdateUserNoRollbackFor(List<User> users) throws Exception {
        User addUser = users.get(1);
        User updateUser = users.get(0);
        int j = userMapper.insert(addUser);
        userMapper.update(updateUser);
        int i = 1 / 0;
        return j;
    }


    /**
     * 不会导致事务回滚的异常类名字数组 类名数组，必须继承自Throwable
     *
     * @param users
     * @return
     * @throws Exception
     */
    @Transactional(noRollbackForClassName = {})
    public int insertAndUpdateUserNoRollbackForClassName(List<User> users) throws Exception {
        User addUser = users.get(1);
        User updateUser = users.get(0);
        int j = userMapper.insert(addUser);
        userMapper.update(updateUser);
        int i = 1 / 0;
        return j;
    }
}
