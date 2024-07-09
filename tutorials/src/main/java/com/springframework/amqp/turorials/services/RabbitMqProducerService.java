package com.springframework.amqp.turorials.services;

public interface RabbitMqProducerService {
    public void sendMessage(String queue, String message);
}
