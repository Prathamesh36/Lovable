package com.portfolio.projects.service.impl;

import com.portfolio.projects.Repository.ProjectRepository;
import com.portfolio.projects.Repository.UserRepository;
import com.portfolio.projects.dto.project.ProjectRequest;
import com.portfolio.projects.dto.project.ProjectResponse;
import com.portfolio.projects.dto.project.ProjectSummaryResponse;
import com.portfolio.projects.entity.Project;
import com.portfolio.projects.entity.User;
import com.portfolio.projects.mapper.ProjectMapper;
import com.portfolio.projects.service.ProjectService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Transactional
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;

    UserRepository userRepository;

    ProjectMapper projectMapper;

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {

        User owner = userRepository.findById(userId).orElseThrow();

        Project project = Project.builder()
                .name(request.name())
                .owner(owner)
                .isPublic(false)
                .build();

        project = projectRepository.save(project);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {
//        return projectRepository.findAllAccessibleByUser(userId)
//                .stream()
//                .map(project -> projectMapper.toProjectSummaryResponse(project))
//                .collect(Collectors.toList());

        var projects = projectRepository.findAllAccessibleByUser(userId);
        return projectMapper.toListOfProjectSummaryResponse(projects);
    }

    @Override
    public ProjectResponse getUserProjectById(Long id, Long userId) {
        Project project = getAccessibleProjectById(id, userId);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {
        Project project = getAccessibleProjectById(id, userId);

        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("you are not allow to update");
        }

        project.setName(request.name());

        project = projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public void softDelete(Long id, Long userId) {
        Project project = getAccessibleProjectById(id, userId);

        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("you are not allow to delete");
        }

        project.setDeletedAt(Instant.now());

        projectRepository.save(project);
    }

    //Internal functions
    public Project getAccessibleProjectById(Long projectId, Long userId){
        return projectRepository.findAccessibleProjectById(projectId, userId).orElseThrow();
    }
}
