package com.dani.raginmind.service;

import com.dani.raginmind.dto.req.QuestionRequest;
import com.dani.raginmind.model.entity.Document;
import com.dani.raginmind.model.entity.QuestionLog;
import com.dani.raginmind.repository.DocumentRepository;
import com.dani.raginmind.repository.QuestionLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RagService {
    private final OpenAiService openAiService;
    private final QuestionLogRepository logRepository;
    private final DocumentRepository documentRepository;


//    public String askQuestion(QuestionRequest request) {
//        // TODO: 유사한 EmbeddingChunk 검색 (벡터 유사도 기반)
//        // TODO: 프롬프트 구성
//        // TODO: OpenAI API 호출
//        // TODO: QuestionLog 저장
//
//        // 예시 응답
//        return "질문에 대한 GPT 응답입니다 (임시).";
//    }

    @Transactional
    public String askQuestion(QuestionRequest request) {
        Document doc = documentRepository.findById(request.getDocumentId())
                .orElseThrow(() -> new IllegalArgumentException("해당 문서를 찾을 수 없습니다."));

//        List<EmbeddingChunk> chunks = chunkRepository.findTop5ByDocumentIdOrderByIdAsc(doc.getId());
        String context = null; //chunks.stream().map(EmbeddingChunk::getChunkText).collect(Collectors.joining("\n"));

        String prompt = "다음 문서를 참고하여 사용자의 질문에 답하십시오.\n\n" +
                "문서 내용:\n" + context + "\n\n질문: " + request.getQuestion() + "\n답변:";

//        String answer = openAiService.ask(prompt);
//
        QuestionLog log = new QuestionLog();
        log.setQuestion(request.getQuestion());
        log.setAnswer(doc.getContent());
        logRepository.save(log);

        return doc.getContent();
    }
}
