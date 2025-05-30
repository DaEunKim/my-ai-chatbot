package com.dani.raginmind.service;

import com.dani.raginmind.dto.req.QuestionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RagService {

    public String askQuestion(QuestionRequest request) {
        // TODO: 유사한 EmbeddingChunk 검색 (벡터 유사도 기반)
        // TODO: 프롬프트 구성
        // TODO: OpenAI API 호출
        // TODO: QuestionLog 저장

        // 예시 응답
        return "질문에 대한 GPT 응답입니다 (임시).";
    }
}
