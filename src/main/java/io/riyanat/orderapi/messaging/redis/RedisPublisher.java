package io.riyanat.orderapi.messaging.redis;

import io.riyanat.orderapi.messaging.MessagePublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;


public class RedisPublisher implements MessagePublisher {
    private static final Logger LOG = LoggerFactory.getLogger(RedisPublisher.class);

    private final RedisTemplate<String, Object> redisTemplate;
    private final ChannelTopic topic;

    public RedisPublisher(RedisTemplate<String, Object> redisTemplate, ChannelTopic topic) {
        this.redisTemplate = redisTemplate;
        this.topic = topic;
    }

    public void publish(String message) {
        LOG.info("publishing to channel:{} message:{} ", topic, message);
        redisTemplate.convertAndSend(topic.getTopic(), message);
        LOG.info("successfully published to channel:{} message: {}", topic, message);
    }

}
