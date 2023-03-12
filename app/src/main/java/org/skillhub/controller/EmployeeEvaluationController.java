package org.skillhub.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.skillhub.api.EmployeeApi;
import org.skillhub.model.EmployeeCoefficient;
import org.skillhub.model.EmployeeEvaluation;
import org.skillhub.model.PerfectMatch;
import org.skillhub.model.Profile;
import org.skillhub.service.EmployeeCoefficientService;
import org.skillhub.service.EmployeeEvaluationService;
import org.skillhub.service.MatcherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
public class EmployeeEvaluationController implements org.skillhub.api.EmployeeApi {

  private final EmployeeEvaluationService employeeEvaluationService;
  private final MatcherService matcherService;
  private final EmployeeCoefficientService employeeCoefficientService;

  @Override
  public ResponseEntity<EmployeeEvaluation> createEmployeeEvaluation(Principal principal,
                                                                     EmployeeEvaluation employeeEvaluation) {
    EmployeeEvaluation response =
        employeeEvaluationService.createEmployeeEvaluation(principal.getName(), employeeEvaluation);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<EmployeeEvaluation>> getEmployeeEvaluations(Principal principal) {
    List<EmployeeEvaluation> employeeEvaluations =
        employeeEvaluationService.getPendingEmployeeEvaluationByUsername(principal.getName());
    return new ResponseEntity<>(employeeEvaluations, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<EmployeeEvaluation>> getAllEmployeeEvaluations(Principal principal) {
    List<EmployeeEvaluation> employeeEvaluations =
        employeeEvaluationService.getAllEmployeeEvaluations(principal.getName());
    return new ResponseEntity<>(employeeEvaluations, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<EmployeeEvaluation> updateEmployeeEvaluations(Principal principal,
                                                                      EmployeeEvaluation employeeEvaluation) {
    EmployeeEvaluation updatedEmployeeEvaluation =
        employeeEvaluationService.updateEmployeeEvaluation(principal.getName(), employeeEvaluation);
    return new ResponseEntity<>(updatedEmployeeEvaluation, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<EmployeeCoefficient>> getAllEmployeeByPerfectMatch(Principal principal, PerfectMatch perfectMatch) {
    List<EmployeeCoefficient> employeeCoefficients = matcherService.perfectMatch(perfectMatch);
    return new ResponseEntity<>(employeeCoefficients, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<String> recalculateCoefficient(Principal principal) {
    employeeCoefficientService.recalculateCoefficient();
    return new ResponseEntity<>("recalculated", HttpStatus.OK);
  }
}
