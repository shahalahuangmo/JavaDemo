package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
class DemoApplicationTests {

    @Resource
    UserService userService;

    @Test
    void transactionTest()
    {
        User addUser = new User();
        addUser.setName("testUser2");
        addUser.setAge(25);
        addUser.setAddress("testUser");


        User updateUser = new User();
        updateUser.setId(1);
        updateUser.setName("testUser1");
        updateUser.setAge(25);
        updateUser.setAddress("testUser1");

        List<User> users = new ArrayList<>();
        users.add(addUser);
        users.add(updateUser);

        int i = userService.insertAndUpdateUser(users);
        Assert.assertEquals(1,i);
    }

}
