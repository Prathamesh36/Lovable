package com.portfolio.projects.dto.member;

import com.portfolio.projects.enums.ProjectRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InviteMemberRequest(
        @Email
        @NotBlank
        String username,
        @NotNull
        ProjectRole role
) {
}
