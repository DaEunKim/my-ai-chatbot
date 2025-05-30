package com.dani.raginmind.dto.res;

import lombok.Data;

import java.util.List;

@Data
public class QuestionResponse {
    private String answer;
    private List<String> relatedChunks;
}
