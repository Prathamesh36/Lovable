package com.portfolio.projects.entity;

import com.portfolio.projects.enums.MessageRole;

import java.time.Instant;

public class ChatMessage {

    Long id;

    ChatSession chatSession;

    String content;

    MessageRole role;

    String toolCalls;

    Integer tokenUsed;

    Instant createdAt;

}
