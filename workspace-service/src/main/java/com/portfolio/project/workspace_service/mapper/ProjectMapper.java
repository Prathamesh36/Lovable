package com.portfolio.project.workspace_service.mapper;

import com.portfolio.project.common_lib.enums.ProjectRole;
import com.portfolio.project.workspace_service.dto.project.ProjectResponse;
import com.portfolio.project.workspace_service.dto.project.ProjectSummaryResponse;
import com.portfolio.project.workspace_service.entity.Project;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);

    ProjectSummaryResponse toProjectSummaryResponse(Project project, ProjectRole role);

    List<ProjectSummaryResponse> toListOfProjectSummaryResponse(List<Project> projects);

}
