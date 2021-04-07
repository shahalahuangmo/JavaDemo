package com.example.demo.service;

/**
 * 类说明
 *
 * @author pengnanfa
 * @date 2021-04-07 11:21
 */
public interface RabbitmqService {
    void sendWork();

    /**
     * 向发布订阅模式里面发送消息
     */
    void sendPublish();

    /**
     * 向topic模型发送数据
     */
    void sendTopic();

    /**
     * 测试 confirm 机制
     */
    void sendConfirm();

    /**
     * 测试return机制
     */
    void sendReturn();
}
