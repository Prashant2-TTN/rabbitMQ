package com.example.rabbitmq.consumer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomMessage {
    private String messageId;
    private LocalDateTime messageTime;
    private String message;
}
