package com.springframework.amqp.turorials.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springframework.amqp.turorials.persisntence.RabbitMQContants;
import com.springframework.amqp.turorials.persisntence.MessageRequest;
import com.springframework.amqp.turorials.services.RabbitMqProducerService;

@RestController
@RequestMapping("api/v1/message")
public class MessageController {
    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

    /** The rabbit mq producer service. */
    @Autowired
    private RabbitMqProducerService rabbitMqProducerService;

    /**
     * Publish.
     *
     * @param request the request
     */
    @PostMapping("send")
    public void publish(@RequestBody MessageRequest request) {

        LOGGER.info("Producer: {}", request);

        rabbitMqProducerService.sendMessage(RabbitMQContants.QUEUE, request.getMessage());

    }

}
