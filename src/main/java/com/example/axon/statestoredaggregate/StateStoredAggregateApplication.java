package com.example.axon.statestoredaggregate;

import com.example.axon.statestoredaggregate.coreapi.commands.CreateChildEntityCommand;
import com.example.axon.statestoredaggregate.coreapi.commands.CreateParentCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.UUID;

@SpringBootApplication
public class StateStoredAggregateApplication {

    public static void main(String[] args) {
        ApplicationContext appContext = SpringApplication.run(StateStoredAggregateApplication.class, args);

        CommandGateway commandGateway = appContext.getBean(CommandGateway.class);

        String parentId = UUID.randomUUID().toString();
        commandGateway.sendAndWait(new CreateParentCommand(parentId));
        commandGateway.sendAndWait(new CreateChildEntityCommand(parentId, UUID.randomUUID().toString()));
        commandGateway.sendAndWait(new CreateChildEntityCommand(parentId, UUID.randomUUID().toString()));
    }
}
