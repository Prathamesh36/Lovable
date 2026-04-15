package com.portfolio.projects.mapper;

import com.portfolio.projects.dto.chat.ChatResponse;
import com.portfolio.projects.entity.ChatMessage;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChatMapper {

    List<ChatResponse> fromListOfChatMessage(List<ChatMessage> chatMessageList);
}
