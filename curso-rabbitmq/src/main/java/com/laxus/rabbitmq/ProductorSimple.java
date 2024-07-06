package com.laxus.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeoutException;

public class ProductorSimple {
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        String message = "Hola a todos mensaje enviado: " + LocalDateTime.now().toString() + "!";
        System.out.println("Nuevo código");
        // Abrir conexión AMQ y establecer canal
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel()){
            String queueName = "primera-cola";
            // Crear cola
            channel.queueDeclare(queueName, false, false, false, null);
            // Enviar mensaje al exhcange = ""
            channel.basicPublish("", queueName, null, message.getBytes());
        }
        /*try {
            Connection connection = connectionFactory.newConnection();

            Channel channel = connection.createChannel();
            // Crear cola
            channel.queueDeclare("primera-cola", false, false, false, null);
            // Enviar mensaje al exhcange = ""
            channel.basicPublish("", "primera-cola", null, message.getBytes());
        } finally {

        }*/
    }
}
