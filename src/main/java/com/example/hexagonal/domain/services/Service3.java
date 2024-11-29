package com.example.hexagonal.domain.services;

import com.example.hexagonal.domain.models.FlowContext;
import com.example.hexagonal.domain.models.Output2;
import com.example.hexagonal.domain.models.Output3;
import com.example.hexagonal.workflow.interfaces.FlowItem;
import org.springframework.stereotype.Service;

@Service
public class Service3 implements FlowItem<Output2, FlowContext, Output3> {

    @Override
    public Output3 execute(Output2 input, FlowContext context) {
        context.setTexto(context.getTexto().concat("service3"));
        return new Output3(context.toString());
    }
}
