package com.springframework.amqp.turorials.services;

public interface RabbitMqConsumerService {
    void consumer(String message);
}
