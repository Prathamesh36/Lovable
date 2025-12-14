package com.portfolio.projects.service.impl;

import com.portfolio.projects.Repository.ProjectMemberRepository;
import com.portfolio.projects.Repository.ProjectRepository;
import com.portfolio.projects.Repository.UserRepository;
import com.portfolio.projects.dto.member.InviteMemberRequest;
import com.portfolio.projects.dto.member.MemberResponse;
import com.portfolio.projects.dto.member.UpdateMemberRoleRequest;
import com.portfolio.projects.entity.Project;
import com.portfolio.projects.entity.ProjectMember;
import com.portfolio.projects.entity.ProjectMemberId;
import com.portfolio.projects.entity.User;
import com.portfolio.projects.mapper.ProjectMemberMapper;
import com.portfolio.projects.service.ProjectMemberService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Transactional
public class ProjectMemberServiceImpl implements ProjectMemberService {

    ProjectMemberRepository projectMemberRepository;
    ProjectRepository projectRepository;
    ProjectMemberMapper projectMemberMapper;
    private final UserRepository userRepository;

    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);

        List<MemberResponse> memberResponseList = new ArrayList<>();
        memberResponseList.add(projectMemberMapper.toProjectMemberResponseFromOwner(project.getOwner()));

        memberResponseList.addAll(
            projectMemberRepository.findByIdProjectId(projectId)
                    .stream()
                    .map(projectMemberMapper::toProjectMemberResponseFromMember)
                    .toList()
        );


        return memberResponseList;
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {

        Project project = getAccessibleProjectById(projectId, userId);

        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("Not Allowed");
        }

        User invitee = userRepository.findByEmail(request.email()).orElseThrow();

        if(invitee.getId().equals(userId)){
            throw new RuntimeException("Cannot invite yourself");
        }
        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, invitee.getId());

        if(projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("Cannot invite once again");
        }

        ProjectMember member = ProjectMember.builder()
                .id(projectMemberId)
                .project(project)
                .user(invitee)
                .projectRole(request.role())
                .invitedAt(Instant.now())
                .build();

        projectMemberRepository.save(member);
        return projectMemberMapper.toProjectMemberResponseFromMember(member);
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId) {

        Project project = getAccessibleProjectById(projectId, userId);

        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("Not Allowed");
        }

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
        ProjectMember projectMember = projectMemberRepository.findById(projectMemberId).orElseThrow();

        projectMember.setProjectRole(request.role());

        projectMemberRepository.save(projectMember);
        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public void removeProjectMember(Long projectId, Long memberId, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);

        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("Not Allowed");
        }

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);

        if(!projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("Member not found in project");
        }
        projectMemberRepository.deleteById(projectMemberId);
    }

    //Internal functions
    public Project getAccessibleProjectById(Long projectId, Long userId){
        return projectRepository.findAccessibleProjectById(projectId, userId).orElseThrow();
    }

}
