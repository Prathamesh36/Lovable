package com.portfolio.project.intelligence_service.repository;

import com.portfolio.project.intelligence_service.entity.ChatSession;
import com.portfolio.project.intelligence_service.entity.ChatSessionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatSessionRepository extends JpaRepository<ChatSession, ChatSessionId> {
}
