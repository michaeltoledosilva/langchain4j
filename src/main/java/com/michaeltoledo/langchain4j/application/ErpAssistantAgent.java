package com.michaeltoledo.langchain4j.application;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.TokenStream;

public interface ErpAssistantAgent {

    @SystemMessage("""
        Você é um assistente especialista em ERP corporativo.
        Responda somente com base no contexto fornecido.
        Nunca invente regras.
    """)
    String chat(@UserMessage String message);

    // 🔥 MÉTODO DE STREAMING
    @SystemMessage("""
        Você é um assistente especialista em ERP corporativo.
        Responda somente com base no contexto fornecido.
        Nunca invente regras.
    """)
    TokenStream chatStream(@UserMessage String message);
}
