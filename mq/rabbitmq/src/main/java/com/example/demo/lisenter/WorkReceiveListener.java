package com.example.demo.lisenter;

import com.example.demo.bean.User;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 类说明
 *
 * @author pengnanfa
 * @date 2021-04-07 11:24
 */
// 2个消费者
@Component
public class WorkReceiveListener {

    // region 简单工作队列

    @RabbitListener(queues = "queue_work")
    public void receiveMessage(String msg, Message message) {
        // 只包含发送的消息
        System.out.println("消费者1:————接收到消息：" + msg);
        // channel 通道信息
        // message 附加的参数信息
    }

    @RabbitListener(queues = "queue_work")
    public void receiveMessage2(Object obj, Message message) {
        // 包含所有的信息
        System.out.println("消费者2——接收到消息：" + obj);
    }

    // endregion 简单工作队列

    // region 发布订阅模型

    @RabbitListener(queues = "queue_fanout1")
    public void receiveMsg1(String msg) {
        System.out.println("队列1-接收到消息：" + msg);
    }

    @RabbitListener(queues = "queue_fanout2")
    public void receiveMsg2(String msg) {
        System.out.println("队列2-接收到消息：" + msg);
    }

    // endregion 发布订阅模型

    // region topic模型

    @RabbitListener(queues = "queue_topic1")
    public void receiveTopicMsg1(String msg) {
        System.out.println("消费者1接收到：" + msg);
    }

    @RabbitListener(queues = "queue_topic2")
    public void receiveTopicMsg2(String msg) {
        System.out.println("消费者2接收到：" + msg);
    }

    // endregion topic模型

    // region confirm机制

    @RabbitListener(queues = "queue_confirm")
    public void receiveMsg(User user) {
        System.out.println("接收到的消息为：" + user);
    }

    // endregion confirm机制

    // region  return机制

    @RabbitListener(queues = "queue_return")
    public void receiveMsg(String msg) {
        System.out.println("接收的消息为：" + msg);
    }
    // endregion return机制
}

