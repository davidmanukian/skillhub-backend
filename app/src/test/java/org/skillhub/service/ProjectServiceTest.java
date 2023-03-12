package org.skillhub.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skillhub.mapper.ProjectMapper;
import org.skillhub.mapper.ProjectMapperImpl;
import org.skillhub.model.Project;
import org.skillhub.model.ProjectEntity;
import org.skillhub.repository.ProjectRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProjectServiceTest {

  private ProjectService projectService;
  @Mock
  private ProjectRepository projectRepository;
  private ProjectMapper projectMapper;

  @BeforeEach
  public void setUp() {
    projectMapper = new ProjectMapperImpl();
    projectService = new ProjectService(projectRepository, projectMapper);
  }

  @Test
  public void testGetAllProjects() {
    when(projectRepository.findAll()).thenReturn(List.of(projectEntity()));
    List<Project> allProjects = projectService.getAllProjects();
    assertNotNull(allProjects);
    assertEquals(1, allProjects.size());
  }

  @Test
  public void testSaveProject(){
    when(projectRepository.save(any())).thenReturn(projectEntity());
    Project project = projectService.saveProject(project());
    assertNotNull(project);
    assertEquals("My Lovely Project", project.getName());
  }

  private ProjectEntity projectEntity() {
    List<String> skills = new ArrayList<>();
    skills.add("Java");

    ProjectEntity projectEntity = new ProjectEntity();
    projectEntity.setId(1);
    projectEntity.setName("My Lovely Project");
    projectEntity.setSkills(skills);
    return projectEntity;
  }

  private Project project() {
    List<String> skills = new ArrayList<>();
    skills.add("Java");

    Project project = new Project();
    project.setId(1);
    project.setName("My Lovely Project");
    project.setSkills(skills);
    return project;
  }
}
