package com.springframework.amqp.turorials.services.impl;

import java.util.concurrent.ExecutorService;

import com.springframework.amqp.turorials.uitls.Utils;
import com.springframework.amqp.turorials.services.RabbitMqProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqProducerServiceImpl implements RabbitMqProducerService {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqProducerServiceImpl.class);

    /** The rabbit template. */
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /** The executor service. */
    @Autowired
    @Qualifier("fixedThreadPoolProducer")
    private ExecutorService executorService;

    /*
     * (non-Javadoc)
     *
     * @see com.rabbit.app.servicios.RabbitMqProducerService#sendMessage(java.lang.
     * String)
     */
    @Override
    public void sendMessage(String queue, String message) {

        if (Utils.isNullOrEmpty(message)) {

            LOGGER.info("Message is Null Or Empty: {}", message);

        } else {

            executorService.execute(() -> {

                try {
                    LOGGER.info("Producer message: {}", message);
                    rabbitTemplate.convertAndSend(queue, message);
                } catch (Exception e) {
                    LOGGER.error("Error:", e);
                }

            });
        }

    }


}
