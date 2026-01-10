package com.portfolio.projects.security;

import com.portfolio.projects.Repository.ProjectMemberRepository;
import com.portfolio.projects.enums.ProjectPermission;
import com.portfolio.projects.enums.ProjectRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("security")
@RequiredArgsConstructor
public class SecurityExpressions {

    private final ProjectMemberRepository projectMemberRepository;

    private final AuthUtil authUtil;

    private boolean hasPermission(Long projectId, ProjectPermission projectPermission){
        Long userId = authUtil.getCurrentUserId();
        return projectMemberRepository.findRolesByProjectIdAndUserId(projectId, userId)
                .map(role -> role.getPermission().contains(projectPermission))
                .orElse(false);
    }

    public boolean canViewProject(Long projectId) {
        // Implement logic to check if the current user can view the project with the given ID
        return hasPermission(projectId, ProjectPermission.VIEW);
    }

    public boolean canEditProject(Long projectId) {
        // Implement logic to check if the current user can edit the project with the given ID
        return hasPermission(projectId, ProjectPermission.EDIT);
    }

    public boolean canDeleteProject(Long projectId) {
        // Implement logic to check if the current user can edit the project with the given ID
        return hasPermission(projectId, ProjectPermission.DELETE  );
    }

    public boolean canViewMembers(Long projectId) {
        // Implement logic to check if the current user can view members of the project with the given ID
        return hasPermission(projectId, ProjectPermission.VIEW_MEMBERS);
    }

    public boolean canManageMembers(Long projectId) {
        // Implement logic to check if the current user can manage members of the project with the given ID
        return hasPermission(projectId, ProjectPermission.MANAGE_MEMBERS);
    }
}
