package com.example.axon.statestoredaggregate.commandmodel;

import com.example.axon.statestoredaggregate.coreapi.commands.CreateChildEntityCommand;
import com.example.axon.statestoredaggregate.coreapi.commands.CreateParentCommand;
import com.example.axon.statestoredaggregate.coreapi.events.ChildEntityCreatedEvent;
import com.example.axon.statestoredaggregate.coreapi.events.ParentCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@Aggregate
public class ParentAggregate {

    @Id
    @AggregateIdentifier
    private String aggregateId;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "parentId")
    @AggregateMember
    private List<ChildEntity> childEntities = new ArrayList<>();

    public ParentAggregate() {
    }

    @CommandHandler
    public ParentAggregate(CreateParentCommand command) {
        aggregateId = command.getParentId();

        AggregateLifecycle.apply(new ParentCreatedEvent(command.getParentId()));
    }

    @CommandHandler
    public void handle(CreateChildEntityCommand command) {
        String childId = command.getChildId();
        childEntities.add(new ChildEntity(childId));

        AggregateLifecycle.apply(new ChildEntityCreatedEvent(aggregateId, childId));
    }
}
