package org.skillhub.service;

import lombok.RequiredArgsConstructor;
import org.skillhub.mapper.EmployeeEvaluationMapper;
import org.skillhub.model.EmployeeEvaluation;
import org.skillhub.model.EmployeeEvaluationEntity;
import org.skillhub.repository.EmployeeEvaluationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeEvaluationService {

  private final EmployeeEvaluationRepository employeeEvaluationRepository;
  private final EmployeeEvaluationMapper employeeEvaluationMapper;

  public EmployeeEvaluation createEmployeeEvaluation(String username, EmployeeEvaluation employeeEvaluation) {
    EmployeeEvaluationEntity employeeEvaluationEntity =
        employeeEvaluationMapper.fromEmployeeEvaluation(employeeEvaluation);
    EmployeeEvaluationEntity savedEmployeeEvaluation =
        employeeEvaluationRepository.save(employeeEvaluationEntity);
    return employeeEvaluationMapper.toEmployeeEvaluation(savedEmployeeEvaluation);
  }

  public List<EmployeeEvaluation> getPendingEmployeeEvaluationByUsername(String username) {
    return employeeEvaluationMapper.toEmployeeEvaluations(
        employeeEvaluationRepository.findAllByUsernameFromAndStatus(username, "PENDING"));
  }

  public EmployeeEvaluation updateEmployeeEvaluation(String username, EmployeeEvaluation employeeEvaluation) {
    Optional<EmployeeEvaluationEntity> employeeEvaluationEntity = employeeEvaluationRepository
        .findByUsernameFromAndUsernameFor(employeeEvaluation.getUsernameFrom(), employeeEvaluation.getUsernameFor());
    EmployeeEvaluationEntity entity = employeeEvaluationEntity.orElseThrow();
    entity.setSkills(employeeEvaluation.getSkills());
    entity.setStatus("COMPLETED");
    return employeeEvaluationMapper.toEmployeeEvaluation(employeeEvaluationRepository.save(entity));
  }

  public List<EmployeeEvaluation> getAllEmployeeEvaluations(String username) {
    return employeeEvaluationMapper.toEmployeeEvaluations(employeeEvaluationRepository.findAllByUsernameCreated(username));
  }

  public List<EmployeeEvaluation> findAll() {
    return employeeEvaluationMapper.toEmployeeEvaluations(employeeEvaluationRepository.findAll());
  }

  public List<EmployeeEvaluation> findAllByUsernameFor(String username) {
    return employeeEvaluationMapper.toEmployeeEvaluations(employeeEvaluationRepository.findAllByUsernameFor(username));
  }
}
