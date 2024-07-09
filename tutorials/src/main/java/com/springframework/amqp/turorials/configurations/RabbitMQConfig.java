package com.springframework.amqp.turorials.configurations;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.support.RetryTemplate;

import com.springframework.amqp.turorials.persisntence.RabbitMQContants;

@Configuration
public class RabbitMQConfig {
    /** The Constant HOST. */
    private static final String HOST = "localhost";
    /** The Constant USER. */
    private static final String USER = "guest";
    /** The Constant PASSWORD. */
    private static final String PASSWORD = "guest";

    @Bean
    public Binding binding(){
        return  BindingBuilder.bind(queue()).to(exchange()).with(RabbitMQContants.ROUTING_KEY);
    }

    @Bean
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();

        connectionFactory.setHost(HOST);
        connectionFactory.setUsername(USER);
        connectionFactory.setPassword(PASSWORD);
        return connectionFactory;
    }
    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(RabbitMQContants.EXCHANGE);
    }
    @Bean
    public Queue queue() {
        return new Queue(RabbitMQContants.QUEUE, true);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        ExponentialBackOffPolicy policy = new ExponentialBackOffPolicy();

        policy.setInitialInterval(RabbitMQContants.INITIAL_INTERVAL);
        policy.setMaxInterval(RabbitMQContants.MAX_INTERVAL);
        policy.setMultiplier(RabbitMQContants.MULTIPLIER);

        RetryTemplate retryTemplate = new RetryTemplate();
        retryTemplate.setBackOffPolicy(policy);

        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setRetryTemplate(retryTemplate);

        return template;
    }

}
