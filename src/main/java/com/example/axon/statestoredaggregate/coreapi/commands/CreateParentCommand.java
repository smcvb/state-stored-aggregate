package com.example.axon.statestoredaggregate.coreapi.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Objects;

public class CreateParentCommand {

    @TargetAggregateIdentifier
    private final String parentId;

    public CreateParentCommand(String parentId) {
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
        final CreateParentCommand other = (CreateParentCommand) obj;
        return Objects.equals(this.parentId, other.parentId);
    }
}
