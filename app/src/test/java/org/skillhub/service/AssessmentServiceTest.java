package org.skillhub.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skillhub.mapper.AssessmentMapper;
import org.skillhub.mapper.AssessmentMapperImpl;
import org.skillhub.model.Assessment;
import org.skillhub.model.AssessmentEntity;
import org.skillhub.model.Certificate;
import org.skillhub.model.PreviewAssessment;
import org.skillhub.model.Profile;
import org.skillhub.model.ProfileEntity;
import org.skillhub.model.Skill;
import org.skillhub.repository.AssessmentRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AssessmentServiceTest {

  private AssessmentService assessmentService;
  @Mock
  private AssessmentRepository assessmentRepository;
  private AssessmentMapper assessmentMapper;
  @Mock
  private EmployeeEvaluationService employeeEvaluationService;


  @BeforeEach
  public void setUp() {
    assessmentMapper = new AssessmentMapperImpl();
    assessmentService = new AssessmentService(assessmentRepository, assessmentMapper, employeeEvaluationService);
  }

  @Test
  public void testGetAllAssessment() {
    when(assessmentRepository.findAllByUsername("my-username")).thenReturn(List.of(assessmentEntity()));
    List<Assessment> allAssessments = assessmentService.getAllAssessments("my-username");
    assertNotNull(allAssessments);
    assertEquals(1, allAssessments.size());
    Assessment assessment = allAssessments.get(0);
    assertEquals("MyFirstName", assessment.getAssessmentFor().getFirstName());
    assertEquals("MyLastName", assessment.getAssessmentFor().getLastName());
  }

  @Test
  public void testGetAssessmentsToReview() {
    when(assessmentRepository.findAllAssessmentsToReview(any())).thenReturn(List.of(assessmentEntity()));
    List<PreviewAssessment> previewAssessments = assessmentService.getAssessmentsToReview("MyUsername");
    assertNotNull(previewAssessments);
    assertEquals(1, previewAssessments.size());
    PreviewAssessment previewAssessment = previewAssessments.get(0);
    assertEquals("MyFirstName", previewAssessment.getFirstName());
    assertEquals("MyLastName", previewAssessment.getLastName());
  }

  @Test
  public void testSaveAssessment() {
    when(assessmentRepository.saveAndFlush(any())).thenReturn(assessmentEntity());
    assessmentService.saveAssessment("MyUsername", assessment());
    verify(employeeEvaluationService, times(1)).createEmployeeEvaluation(any(), any());
  }

  private AssessmentEntity assessmentEntity() {
    AssessmentEntity assessmentEntity = new AssessmentEntity();
    assessmentEntity.setAssessmentFor(profileEntity("MyFirstName", "MyLastName", "MyUsername"));
    assessmentEntity.setAssessmentPeople(List.of(profileEntity("TestFirstName", "TestLastName", "TestUsername")));
    assessmentEntity.setId(1);
    assessmentEntity.setUsername("manager-username");
    return assessmentEntity;
  }

  private Assessment assessment() {
    Assessment assessment = new Assessment();
    assessment.setAssessmentFor(profile("MyFirstName", "MyLastName", "MyUsername"));
    assessment.setAssessmentPeople(List.of(profile("TestFirstName", "TestLastName", "TestUsername")));
    assessment.setId(1);
    return assessment;
  }

  private ProfileEntity profileEntity(String firstName,
                                      String lastName,
                                      String username) {
    List<Skill> skills = new ArrayList<>();
    skills.add(new Skill("Java", BigDecimal.TEN));

    ProfileEntity profileEntity = new ProfileEntity();
    profileEntity.setId(1111);
    profileEntity.setFirstName(firstName);
    profileEntity.setLastName(lastName);
    profileEntity.setUsername(username);
    profileEntity.setSkills(skills);
    profileEntity.setCertificates(List.of(new Certificate()));
    profileEntity.setAbout("Big text about you");
    profileEntity.setPosition("Senior Software Engineer");
    profileEntity.setTeam("Dream team");
    return profileEntity;
  }

  private Profile profile(String firstName,
                          String lastName,
                          String username) {
    List<Skill> skills = new ArrayList<>();
    skills.add(new Skill("Java", BigDecimal.TEN));

    Profile profile = new Profile();
    profile.setId(1111);
    profile.setFirstName(firstName);
    profile.setLastName(lastName);
    profile.setUsername(username);
    profile.setSkills(skills);
    profile.setCertificates(List.of(new Certificate()));
    profile.setAbout("Big text about you");
    profile.setPosition("Senior Software Engineer");
    profile.setTeam("Dream team");
    return profile;
  }
}
