package com.portfolio.projects.dto.member;

import com.portfolio.projects.enums.ProjectRole;

public record InviteMemberRequest(
        String email,
        ProjectRole role
) {
}
