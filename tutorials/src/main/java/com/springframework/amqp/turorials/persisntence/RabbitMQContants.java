package com.springframework.amqp.turorials.persisntence;

public final class RabbitMQContants {
    /** The Constant QUEUE. */
    public static final String QUEUE = "test.queue";

    /** The Constant EXCHANGE. */
    public static final String EXCHANGE = "amq.direct";

    /** The Constant ROUTING_KEY. */
    public static final String ROUTING_KEY = "routing.key.test.queue";

    /** The Constant INITIAL_INTERVAL. */
    public static final Integer INITIAL_INTERVAL = 500;

    /** The Constant MAX_INTERVAL. */
    public static final Integer MAX_INTERVAL = 10000;

    /** The Constant MULTIPLIER. */
    public static final Integer MULTIPLIER = 10;

    /**
     * Instantiates a new rabbit mq constants.
     */
    private RabbitMQContants() {
        super();
    }

}
