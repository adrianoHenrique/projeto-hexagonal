package com.example.hexagonal.workflow.interfaces;

public interface FlowItem <I, C, O> {
    O execute(I input, C context);
}