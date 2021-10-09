package wang.seamas.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Slf4j
@Component
public class MessageSubscriber {

    public MessageSubscriber(RedisTemplate redisTemplate) {
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        connection.subscribe(new MessageListener() {
            @Override
            public void onMessage(Message message, byte[] bytes) {
                log.info("receive message: {}", message);
            }
        }, "MV".getBytes(StandardCharsets.UTF_8));
    }
}
