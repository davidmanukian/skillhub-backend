package org.skillhub.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.skillhub.model.Assessment;
import org.skillhub.model.AssessmentEntity;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AssessmentMapper {
  Assessment toAssessment(AssessmentEntity assessmentEntity);
  List<Assessment> toAssessments(List<AssessmentEntity> assessmentEntities);
  AssessmentEntity fromAssessment(Assessment assessment);
  List<AssessmentEntity> fromAssessments(List<Assessment> assessments);
  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateAssessmentFromDTO(Assessment assessment, @MappingTarget AssessmentEntity assessmentEntity);
}
