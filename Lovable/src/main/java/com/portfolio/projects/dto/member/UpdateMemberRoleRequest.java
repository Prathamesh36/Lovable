package com.portfolio.projects.dto.member;

import com.portfolio.projects.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(
        @NotNull
        ProjectRole role
) {
}
