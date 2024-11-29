package com.example.hexagonal.domain.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class FlowContext {
    private Input input;
    private String texto;
}
