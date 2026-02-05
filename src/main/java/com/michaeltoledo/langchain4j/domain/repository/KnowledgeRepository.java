package com.michaeltoledo.langchain4j.domain.repository;

import com.michaeltoledo.langchain4j.domain.model.KnowledgeBase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KnowledgeRepository extends JpaRepository<KnowledgeBase, UUID> {
}
