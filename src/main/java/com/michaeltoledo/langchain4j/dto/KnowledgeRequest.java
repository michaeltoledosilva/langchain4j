package com.michaeltoledo.langchain4j.dto;

public record KnowledgeRequest(
        String systemCode,
        String functionalityCode,
        String content
) {}
