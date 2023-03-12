package org.skillhub.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skillhub.mapper.EmployeeEvaluationMapper;
import org.skillhub.mapper.EmployeeEvaluationMapperImpl;
import org.skillhub.model.EmployeeEvaluation;
import org.skillhub.model.EmployeeEvaluationEntity;
import org.skillhub.model.Skill;
import org.skillhub.repository.EmployeeEvaluationRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeEvaluationServiceTest {

  private EmployeeEvaluationService employeeEvaluationService;
  @Mock
  private EmployeeEvaluationRepository employeeEvaluationRepository;
  private EmployeeEvaluationMapper employeeEvaluationMapper;

  @BeforeEach
  public void setUp() {
    employeeEvaluationMapper = new EmployeeEvaluationMapperImpl();
    employeeEvaluationService = new EmployeeEvaluationService(employeeEvaluationRepository, employeeEvaluationMapper);
  }

  @Test
  public void testCreateEmployeeEvaluation() {
    when(employeeEvaluationRepository.save(any())).thenReturn(employeeEvaluationEntity());
    EmployeeEvaluation employeeEvaluation =
        employeeEvaluationService.createEmployeeEvaluation("username", employeeEvaluation());
    assertEquals("usernameFor", employeeEvaluation.getUsernameFor());
    assertEquals("usernameFrom", employeeEvaluation.getUsernameFrom());
    assertEquals("usernameCreated", employeeEvaluation.getUsernameCreated());
  }

  @Test
  public void testUpdateEmployeeEvaluation() {
    when(employeeEvaluationRepository.save(any())).thenReturn(employeeEvaluationEntity());
    when(employeeEvaluationRepository.findByUsernameFromAndUsernameFor(any(), any()))
        .thenReturn(Optional.of(employeeEvaluationEntity()));
    EmployeeEvaluation employeeEvaluation =
        employeeEvaluationService.updateEmployeeEvaluation("username", employeeEvaluation());
    assertEquals("usernameFor", employeeEvaluation.getUsernameFor());
    assertEquals("usernameFrom", employeeEvaluation.getUsernameFrom());
    assertEquals("usernameCreated", employeeEvaluation.getUsernameCreated());
  }

  private EmployeeEvaluation employeeEvaluation() {
    List<Skill> skills = new ArrayList<>();
    skills.add(new Skill("Java", BigDecimal.TEN));

    EmployeeEvaluation employeeEvaluation = new EmployeeEvaluation();
    employeeEvaluation.setUsernameFor("usernameFor");
    employeeEvaluation.setUsernameCreated("usernameCreated");
    employeeEvaluation.setUsernameFrom("usernameFrom");
    employeeEvaluation.setFirstName("firstname");
    employeeEvaluation.setLastName("lastname");
    employeeEvaluation.setAssessmentId(1);
    employeeEvaluation.setSkills(skills);
    return employeeEvaluation;
  }

  private EmployeeEvaluationEntity employeeEvaluationEntity() {
    List<Skill> skills = new ArrayList<>();
    skills.add(new Skill("Java", BigDecimal.TEN));

    EmployeeEvaluationEntity employeeEvaluationEntity = new EmployeeEvaluationEntity();
    employeeEvaluationEntity.setUsernameFor("usernameFor");
    employeeEvaluationEntity.setUsernameCreated("usernameCreated");
    employeeEvaluationEntity.setUsernameFrom("usernameFrom");
    employeeEvaluationEntity.setFirstName("firstname");
    employeeEvaluationEntity.setLastName("lastname");
    employeeEvaluationEntity.setAssessmentId(1);
    employeeEvaluationEntity.setSkills(skills);
    return employeeEvaluationEntity;
  }
}
