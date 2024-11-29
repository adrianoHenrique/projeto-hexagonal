package com.example.hexagonal.adapters.inbound.apicontroller;

import com.example.hexagonal.domain.flows.PingWorkflow;
import com.example.hexagonal.domain.models.FlowContext;
import com.example.hexagonal.domain.models.Input;
import com.example.hexagonal.domain.models.Output3;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PingController {

    private PingWorkflow pingWorkflow;

    @GetMapping("/")
    private Output3 teste(@RequestParam String input) {

        var requestParam = new Input(input);

        var context = new FlowContext();
        context.setInput(requestParam);

        return pingWorkflow.testeWorkflow(requestParam, context);
    }

}
