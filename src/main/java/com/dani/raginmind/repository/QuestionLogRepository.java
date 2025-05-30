package com.dani.raginmind.repository;

import com.dani.raginmind.model.entity.QuestionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionLogRepository extends JpaRepository<QuestionLog, Long> {
}
