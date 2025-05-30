package com.dani.raginmind.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "RAGinMind API", version = "v1", description = "문서 기반 GPT 질의응답 시스템")
)
public class SwaggerConfig {
}
