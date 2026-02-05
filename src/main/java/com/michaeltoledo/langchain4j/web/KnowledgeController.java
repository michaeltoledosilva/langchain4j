package com.michaeltoledo.langchain4j.web;

import com.michaeltoledo.langchain4j.dto.KnowledgeRequest;
import com.michaeltoledo.langchain4j.rag.KnowledgeIngestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/knowledge")
@RequiredArgsConstructor
public class KnowledgeController {

    private final KnowledgeIngestionService ingestionService;

    @PostMapping
    public String add(@RequestBody KnowledgeRequest request) {

        ingestionService.ingest(
                request.systemCode(),
                request.functionalityCode(),
                request.content()
        );

        return "Conhecimento adicionado!";
    }
}
