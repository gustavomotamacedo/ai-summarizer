package com.gustavomotamacedo.ai_summarizer.infrastructure.adapter;

import com.gustavomotamacedo.ai_summarizer.application.port.AIService;
import com.gustavomotamacedo.ai_summarizer.domain.model.AIRequest;
import com.gustavomotamacedo.ai_summarizer.domain.model.AIResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;

public class OpenAIApiAdapter implements AIService {

    private final WebClient webClient;
    @Value("${openai.url}")
    private String url;
    @Value("${openai.api-key}")
    private String apiKey;

    public OpenAIApiAdapter() {
        this.webClient = WebClient.builder()
                .baseUrl(getUrl())
                .defaultHeader("Authorization", "Bearer " + getApiKey())
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    @Override
    public AIResponse chat(AIRequest request) {
        // Ajuste conforme o payload e retorno esperado pela OpenAI
        return webClient.post()
                .uri("/chat/completions")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(AIResponse.class)
                .block(); // Use block() apenas se for código síncrono, senão retorne Mono/Flux
    }

    // Getters
    public String getUrl() {
        return url;
    }

    public String getApiKey() {
        return apiKey;
    }
}
