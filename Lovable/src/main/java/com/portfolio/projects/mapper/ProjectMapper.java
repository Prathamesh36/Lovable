package com.portfolio.projects.mapper;

import com.portfolio.projects.dto.project.ProjectResponse;
import com.portfolio.projects.dto.project.ProjectSummaryResponse;
import com.portfolio.projects.entity.Project;
import com.portfolio.projects.enums.ProjectRole;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);

    ProjectSummaryResponse toProjectSummaryResponse(Project project, ProjectRole role);

    List<ProjectSummaryResponse> toListOfProjectSummaryResponse(List<Project> projects);

}
