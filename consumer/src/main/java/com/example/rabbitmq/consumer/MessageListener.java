package com.example.rabbitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageListener {
    @RabbitListener(queues = MQConfig.messageQueue)
    public void listen(CustomMessage customMessage){
        log.info("message received is :{}",customMessage);
    }
}
