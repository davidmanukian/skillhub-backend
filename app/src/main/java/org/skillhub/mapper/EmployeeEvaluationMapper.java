package org.skillhub.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.skillhub.model.EmployeeEvaluation;
import org.skillhub.model.EmployeeEvaluationEntity;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeEvaluationMapper {

  EmployeeEvaluation toEmployeeEvaluation(EmployeeEvaluationEntity employeeEvaluationEntity);

  List<EmployeeEvaluation> toEmployeeEvaluations(List<EmployeeEvaluationEntity> employeeEvaluationEntity);

  EmployeeEvaluationEntity fromEmployeeEvaluation(EmployeeEvaluation employeeEvaluation);
}
