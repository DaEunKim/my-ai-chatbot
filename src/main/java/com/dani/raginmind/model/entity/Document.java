package com.dani.raginmind.model.entity;

import com.dani.raginmind.model.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(schema = "ai_chat", name = "document")
public class Document extends BaseEntity {
    private String name;
    private String type;
    @Column(columnDefinition = "text")
    private String content;
}
