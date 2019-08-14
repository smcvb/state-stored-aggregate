package com.example.axon.statestoredaggregate.coreapi.events;

import java.util.Objects;

public class ParentCreatedEvent {

    private final String parentId;

    public ParentCreatedEvent(String parentId) {
        this.parentId = parentId;
    }

    public String getParentId() {
        return parentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(parentId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final ParentCreatedEvent other = (ParentCreatedEvent) obj;
        return Objects.equals(this.parentId, other.parentId);
    }
}
