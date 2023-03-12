package org.skillhub.service;

import lombok.RequiredArgsConstructor;
import org.skillhub.model.EmployeeCoefficient;
import org.skillhub.model.EmployeeCoefficientModel;
import org.skillhub.model.EmployeeEvaluation;
import org.skillhub.model.PerfectMatch;
import org.skillhub.model.Profile;
import org.skillhub.model.Skill;
import org.skillhub.transferable.Coefficient;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

@Service
@RequiredArgsConstructor
public class MatcherService {
  private final EmployeeCoefficientService employeeCoefficientService;

  public List<EmployeeCoefficient> perfectMatch(PerfectMatch perfectMatch) {
    List<EmployeeCoefficientModel> employeeCoefficientModels = employeeCoefficientService.getAll();
    List<String> skills = perfectMatch.getSkills();

    List<EmployeeCoefficient> result = new ArrayList<>();

    for (EmployeeCoefficientModel employeeCoefficientModel : employeeCoefficientModels) {
      BigDecimal coefficient = employeeCoefficientModel.getSkills().stream()
          .filter(e -> skills.contains(e.getName()))
          .map(Skill::getScore)
          .reduce(BigDecimal.ZERO, BigDecimal::add);

      EmployeeCoefficient employeeCoefficient = EmployeeCoefficient.builder()
          .firstName(employeeCoefficientModel.getFirstName())
          .lastName(employeeCoefficientModel.getLastName())
          .username(employeeCoefficientModel.getUsername())
          .coefficient(coefficient)
          .build();

      result.add(employeeCoefficient);
    }

    result.sort((o1, o2) -> o2.getCoefficient().compareTo(o1.getCoefficient()));
    return result;
  }
}
