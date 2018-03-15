package com.rabbitmq.commandliner;

import com.rabbitmq.message.SimpleMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLiner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public CommandLiner(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
//        rabbitTemplate.convertAndSend("Hello from our first message!");
        SimpleMessage simpleMessage = new SimpleMessage();
        simpleMessage.setName("FirstName");
        simpleMessage.setDescription("simpleDescription");
        rabbitTemplate.convertAndSend("MyTopicExchange", "topic", simpleMessage);
    }
}
