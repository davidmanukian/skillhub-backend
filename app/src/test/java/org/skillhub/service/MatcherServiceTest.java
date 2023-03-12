package org.skillhub.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skillhub.model.EmployeeCoefficient;
import org.skillhub.model.EmployeeCoefficientModel;
import org.skillhub.model.PerfectMatch;
import org.skillhub.model.Skill;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MatcherServiceTest {

  private MatcherService matcherService;
  @Mock
  private EmployeeCoefficientService employeeCoefficientService;

  @BeforeEach
  public void setUp() {
    matcherService = new MatcherService(employeeCoefficientService);
  }

  @Test
  public void testPerfectMatch() {
    when(employeeCoefficientService.getAll()).thenReturn(List.of(employeeCoefficientModel()));
    List<EmployeeCoefficient> employeeCoefficients = matcherService.perfectMatch(perfectMatch());
    assertNotNull(employeeCoefficients);
    assertEquals(1, employeeCoefficients.size());
    EmployeeCoefficient employeeCoefficient = employeeCoefficients.get(0);
    assertEquals("MyFirstName", employeeCoefficient.getFirstName());
    assertEquals("MyLastName", employeeCoefficient.getLastName());
  }

  private PerfectMatch perfectMatch() {
    PerfectMatch perfectMatch = new PerfectMatch();
    perfectMatch.setSkills(List.of("Java"));
    return perfectMatch;
  }

  private EmployeeCoefficientModel employeeCoefficientModel() {
    List<Skill> skills = new ArrayList<>();
    skills.add(new Skill("Java", BigDecimal.TEN));

    EmployeeCoefficientModel model = new EmployeeCoefficientModel();
    model.setFirstName("MyFirstName");
    model.setLastName("MyLastName");
    model.setUsername("MyUsername");
    model.setSkills(skills);
    return model;
  }
}
