package io.riyanat.orderapi.messaging.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class RedisSubscriber implements MessageListener {
    private static final Logger LOG = LoggerFactory.getLogger(RedisSubscriber.class);

    @Override
    public void onMessage(Message message, byte[] pattern) {
        LOG.info("received message: {} from channel:{}", new String(message.getBody()),
                new String(message.getChannel()));
    }
}
