package com.example.axon.statestoredaggregate.commandmodel;

import org.axonframework.modelling.command.EntityId;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"childId"}))
public class ChildEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String generatedId;

    @EntityId
    private String childId;

    protected ChildEntity() {
    }

    public ChildEntity(String childId) {
        this.childId = childId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(generatedId, childId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final ChildEntity other = (ChildEntity) obj;
        return Objects.equals(this.generatedId, other.generatedId)
                && Objects.equals(this.childId, other.childId);
    }
}
