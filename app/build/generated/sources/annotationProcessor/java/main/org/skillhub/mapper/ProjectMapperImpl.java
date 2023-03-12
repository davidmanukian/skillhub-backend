package org.skillhub.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.skillhub.model.Project;
import org.skillhub.model.ProjectEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-10T22:44:08+0400",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public Project toProject(ProjectEntity projectEntity) {
        if ( projectEntity == null ) {
            return null;
        }

        Project.ProjectBuilder project = Project.builder();

        project.id( projectEntity.getId() );
        project.name( projectEntity.getName() );
        List<String> list = projectEntity.getSkills();
        if ( list != null ) {
            project.skills( new ArrayList<String>( list ) );
        }

        return project.build();
    }

    @Override
    public List<Project> toProjects(List<ProjectEntity> projectEntityList) {
        if ( projectEntityList == null ) {
            return null;
        }

        List<Project> list = new ArrayList<Project>( projectEntityList.size() );
        for ( ProjectEntity projectEntity : projectEntityList ) {
            list.add( toProject( projectEntity ) );
        }

        return list;
    }

    @Override
    public ProjectEntity fromProject(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectEntity.ProjectEntityBuilder projectEntity = ProjectEntity.builder();

        projectEntity.id( project.getId() );
        projectEntity.name( project.getName() );
        List<String> list = project.getSkills();
        if ( list != null ) {
            projectEntity.skills( new ArrayList<String>( list ) );
        }

        return projectEntity.build();
    }
}
