package com.portfolio.projects.dto.chat;

import com.portfolio.projects.entity.ChatEvent;
import com.portfolio.projects.entity.ChatSession;
import com.portfolio.projects.enums.MessageRole;

import java.time.Instant;
import java.util.List;

public record ChatResponse(
        Long id,
        MessageRole role,
        List<ChatEventResponse> events,
        String content,
        Integer tokensUsed,
        Instant createdAt

) {
}
