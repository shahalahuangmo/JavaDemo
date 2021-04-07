package com.example.demo.controller;

import com.example.demo.service.RabbitmqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类说明
 *
 * @author pengnanfa
 * @date 2021-04-07 11:25
 */
@RestController
public class RabbitmqController {
    @Autowired
    private RabbitmqService rabbitmqService;

    @RequestMapping("/sendWork")
    public Object sendWork() {
        rabbitmqService.sendWork();
        return "发送成功...";
    }

    /**
     * 向发布订阅模式里面发送消息
     *
     * @return
     */
    @RequestMapping("/sendPublish")
    public String sendPublish() {
        rabbitmqService.sendPublish();
        return "发送成功...";
    }

    /**
     * 向topic模型发送数据
     *
     * @return
     */
    @RequestMapping("/sendTopic")
    public String sendTopic() {
        rabbitmqService.sendTopic();
        return "发送成功...";
    }

    /**
     * 测试 confirm 机制
     *
     * @return
     */
    @RequestMapping("/sendConfirm")
    public String sendConfirm() {
        rabbitmqService.sendConfirm();
        return "发送成功...";
    }

    /**
     * 测试return机制
     */
    @RequestMapping("/sendReturn")
    public void sendReturn() {
        rabbitmqService.sendReturn();
    }
}

