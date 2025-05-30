package com.dani.raginmind.controller;

import com.dani.raginmind.dto.req.QuestionRequest;
import com.dani.raginmind.service.RagService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "문서 업로드 및 임베딩 생성")
    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam MultipartFile file) throws IOException {
        return ResponseEntity.ok("업로드 및 임베딩 완료");
    }

    @Operation(summary = "GPT에게 질문 요청")
    @PostMapping("/ask")
    public ResponseEntity<String> askQuestion(@RequestBody QuestionRequest request) {
        String gptAnswer = ragService.askQuestion(request);
        return ResponseEntity.ok(gptAnswer);
    }
}
