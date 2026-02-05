package com.michaeltoledo.langchain4j.domain.repository;

import com.michaeltoledo.langchain4j.domain.model.ErpFunctionality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FunctionalityRepository extends JpaRepository<ErpFunctionality, Integer> {
    Optional<ErpFunctionality> findByCodeAndSystem_Code(String code, String systemCode);

}

