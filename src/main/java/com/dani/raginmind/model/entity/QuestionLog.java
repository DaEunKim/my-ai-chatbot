package com.dani.raginmind.model.entity;

import com.dani.raginmind.model.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(schema = "ai_chat", name = "question_log")
public class QuestionLog extends BaseEntity {
    private String question;

    @Column(columnDefinition = "text")
    private String answer;
}
