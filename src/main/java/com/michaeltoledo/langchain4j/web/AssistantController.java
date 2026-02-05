package com.michaeltoledo.langchain4j.web;

import com.michaeltoledo.langchain4j.application.AssistantOrchestrator;
import com.michaeltoledo.langchain4j.dto.AskRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/api/assistant")
@RequiredArgsConstructor
public class AssistantController {

    private final AssistantOrchestrator orchestrator;

    @PostMapping
    public String ask(@RequestBody AskRequest request) throws Exception {
        return orchestrator.ask(
                request.systemCode(),
                request.functionalityCode(),
                request.question()
        );
    }

    @PostMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter askStream(@RequestBody AskRequest request) {

        SseEmitter emitter = new SseEmitter();

        new Thread(() -> orchestrator.askStream(
                request.systemCode(),
                request.functionalityCode(),
                request.question(),
                emitter
        )).start();

        return emitter;
    }
}

