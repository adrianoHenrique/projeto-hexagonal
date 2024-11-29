package com.example.hexagonal.domain.flows;

import com.example.hexagonal.domain.models.*;
import com.example.hexagonal.domain.services.Service1;
import com.example.hexagonal.domain.services.Service2;
import com.example.hexagonal.domain.services.Service3;
import com.example.hexagonal.workflow.FlowBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PingWorkflow {

    private final Service1 service1;
    private final Service2 service2;
    private final Service3 service3;

    public Output3 testeWorkflow(Input input, FlowContext flowContext) {
        return FlowBuilder.create(FlowContext.class)
                .withInput(input) // Define o input inicial
                .withContext(flowContext) // Define o contexto
                .step(service1)
                .step(service2)
                .step(service3)
                .builder(); // Executa o fluxo
    }
}
