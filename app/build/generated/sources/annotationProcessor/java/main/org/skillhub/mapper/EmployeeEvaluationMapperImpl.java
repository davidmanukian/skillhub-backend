package org.skillhub.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.skillhub.model.EmployeeEvaluation;
import org.skillhub.model.EmployeeEvaluationEntity;
import org.skillhub.model.Skill;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-10T22:44:08+0400",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class EmployeeEvaluationMapperImpl implements EmployeeEvaluationMapper {

    @Override
    public EmployeeEvaluation toEmployeeEvaluation(EmployeeEvaluationEntity employeeEvaluationEntity) {
        if ( employeeEvaluationEntity == null ) {
            return null;
        }

        EmployeeEvaluation.EmployeeEvaluationBuilder employeeEvaluation = EmployeeEvaluation.builder();

        employeeEvaluation.assessmentId( employeeEvaluationEntity.getAssessmentId() );
        employeeEvaluation.usernameFor( employeeEvaluationEntity.getUsernameFor() );
        employeeEvaluation.usernameFrom( employeeEvaluationEntity.getUsernameFrom() );
        employeeEvaluation.usernameCreated( employeeEvaluationEntity.getUsernameCreated() );
        employeeEvaluation.status( employeeEvaluationEntity.getStatus() );
        employeeEvaluation.firstName( employeeEvaluationEntity.getFirstName() );
        employeeEvaluation.lastName( employeeEvaluationEntity.getLastName() );
        List<Skill> list = employeeEvaluationEntity.getSkills();
        if ( list != null ) {
            employeeEvaluation.skills( new ArrayList<Skill>( list ) );
        }

        return employeeEvaluation.build();
    }

    @Override
    public List<EmployeeEvaluation> toEmployeeEvaluations(List<EmployeeEvaluationEntity> employeeEvaluationEntity) {
        if ( employeeEvaluationEntity == null ) {
            return null;
        }

        List<EmployeeEvaluation> list = new ArrayList<EmployeeEvaluation>( employeeEvaluationEntity.size() );
        for ( EmployeeEvaluationEntity employeeEvaluationEntity1 : employeeEvaluationEntity ) {
            list.add( toEmployeeEvaluation( employeeEvaluationEntity1 ) );
        }

        return list;
    }

    @Override
    public EmployeeEvaluationEntity fromEmployeeEvaluation(EmployeeEvaluation employeeEvaluation) {
        if ( employeeEvaluation == null ) {
            return null;
        }

        EmployeeEvaluationEntity.EmployeeEvaluationEntityBuilder employeeEvaluationEntity = EmployeeEvaluationEntity.builder();

        employeeEvaluationEntity.assessmentId( employeeEvaluation.getAssessmentId() );
        employeeEvaluationEntity.usernameFor( employeeEvaluation.getUsernameFor() );
        employeeEvaluationEntity.usernameFrom( employeeEvaluation.getUsernameFrom() );
        employeeEvaluationEntity.usernameCreated( employeeEvaluation.getUsernameCreated() );
        employeeEvaluationEntity.firstName( employeeEvaluation.getFirstName() );
        employeeEvaluationEntity.lastName( employeeEvaluation.getLastName() );
        employeeEvaluationEntity.status( employeeEvaluation.getStatus() );
        List<Skill> list = employeeEvaluation.getSkills();
        if ( list != null ) {
            employeeEvaluationEntity.skills( new ArrayList<Skill>( list ) );
        }

        return employeeEvaluationEntity.build();
    }
}
