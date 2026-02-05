package com.michaeltoledo.langchain4j.infrastructure.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class AiCacheService {

    private final Cache<String, String> responseCache =
            Caffeine.newBuilder()
                    .expireAfterWrite(30, TimeUnit.MINUTES)
                    .maximumSize(10_000)
                    .build();

    private final Cache<String, float[]> embeddingCache =
            Caffeine.newBuilder()
                    .expireAfterWrite(1, TimeUnit.HOURS)
                    .maximumSize(20_000)
                    .build();

    public String getResponse(String key) { return responseCache.getIfPresent(key); }
    public void putResponse(String key, String value) { responseCache.put(key, value); }

    public float[] getEmbedding(String key) { return embeddingCache.getIfPresent(key); }
    public void putEmbedding(String key, float[] value) { embeddingCache.put(key, value); }
}
