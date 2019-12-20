package org.dei.order.service;

import org.dei.messages.UnreservedMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderImpl implements MessageSender {

    private final RabbitTemplate rabbitTemplate;

    public MessageSenderImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendMessage(Long id, Long count) {
        final UnreservedMessage message = new UnreservedMessage(id, count);
        rabbitTemplate.convertAndSend("unreservedQueue", message);
    }
}
