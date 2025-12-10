package com.portfolio.projects.service;

import com.portfolio.projects.dto.project.ProjectRequest;
import com.portfolio.projects.dto.project.ProjectResponse;
import com.portfolio.projects.dto.project.ProjectSummaryResponse;

import java.util.List;

public interface ProjectService {

    List<ProjectSummaryResponse> getUserProjects(Long userId);

    ProjectResponse getUserProjectById(Long id, Long userId);

    ProjectResponse createProject(ProjectRequest request, Long userId);

    ProjectResponse updateProject(Long id, ProjectRequest request, Long userId);

    void softDelete(Long id, Long userId);
}
