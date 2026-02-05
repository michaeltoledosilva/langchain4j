package com.michaeltoledo.langchain4j.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "erp_functionality")
@Getter @Setter
public class ErpFunctionality {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "system_id")
    private ErpSystem system;

    private String code;
    private String name;
}
