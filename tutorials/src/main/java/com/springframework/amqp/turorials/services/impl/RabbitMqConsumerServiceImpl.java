package com.springframework.amqp.turorials.services.impl;

import java.util.concurrent.ExecutorService;

import com.springframework.amqp.turorials.persisntence.RabbitMQContants;
import com.springframework.amqp.turorials.services.RabbitMqConsumerService;
import com.springframework.amqp.turorials.uitls.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqConsumerServiceImpl implements RabbitMqConsumerService {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqConsumerServiceImpl.class);

    /** The executor service. */
    @Autowired
    @Qualifier("fixedThreadPoolConsumer")
    private ExecutorService executorService;

    /*
     * (non-Javadoc)
     *
     * @see
     * com.rabbit.app.servicios.RabbitConsumerService#listener(java.lang.String)
     */
    @Override
    @RabbitListener(queues = RabbitMQContants.QUEUE)
    public void consumer(String message) {
        if (Utils.isNullOrEmpty(message)) {

            LOGGER.info("Message is Null Or Empty: {}", message);

        } else {
            executorService.execute(() -> {

                try {
                    LOGGER.info("Consumer received: {}", message);
                } catch (Exception e) {
                    LOGGER.error("Error:", e);
                }

            });
        }

    }


}
