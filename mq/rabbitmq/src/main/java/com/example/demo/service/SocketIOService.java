package com.example.demo.service;

import com.example.demo.bean.PushMessage;

/**
 * 类说明
 *
 * @author pengnanfa
 * @date 2021-04-08 18:01
 */
public interface SocketIOService {

    /**
     * 推送的事件
     */
    public static final String PUSH_EVENT = "push_event";

    /**
     * 启动服务
     * @throws Exception
     */
    void start() throws Exception;

    /**
     * 启动服务
     */
    void stop();

    /**
     * 推送信息
     * @param pushMessage
     */
    void pushMessageToUser(PushMessage pushMessage);
}

