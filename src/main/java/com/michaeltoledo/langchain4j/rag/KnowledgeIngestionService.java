package com.michaeltoledo.langchain4j.rag;

import com.michaeltoledo.langchain4j.domain.model.*;
import com.michaeltoledo.langchain4j.domain.repository.*;
import dev.langchain4j.model.embedding.EmbeddingModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class KnowledgeIngestionService {

    private final EmbeddingModel embeddingModel;
    private final KnowledgeRepository repo;
    private final SystemRepository systemRepo;
    private final FunctionalityRepository funcRepo;

    public void ingest(String systemCode, String funcCode, String content) {

        ErpSystem system = systemRepo.findByCode(systemCode)
                .orElseThrow(() -> new RuntimeException("Sistema não encontrado: " + systemCode));

        ErpFunctionality func = funcRepo.findByCodeAndSystem_Code(funcCode, systemCode)
                .orElseThrow(() -> new RuntimeException("Funcionalidade não encontrada: " + funcCode));

        float[] embedding = embeddingModel.embed(content).content().vector();

        KnowledgeBase kb = new KnowledgeBase();
        kb.setId(UUID.randomUUID());
        kb.setSystem(system);
        kb.setFunctionality(func);
        kb.setContent(content);
        kb.setEmbedding(embedding);

        repo.save(kb);
    }
}
