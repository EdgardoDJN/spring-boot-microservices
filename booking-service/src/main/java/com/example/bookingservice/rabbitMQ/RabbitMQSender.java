package com.example.bookingservice.rabbitMQ;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RabbitMQSender {

    private final RabbitTemplate rabbitTemplate;

    private final Queue queue;

    public RabbitMQSender(RabbitTemplate rabbitTemplate, Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    public void send(UUID id) {
        rabbitTemplate.convertAndSend(queue.getName(), id.toString());
    }
}
