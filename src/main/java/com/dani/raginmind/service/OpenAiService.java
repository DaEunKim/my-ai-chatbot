package com.dani.raginmind.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OpenAiService {
    @Value("${openai.api-key}")
    private String apiKey;

    @Value("${openai.model:gpt-3.5-turbo}")
    private String model;

    private final WebClient webClient = WebClient.builder()
            .baseUrl("https://api.openai.com/v1/chat/completions")
            .defaultHeader("Authorization", "Bearer " + System.getenv().getOrDefault("OPENAI_API_KEY", ""))
            .defaultHeader("Content-Type", "application/json")
            .build();

    public String ask(String prompt) {
        Map<String, Object> request = new HashMap<>();
        request.put("model", model);

        List<Map<String, String>> messages = List.of(
                Map.of("role", "system", "content", "당신은 문서 기반 질문에 답변하는 AI 비서입니다."),
                Map.of("role", "user", "content", prompt)
        );

        request.put("messages", messages);

        return webClient.post()
                .bodyValue(request)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> {
                    List<Map<String, Object>> choices = (List<Map<String, Object>>) response.get("choices");
                    if (choices != null && !choices.isEmpty()) {
                        Map<String, Object> message = (Map<String, Object>) choices.get(0).get("message");
                        return (String) message.get("content");
                    }
                    return "답변을 생성하지 못했습니다.";
                })
                .block();
    }


}
