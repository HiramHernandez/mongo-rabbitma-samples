package com.springframework.amqp.turorials.configurations;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExecutorServiceConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExecutorServiceConfig.class);

    /** The executors consumer */
    @Value("${executorsConsumer}")
    private Integer executorsConsumer;

    /** The executors producer. */
    @Value("${executorsProducer}")
    private Integer executorsProducer;

    /**
     * Fixed thread pool consumer.
     *
     * @return the executor service
     */
     @Bean("fixedThreadPoolConsumer")
     public ExecutorService fixedThreadPoolConsumer(){
         LOGGER.info("Excutors Consumer for mq's -> {}", executorsConsumer);
         // Se determinar el número de procesos disponibles para la máquina virtual
         // Java mediante el método de tiempo de ejecución estático, availableProcessors
         // . Una vez que haya determinado la cantidad de procesadores disponibles, cree
         // esa cantidad de subprocesos y divida su trabajo en consecuencia.
         return Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
     }

    @Bean("fixedThreadPoolProducer")
    public ExecutorService fixedThreadPoolProducer() {

        LOGGER.info("Excutors Consumer for mq's -> {}", executorsProducer);

        // Se determina el número de procesos disponibles para la máquina virtual Java
        // mediante el método de tiempo de ejecución estático, availableProcessors . Una
        // vez que haya determinado la cantidad de procesadores disponibles, cree esa
        // cantidad de subprocesos y divida su trabajo en consecuencia.
        return Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }


}
