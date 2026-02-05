package com.michaeltoledo.langchain4j.dto;

public record AskRequest(
        String systemCode,
        String functionalityCode,
        String question
) {}
