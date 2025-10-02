package com.hmdp.mq;

import com.hmdp.config.RocketMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * RocketMQ消息发送者
 */
@Slf4j
@Service
public class MQSender {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 发送秒杀信息
     * @param msg
     */
    public void sendSeckillMessage(String msg){
        log.info("发送RocketMQ消息: " + msg);
        Message<String> message = MessageBuilder.withPayload(msg).build();
        rocketMQTemplate.syncSend(RocketMQConfig.TOPIC + ":" + RocketMQConfig.TAG, message);
    }
}
