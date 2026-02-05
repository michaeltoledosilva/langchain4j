package com.michaeltoledo.langchain4j.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "knowledge_base")
@Getter @Setter
public class KnowledgeBase {

    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "system_id")
    private ErpSystem system;

    @ManyToOne
    @JoinColumn(name = "functionality_id")
    private ErpFunctionality functionality;

    private String content;

    @Column(columnDefinition = "vector(1536)")
    private float[] embedding;
}
