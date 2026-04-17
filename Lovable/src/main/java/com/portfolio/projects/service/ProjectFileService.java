package com.portfolio.projects.service;

import com.portfolio.projects.dto.project.FileContentResponse;
import com.portfolio.projects.dto.project.FileTreeResponse;

import java.util.List;

public interface ProjectFileService {
    FileTreeResponse getFileTree(Long projectId);

    FileContentResponse getFileContent(Long projectId, String path);

    void saveFile(Long projectId, String filePath, String fileContent);
}
