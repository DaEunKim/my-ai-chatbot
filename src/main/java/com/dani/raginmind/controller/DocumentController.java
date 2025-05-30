package com.dani.raginmind.controller;

import com.dani.raginmind.dto.req.QuestionRequest;
import com.dani.raginmind.service.RagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/documents")
public class DocumentController {

    private final RagService ragService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam MultipartFile file) throws IOException {
        // PDF → 텍스트 파싱 → Document 저장
        // 텍스트 chunk 나누기 → 임베딩 생성 (OpenAI API 호출)
        // EmbeddingChunk 저장
        return ResponseEntity.ok("업로드 및 임베딩 완료");
    }

    @PostMapping("/ask")
    public ResponseEntity<String> askQuestion(@RequestBody QuestionRequest request) {
        // 질문 → 유사한 Chunk 검색 → 프롬프트 생성 → GPT API 호출
        // 결과 저장 (QuestionLog) 후 응답 반환
        String gptAnswer = ragService.askQuestion(request);
        return ResponseEntity.ok("GPT 응답 결과");
    }

}
