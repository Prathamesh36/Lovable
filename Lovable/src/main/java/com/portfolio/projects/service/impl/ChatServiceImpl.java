package com.portfolio.projects.service.impl;

import com.portfolio.projects.Repository.ChatMessageRepository;
import com.portfolio.projects.Repository.ChatSessionRepository;
import com.portfolio.projects.dto.chat.ChatResponse;
import com.portfolio.projects.entity.ChatMessage;
import com.portfolio.projects.entity.ChatSession;
import com.portfolio.projects.entity.ChatSessionId;
import com.portfolio.projects.mapper.ChatMapper;
import com.portfolio.projects.security.AuthUtil;
import com.portfolio.projects.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatServiceImpl implements ChatService {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatSessionRepository chatSessionRepository;
    private final AuthUtil authUtil;
    private final ChatMapper chatMapper;

    @Override
    public List<ChatResponse> getProjectChatHistory(Long projectId) {
        Long userId = authUtil.getCurrentUserId();

        ChatSession chatSession = chatSessionRepository.getReferenceById(
                new ChatSessionId(projectId, userId)
        );

        List<ChatMessage> chatMessageList = chatMessageRepository.findByChatSession(chatSession);

        return chatMapper.fromListOfChatMessage(chatMessageList);
    }
}
