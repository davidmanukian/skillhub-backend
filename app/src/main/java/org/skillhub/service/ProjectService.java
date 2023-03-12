package org.skillhub.service;

import lombok.RequiredArgsConstructor;
import org.skillhub.mapper.ProjectMapper;
import org.skillhub.model.Project;
import org.skillhub.model.ProjectEntity;
import org.skillhub.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

  private final ProjectRepository projectRepository;
  private final ProjectMapper projectMapper;

  public List<Project> getAllProjects() {
    return projectMapper.toProjects(projectRepository.findAll());
  }

  public Project saveProject(Project project) {
    ProjectEntity projectEntity = projectMapper.fromProject(project);
    ProjectEntity savedProject = projectRepository.save(projectEntity);
    return projectMapper.toProject(savedProject);
  }
}
