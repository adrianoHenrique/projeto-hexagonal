package com.example.hexagonal.workflow;

import com.example.hexagonal.workflow.interfaces.FlowItem;

import java.util.ArrayList;
import java.util.List;

public class FlowBuilder<C> {
    private final List<FlowItem<?, C, ?>> steps = new ArrayList<>();
    private Object initialInput; // Armazena o input inicial
    private C context; // Armazena o contexto

    // Criação do FlowBuilder com inferência de tipo
    public static <C> FlowBuilder<C> create(Class<C> contextType) {
        return new FlowBuilder<>();
    }

    // Adiciona um passo ao fluxo
    public <I, O> FlowBuilder<C> step(FlowItem<I, C, O> step) {
        steps.add(step);
        return this;
    }

    // Define o input inicial
    public <I> FlowBuilder<C> withInput(I input) {
        this.initialInput = input;
        return this;
    }

    // Define o contexto
    public FlowBuilder<C> withContext(C context) {
        this.context = context;
        return this;
    }

    // Executa o fluxo
    @SuppressWarnings("unchecked")
    public <O> O builder() {
        Object result = initialInput; // Usa o input inicial configurado

        for (FlowItem step : steps) {
            // Passa o resultado do passo anterior como input para o próximo
            result = step.execute(result, context);
        }

        // Retorna o resultado final
        return (O) result;
    }
}
