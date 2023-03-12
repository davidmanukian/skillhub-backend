package org.skillhub.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.skillhub.model.Project;
import org.skillhub.model.ProjectEntity;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProjectMapper {

  Project toProject(ProjectEntity projectEntity);

  List<Project> toProjects(List<ProjectEntity> projectEntityList);

  ProjectEntity fromProject(Project project);
}
