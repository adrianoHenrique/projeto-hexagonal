package com.example.hexagonal.domain.services;

import com.example.hexagonal.domain.models.FlowContext;
import com.example.hexagonal.domain.models.Output1;
import com.example.hexagonal.domain.models.Output2;
import com.example.hexagonal.workflow.interfaces.FlowItem;
import org.springframework.stereotype.Service;

@Service
public class Service2 implements FlowItem<Output1, FlowContext, Output2> {

    @Override
    public Output2 execute(Output1 input, FlowContext context) {
        context.setTexto(context.getTexto().concat("service2"));
        return new Output2();
    }
}
