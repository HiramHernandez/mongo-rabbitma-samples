package com.springframework.amqp.turorials.persisntence;

import java.io.Serializable;

public class MessageRequest implements Serializable {
    private static final  long serialVersionUID = -7997131870585713287L;

    private String message;

    public MessageRequest(){
        super();
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("MessageRequest [message=");
        builder.append(message);
        builder.append("]");
        return builder.toString();

    }
}
