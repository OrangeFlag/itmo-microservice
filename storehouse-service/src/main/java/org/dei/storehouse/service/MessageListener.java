package org.dei.storehouse.service;

import org.dei.messages.UnreservedMessage;

public interface MessageListener {
    void recieveMessages(final UnreservedMessage unreservedMessage);
}
