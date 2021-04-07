package com.example.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 类说明
 *
 * @author pengnanfa
 * @date 2021-04-07 11:20
 */
@SpringBootConfiguration
public class RabbitmqConfig {

    // region 简单工作队列

    /**
     * 配置一个工作模型队列
     *
     * @return
     */
    @Bean
    public Queue queueWork1() {
        return new Queue("queue_work");
    }

    // endregion

    // region 发布订阅模式

    /**
     * 声明两个队列
     *
     * @return
     */
    @Bean
    public Queue queueFanout1() {
        return new Queue("queue_fanout1");
    }

    @Bean
    public Queue queueFanout2() {
        return new Queue("queue_fanout2");
    }

    /**
     * 准备一个交换机
     *
     * @return
     */
    @Bean
    public FanoutExchange exchangeFanout() {
        return new FanoutExchange("exchange_fanout");
    }

    /**
     * 将交换机和队列进行绑定
     *
     * @return
     */
    @Bean
    public Binding bindingExchange1() {
        return BindingBuilder.bind(queueFanout1()).to(exchangeFanout());
    }

    @Bean
    public Binding bindingExchange2() {
        return BindingBuilder.bind(queueFanout2()).to(exchangeFanout());
    }

    // endregion

    // region  topic 模型

    @Bean
    public Queue queueTopic1() {
        return new Queue("queue_topic1");
    }

    @Bean
    public Queue queueTopic2() {
        return new Queue("queue_topic2");
    }

    @Bean
    public TopicExchange exchangeTopic() {
        return new TopicExchange("exchange_topic");
    }

    @Bean
    public Binding bindingTopic1() {
        return BindingBuilder.bind(queueTopic1()).to(exchangeTopic()).with("topic.#");
    }

    @Bean
    public Binding bindingTopic2() {
        return BindingBuilder.bind(queueTopic2()).to(exchangeTopic()).with("topic.*");
    }
    // endregion

    // region confirm 机制

    /**
     * 测试confirm 机制，专门创建了一个队列
     *
     * @return
     */
    @Bean
    public Queue queueConfirm() {
        return new Queue("queue_confirm");
    }

    // endregion

    // region return机制

    /**
     * 测试return机制
     *
     * @return
     */
    @Bean
    public Queue queueReturn() {
        return new Queue("queue_return");
    }

    @Bean
    public TopicExchange exchangeReturn() {
        return new TopicExchange("exchange_return");
    }

    @Bean
    public Binding bindingReturn() {
        return BindingBuilder.bind(queueReturn()).to(exchangeReturn()).with("return.*");
    }

    // endregion

    // region TTL队列、死信队列

    /**
     *  TTL 队列
     * @return
     */
    @Bean
    public Queue queueTTL() {
        Map<String, Object> map = new HashMap<>(1);
        map.put("x-message-ttl", 10000);
        return new Queue("queue_ttl", true, false, false, map);
    }

    // 产生死信的队列
    @Bean
    public Queue queueDLX() {
        Map<String, Object> map = new HashMap<>(2);
        // 5秒后，消息自动变为死信
        map.put("x-message-ttl", 5000);
        map.put("x-dead-letter-exchange", "exchange_receive");
        map.put("x-dead-letter-routing-key", "receive_key");
        return new Queue("queue_dlx", true, false, false, map);
    }

    /**
     * 死信交换机
     * @return
     */
    @Bean
    public DirectExchange exchangeDLX() {
        return new DirectExchange("exchange_dlx");
    }

    /**
     * 给死信队列绑定交换机
     * @return
     */
    @Bean
    public Binding bindingDLX() {
        return BindingBuilder.bind(queueDLX()).to(exchangeDLX()).with("receive_key");
    }

    /**
     * 死信接收交换机
     * @return
     */
    @Bean
    public DirectExchange exchangeReceive() {
        return new DirectExchange("exchange_receive");
    }

    /**
     * 接收死信的队列
     * @return
     */
    @Bean
    public Queue queueReceive() {
        return new Queue("queue_receive");
    }

    /**
     * 将交换机与队列绑定
     * @return
     */
    @Bean
    public Binding bindingReceive() {
        return BindingBuilder.bind(queueReceive()).to(exchangeReceive()).with("receive_key");
    }


    // endregion


}

