package org.dei.order.api.model;

import java.util.EnumSet;
import java.util.Set;

public enum Status {
    COLLECTING {
        @Override
        public Set<Status> possibleFollowUps() {
            return EnumSet.of(PAID, FAILED);
        }
    },
    PAID {
        @Override
        public Set<Status> possibleFollowUps() {
            return EnumSet.of(SHIPPING, CANCELLED);
        }
    },
    SHIPPING {
        @Override
        public Set<Status> possibleFollowUps() {
            return EnumSet.of(COMPLETE);
        }
    },
    COMPLETE,
    FAILED,
    CANCELLED;

    public Set<Status> possibleFollowUps() {
        return EnumSet.noneOf(Status.class);
    }
}