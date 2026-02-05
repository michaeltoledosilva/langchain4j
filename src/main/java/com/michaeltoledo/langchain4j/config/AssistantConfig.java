package com.michaeltoledo.langchain4j.config;

import com.michaeltoledo.langchain4j.application.ErpAssistantAgent;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.StreamingChatLanguageModel;
import dev.langchain4j.service.AiServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AssistantConfig {

    @Bean
    public ErpAssistantAgent assistant(ChatLanguageModel chatModel,
                                       StreamingChatLanguageModel streamingChatModel) {

        return AiServices.builder(ErpAssistantAgent.class)
                .chatLanguageModel(chatModel)
                .streamingChatLanguageModel(streamingChatModel)
                .build();
    }

}
