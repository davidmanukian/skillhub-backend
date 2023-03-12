package org.skillhub.service;

import lombok.RequiredArgsConstructor;
import org.skillhub.model.EmployeeCoefficientModel;
import org.skillhub.model.EmployeeEvaluation;
import org.skillhub.model.Profile;
import org.skillhub.model.Skill;
import org.skillhub.repository.EmployeeCoefficientRepository;
import org.skillhub.transferable.Coefficient;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmployeeCoefficientService {

  private final EmployeeCoefficientRepository employeeCoefficientRepository;
  private final ProfileService profileService;
  private final EmployeeEvaluationService employeeEvaluationService;

  public EmployeeCoefficientModel save(EmployeeCoefficientModel employeeCoefficientModel) {
    return employeeCoefficientRepository.save(employeeCoefficientModel);
  }

  public List<EmployeeCoefficientModel> getAll() {
    return employeeCoefficientRepository.findAll();
  }

  public void recalculateCoefficient() {
    List<Profile> profiles = profileService.findAll();
    for (Profile profile : profiles) {
      List<EmployeeEvaluation> employeeEvaluations =
          employeeEvaluationService.findAllByUsernameFor(profile.getUsername());
      Map<String, Coefficient> groupBySkill = new HashMap<>();
      List<Skill> profileSkills = profile.getSkills();
      profileSkills.forEach(skill ->
          groupBySkill.put(skill.getName(), new Coefficient(skill.getScore(), 1)));
      for (EmployeeEvaluation employeeEvaluation : employeeEvaluations) {
        List<Skill> skills = employeeEvaluation.getSkills();
        skills.forEach(skill -> {
          Coefficient orDefault = groupBySkill.getOrDefault(skill.getName(), new Coefficient(BigDecimal.ZERO, 0));
          orDefault.setCount(orDefault.getCount() + 1);
          orDefault.setScore(orDefault.getScore().add(skill.getScore()));
          groupBySkill.put(skill.getName(), orDefault);
        });
      }
      List<Skill> skills = groupBySkill.entrySet().stream().map(e -> new Skill(e.getKey(),
          e.getValue().getScore().divide(BigDecimal.valueOf(e.getValue().getCount()), RoundingMode.valueOf(2)))).toList();
      EmployeeCoefficientModel employeeCoefficientModel = EmployeeCoefficientModel.builder()
          .username(profile.getUsername())
          .firstName(profile.getFirstName())
          .lastName(profile.getLastName())
          .skills(skills)
          .build();
      save(employeeCoefficientModel);
    }
  }
}
