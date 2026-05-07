package com.portfolio.project.workspace_service.service;

import com.portfolio.project.workspace_service.dto.project.DeployResponse;
import org.jspecify.annotations.Nullable;

public interface DeploymentService {
    @Nullable
    DeployResponse deploy(Long projectId);
}
