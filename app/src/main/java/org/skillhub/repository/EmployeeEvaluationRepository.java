package org.skillhub.repository;

import org.skillhub.model.EmployeeEvaluation;
import org.skillhub.model.EmployeeEvaluationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeEvaluationRepository extends JpaRepository<EmployeeEvaluationEntity, Integer> {

  List<EmployeeEvaluationEntity> findAllByUsernameFromAndStatus(String username, String status);

  List<EmployeeEvaluationEntity> findAllByUsernameCreated(String username);

  List<EmployeeEvaluationEntity> findAllByUsernameFor(String username);
  Optional<EmployeeEvaluationEntity> findByUsernameFromAndUsernameFor(String usernameFrom, String usernameFor);
}
