package com.example.rabbitmq.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
public class MessagePublisher {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @PostMapping("publishmessage")
    public String publishMessage(@RequestBody CustomMessage customMessage){
        customMessage.setMessageId(UUID.randomUUID().toString());
        customMessage.setMessageTime(LocalDateTime.now());
        rabbitTemplate.convertAndSend(MQConfig.topicExchange,MQConfig.messageRoutingKey,customMessage);
        return "message sent successfully";
    }
}
