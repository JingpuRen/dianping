package com.hmdp.config;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RocketMQ配置类
 */
@Configuration
public class RocketMQConfig {
    
    public static final String TOPIC = "seckill-topic";
    public static final String TAG = "seckill-order";
    public static final String PRODUCER_GROUP = "seckill-producer-group";
    public static final String CONSUMER_GROUP = "seckill-consumer-group";
    
    @Value("${spring.rocketmq.name-server}")
    private String nameServer;
    
    @Bean
    public RocketMQTemplate rocketMQTemplate() {
        RocketMQTemplate template = new RocketMQTemplate();
        DefaultMQProducer producer = new DefaultMQProducer(PRODUCER_GROUP);
        producer.setNamesrvAddr(nameServer);
        template.setProducer(producer);
        return template;
    }
}