package org.skillhub.controller;

import lombok.RequiredArgsConstructor;
import org.skillhub.api.AssessmentApi;
import org.skillhub.model.Assessment;
import org.skillhub.model.PreviewAssessment;
import org.skillhub.service.AssessmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AssessmentController implements org.skillhub.api.AssessmentApi {

  private final AssessmentService assessmentService;

  @Override
  public ResponseEntity<Assessment> createAssessment(Principal principal, Assessment assessment) {
    Assessment result = assessmentService.saveAssessment(principal.getName(), assessment);
    return ResponseEntity.ok(result);
  }

  @Override
  public ResponseEntity<List<PreviewAssessment>> getAssessmentsToReview(Principal principal) {
    List<PreviewAssessment> assessmentsToReview = assessmentService.getAssessmentsToReview(principal.getName());
    return new ResponseEntity<>(assessmentsToReview, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<Assessment>> getAllAssessments(Principal principal) {
    List<Assessment> allAssessments = assessmentService.getAllAssessments(principal.getName());
    return new ResponseEntity<>(allAssessments, HttpStatus.OK);
  }
}
