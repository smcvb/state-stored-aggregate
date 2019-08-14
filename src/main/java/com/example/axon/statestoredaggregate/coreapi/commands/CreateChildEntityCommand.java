package com.example.axon.statestoredaggregate.coreapi.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Objects;

public class CreateChildEntityCommand {

    @TargetAggregateIdentifier
    private final String parentId;
    private final String childId;

    public CreateChildEntityCommand(String parentId, String childId) {
        this.parentId = parentId;
        this.childId = childId;
    }

    public String getParentId() {
        return parentId;
    }

    public String getChildId() {
        return childId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(parentId, childId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final CreateChildEntityCommand other = (CreateChildEntityCommand) obj;
        return Objects.equals(this.parentId, other.parentId)
                && Objects.equals(this.childId, other.childId);
    }
}
