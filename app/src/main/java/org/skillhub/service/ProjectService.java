package org.skillhub.service;

import lombok.RequiredArgsConstructor;
import org.skillhub.mapper.ProjectMapper;
import org.skillhub.model.Profile;
import org.skillhub.model.Project;
import org.skillhub.model.ProjectEntity;
import org.skillhub.model.Skill;
import org.skillhub.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {

  private final ProjectRepository projectRepository;
  private final ProjectMapper projectMapper;
  private final ProfileService profileService;

  public List<Project> getAllProjects() {
    return projectMapper.toProjects(projectRepository.findAll());
  }

  public Project saveProject(Project project) {
    ProjectEntity projectEntity = projectMapper.fromProject(project);
    ProjectEntity savedProject = projectRepository.save(projectEntity);
    return projectMapper.toProject(savedProject);
  }

  public List<String> fetchAllSkills() {
    List<Profile> all = profileService.findAll();
    Set<String> skills = all.stream().flatMap(e -> e.getSkills()
        .stream().map(Skill::getName)).collect(Collectors.toSet());
    return skills.stream()
        .toList();
  }
}
