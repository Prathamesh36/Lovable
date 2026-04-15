package com.portfolio.projects.Repository;

import com.portfolio.projects.entity.ChatSession;
import com.portfolio.projects.entity.ChatSessionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatSessionRepository extends JpaRepository<ChatSession, ChatSessionId> {
}
