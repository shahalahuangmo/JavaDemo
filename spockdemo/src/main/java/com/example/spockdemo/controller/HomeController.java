package com.example.spockdemo.controller;

import com.example.spockdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * Description:
 * </p>
 *
 * @Author pengnanfa
 * @Date 2021-11-09 22:54
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;


    @GetMapping("/getHelloMessage/{userId}")
    @ResponseBody
    public ResponseEntity getHelloMessage(@PathVariable Integer userId) {
        String result = userService.getHelloMessage(userId);
        ResponseEntity responseEntity = new ResponseEntity(result, HttpStatus.OK);
        return responseEntity;
    }


}
