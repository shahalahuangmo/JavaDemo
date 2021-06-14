package com.example.demo.service.impl;

import com.example.demo.bean.User;
import com.example.demo.mapper.RabbitmqMapper;
import com.example.demo.service.RabbitmqService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 类说明
 *
 * @author pengnanfa
 * @date 2021-04-07 11:22
 */
@Service
public class RabbitmqServiceImpl implements RabbitmqService {
    @Autowired
    private RabbitmqMapper rabbitmqMapper;

    @Override
    @Transactional
    public void sendWork() {
        rabbitmqMapper.sendWork();
    }

    /**
     * 向发布订阅模式里面发送消息
     */
    @Override
    public void sendPublish() {
        rabbitmqMapper.sendPublish();
    }

    /**
     * 向topic模型发送数据
     */
    @Override
    public void sendTopic() {
        rabbitmqMapper.sendTopic();
    }

    /**
     * 测试 confirm 机制
     */
    @Override
    public void sendConfirm() {
       rabbitmqMapper.sendConfirm();
    }

    /**
     * 测试return机制
     */
    @Override
    public void sendReturn() {
         rabbitmqMapper.sendReturn();
    }
}

