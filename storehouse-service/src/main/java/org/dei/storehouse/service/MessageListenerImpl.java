package org.dei.storehouse.service;

import org.dei.messages.UnreservedMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageListenerImpl implements MessageListener {
    private final ProductServiceImpl productService;

    @Autowired
    public MessageListenerImpl(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @Override
    @RabbitListener(queues = "unreservedQueue")
    public void recieveMessages(UnreservedMessage unreservedMessage) {
        productService.unreserve(unreservedMessage.getId(), unreservedMessage.getCount());
    }
}
