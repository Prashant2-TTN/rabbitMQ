package com.example.rabbitmq.consumer;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    public static final String messageQueue = "message_queue";
    public static final String topicExchange = "topic_exchange";
    public static final String messageRoutingKey = "message_routing_key";

    @Bean
    public Queue queue(){
        return new Queue(messageQueue);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(topicExchange);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(messageRoutingKey);
    }

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate=new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;

    }


}
