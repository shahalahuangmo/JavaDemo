package com.example.demo.controller;

import com.corundumstudio.socketio.SocketIOClient;
import com.example.demo.lisenter.ClientCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.UUID;

/**
 * 类说明
 *
 * @author pengnanfa
 * @date 2021-04-08 18:32
 */
@RestController
@RequestMapping("/push")
public class PushController {
    @Resource
    private ClientCache clientCache;

    @GetMapping("/message")
    public String pushTuUser(@PathParam("userId") String id) {
        Integer userId = 4;
        HashMap<UUID, SocketIOClient> userClient = clientCache.getUserClient(String.valueOf(userId));
        userClient.forEach((uuid, socketIOClient) -> {
            //向客户端推送消息
            socketIOClient.sendEvent("chatevent", "服务端推送消息");
        });
        return "success";
    }
}

