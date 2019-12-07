package org.dei.messages;

import lombok.Data;

import java.io.Serializable;

@Data
public final class UnreservedMessage implements Serializable {
    private final Long id;
    private final Long count;
}
