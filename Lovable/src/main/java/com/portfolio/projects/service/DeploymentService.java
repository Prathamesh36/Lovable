package com.portfolio.projects.service;

import com.portfolio.projects.dto.deploy.DeployResponse;

public interface DeploymentService {

    DeployResponse deploy(Long projectId);
}
