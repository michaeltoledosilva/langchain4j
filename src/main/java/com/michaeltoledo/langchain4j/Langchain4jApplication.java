package com.michaeltoledo.langchain4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Langchain4jApplication {

    public static void main(String[] args) {
        SpringApplication.run(Langchain4jApplication.class, args);
    }

}
