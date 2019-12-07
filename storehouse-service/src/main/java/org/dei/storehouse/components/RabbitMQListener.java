package org.dei.storehouse.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
@ComponentScan(basePackages = "org.dei.strorehouse.components")
public class RabbitMQListener {
    private final Logger LOGGER = LoggerFactory.getLogger(RabbitMQListener.class);

    @RabbitListener(queues = "unreservedQueue")
    public void processQueue(String message) {
        LOGGER.info("Received from unreserved queue " + message);
    }
}
