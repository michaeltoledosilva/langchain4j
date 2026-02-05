package com.michaeltoledo.langchain4j.domain.repository;

import com.michaeltoledo.langchain4j.domain.model.ErpSystem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SystemRepository extends JpaRepository<ErpSystem, Integer> {
    Optional<ErpSystem> findByCode(String code);
}