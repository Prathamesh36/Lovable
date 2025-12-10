package com.portfolio.projects.service;

import com.portfolio.projects.dto.project.FileContentResponse;
import com.portfolio.projects.dto.project.FileNode;

import java.util.List;

public interface FileService {
    List<FileNode> getFileTree(Long projectId, Long userId);

    FileContentResponse getFileContent(Long projectId, String path, Long userId);
}
