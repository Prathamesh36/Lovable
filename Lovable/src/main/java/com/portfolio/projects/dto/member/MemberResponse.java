package com.portfolio.projects.dto.member;

import com.portfolio.projects.enums.ProjectRole;

import java.time.Instant;

public record MemberResponse(
        Long userId,
        String email,
        String name,
        //String avatarUrl,
        ProjectRole projectRole,
        Instant invitedAt
) {
}
