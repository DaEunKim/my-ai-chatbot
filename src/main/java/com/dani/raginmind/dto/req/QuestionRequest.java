package com.dani.raginmind.dto.req;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class QuestionRequest {
    @NotBlank(message = "질문 내용은 비어 있을 수 없습니다.")
    private String question;

    @NotNull(message = "문서 ID는 필수입니다.")
    private Long documentId;
}
