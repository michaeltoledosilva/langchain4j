package com.michaeltoledo.langchain4j.application;

import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.service.TokenStream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.StringJoiner;

@Service
@RequiredArgsConstructor
public class AssistantOrchestrator {

    private final ErpAssistantAgent assistantService;
    private final EmbeddingModel embeddingModel;
    private final DataSource dataSource;

    // ================= NORMAL =================
    public String ask(String systemCode, String funcCode, String question) throws Exception {

        String context = buildContext(systemCode, funcCode, question);

        String finalPrompt = """
            Você é um especialista em ERP corporativo.
            Responda usando o contexto abaixo.

            CONTEXTO:
            %s

            PERGUNTA:
            %s
            """.formatted(context, question);

        return assistantService.chat(finalPrompt);
    }

    // ================= STREAMING =================
    public void askStream(String systemCode, String funcCode, String question, SseEmitter emitter) {

        try {
            String context = buildContext(systemCode, funcCode, question);

            String finalPrompt = """
                Você é um especialista em ERP corporativo.
                Responda usando o contexto abaixo.

                CONTEXTO:
                %s

                PERGUNTA:
                %s
                """.formatted(context, question);

            TokenStream stream = assistantService.chatStream(finalPrompt);

            stream
                    .onNext(token -> {
                        try {
                            emitter.send(token);
                        } catch (Exception e) {
                            emitter.completeWithError(e);
                        }
                    })
                    .onComplete(r -> emitter.complete())
                    .onError(emitter::completeWithError)
                    .start();

        } catch (Exception e) {
            emitter.completeWithError(e);
        }
    }

    // ================= RAG =================
    private String buildContext(String systemCode, String funcCode, String question) throws Exception {

        float[] embedding = embeddingModel.embed(question).content().vector();

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < embedding.length; i++) {
            sb.append(embedding[i]);
            if (i < embedding.length - 1) sb.append(",");
        }
        sb.append("]");

        StringJoiner contextBuilder = new StringJoiner("\n");

        try (Connection conn = dataSource.getConnection()) {

            PreparedStatement ps = conn.prepareStatement("""
                SELECT kb.content
                FROM knowledge_base kb
                JOIN erp_system s ON kb.system_id = s.id
                JOIN erp_functionality f ON kb.functionality_id = f.id
                WHERE s.code = ? AND f.code = ?
                ORDER BY kb.embedding <-> CAST(? AS vector)
                LIMIT 3
            """);

            ps.setString(1, systemCode);
            ps.setString(2, funcCode);
            ps.setString(3, sb.toString());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                contextBuilder.add(rs.getString("content"));
            }
        }

        return contextBuilder.toString();
    }
}
