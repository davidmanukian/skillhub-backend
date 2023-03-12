package org.skillhub.service;

import lombok.RequiredArgsConstructor;
import org.skillhub.mapper.AssessmentMapper;
import org.skillhub.model.Assessment;
import org.skillhub.model.AssessmentEntity;
import org.skillhub.model.EmployeeEvaluation;
import org.skillhub.model.PreviewAssessment;
import org.skillhub.model.Profile;
import org.skillhub.repository.AssessmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssessmentService {

  private final AssessmentRepository assessmentRepository;
  private final AssessmentMapper assessmentMapper;

  private final EmployeeEvaluationService employeeEvaluationService;

  public List<Assessment> getAllAssessments(String username) {
    return assessmentMapper.toAssessments(assessmentRepository.findAllByUsername(username));
  }

  public List<PreviewAssessment> getAssessmentsToReview(String username) {
    return assessmentMapper.toAssessments(assessmentRepository.findAllAssessmentsToReview(username))
        .stream().map(e -> PreviewAssessment.builder()
            .firstName(e.getAssessmentFor().getFirstName())
            .lastName(e.getAssessmentFor().getLastName())
            .username(e.getAssessmentFor().getUsername())
            .skills(e.getAssessmentFor().getSkills())
            .build()
        ).toList();
  }

  public Assessment saveAssessment(String username, Assessment assessment) {
    AssessmentEntity assessmentEntity = assessmentMapper.fromAssessment(assessment);
    assessmentEntity.setUsername(username);
    AssessmentEntity savedAssessment = assessmentRepository.saveAndFlush(assessmentEntity);
    Assessment result = assessmentMapper.toAssessment(savedAssessment);
    createEmployeeEvaluation(username, result);
    return result;
  }

  private void createEmployeeEvaluation(String username, Assessment assessment) {
    for (Profile profile : assessment.getAssessmentPeople()) {
      EmployeeEvaluation employeeEvaluation = EmployeeEvaluation.builder()
          .assessmentId(assessment.getId())
          .usernameFor(assessment.getAssessmentFor().getUsername())
          .skills(assessment.getAssessmentFor().getSkills())
          .status("PENDING")
          .firstName(assessment.getAssessmentFor().getFirstName())
          .lastName(assessment.getAssessmentFor().getLastName())
          .usernameFrom(profile.getUsername())
          .usernameCreated(username)
          .build();
      employeeEvaluationService.createEmployeeEvaluation(username, employeeEvaluation);
    }
  }
}
