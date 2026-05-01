package com.portfolio.project.workspace_service.dto.member;

import com.portfolio.project.common_lib.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(
        @NotNull ProjectRole role) {
}
