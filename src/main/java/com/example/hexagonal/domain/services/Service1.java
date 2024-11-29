package com.example.hexagonal.domain.services;

import com.example.hexagonal.domain.models.FlowContext;
import com.example.hexagonal.domain.models.Input;
import com.example.hexagonal.domain.models.Output1;
import com.example.hexagonal.workflow.interfaces.FlowItem;
import org.springframework.stereotype.Service;

@Service
public class Service1 implements FlowItem<Input, FlowContext, Output1> {

    @Override
    public Output1 execute(Input input, FlowContext context) {
        context.setTexto("service1");
        return new Output1();
    }
}
