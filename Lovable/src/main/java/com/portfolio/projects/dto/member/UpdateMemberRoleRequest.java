package com.portfolio.projects.dto.member;

import com.portfolio.projects.enums.ProjectRole;

public record UpdateMemberRoleRequest(
        ProjectRole role
) {
}
