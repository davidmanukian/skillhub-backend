package org.skillhub.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.skillhub.api.ProjectApi;
import org.skillhub.model.Project;
import org.skillhub.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
public class ProjectController implements org.skillhub.api.ProjectApi {

  private final ProjectService projectService;

  @Override
  public ResponseEntity<Project> createNewProject(Principal principal, Project project) {
    Project createdProject = projectService.saveProject(project);
    return new ResponseEntity<>(createdProject, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<Project>> getAllProjects(Principal principal) {
    List<Project> allProjects = projectService.getAllProjects();
    return new ResponseEntity<>(allProjects, HttpStatus.OK);
  }
}
