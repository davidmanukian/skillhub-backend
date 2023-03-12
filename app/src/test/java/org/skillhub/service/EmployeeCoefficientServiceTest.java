package org.skillhub.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skillhub.model.Certificate;
import org.skillhub.model.EmployeeCoefficientModel;
import org.skillhub.model.EmployeeEvaluation;
import org.skillhub.model.Profile;
import org.skillhub.model.Skill;
import org.skillhub.repository.EmployeeCoefficientRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeCoefficientServiceTest {

  private EmployeeCoefficientService employeeCoefficientService;
  @Mock
  private EmployeeCoefficientRepository employeeCoefficientRepository;
  @Mock
  private ProfileService profileService;
  @Mock
  private EmployeeEvaluationService employeeEvaluationService;

  @BeforeEach
  public void setUp() {
    employeeCoefficientService = new EmployeeCoefficientService(employeeCoefficientRepository,
        profileService, employeeEvaluationService);
  }

  @Test
  public void testRecalculateCoefficient() {
    List<Skill> skills = new ArrayList<>();
    skills.add(new Skill("Java", BigDecimal.valueOf(3)));
    skills.add(new Skill("Python", BigDecimal.valueOf(4)));
    skills.add(new Skill("JavaScript", BigDecimal.valueOf(3)));
    Profile profileEntity = profileEntity("my-test-username", skills);
    when(profileService.findAll())
        .thenReturn(List.of(profileEntity));
    when(employeeEvaluationService.findAllByUsernameFor(any()))
        .thenReturn(List.of(employeeEvaluation(skills)));

    employeeCoefficientService.recalculateCoefficient();
    ArgumentCaptor<EmployeeCoefficientModel> argumentCaptor = ArgumentCaptor.forClass(EmployeeCoefficientModel.class);
    verify(employeeCoefficientRepository, times(1)).save(argumentCaptor.capture());

    EmployeeCoefficientModel coefficientModel = argumentCaptor.getValue();
    assertNotNull(coefficientModel);
  }

  private Profile profileEntity(String username, List<Skill> skills) {
    Profile profile = new Profile();
    profile.setId(1111);
    profile.setFirstName("FirstName");
    profile.setUsername(username);
    profile.setLastName("LastName");
    profile.setSkills(skills);
    profile.setCertificates(List.of(new Certificate()));
    profile.setAbout("Big text about you");
    profile.setPosition("Senior Software Engineer");
    profile.setTeam("Dream team");
    return profile;
  }

  private EmployeeEvaluation employeeEvaluation(List<Skill> skills) {
    EmployeeEvaluation employeeEvaluation = new EmployeeEvaluation();
    employeeEvaluation.setFirstName("MyFirstName");
    employeeEvaluation.setLastName("MyLastName");
    employeeEvaluation.setSkills(skills);
    employeeEvaluation.setAssessmentId(1);
    employeeEvaluation.setUsernameCreated("username-created");
    employeeEvaluation.setUsernameFor("username-for");
    employeeEvaluation.setUsernameFrom("username-from");
    return employeeEvaluation;
  }
}
