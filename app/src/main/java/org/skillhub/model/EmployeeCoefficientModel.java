package org.skillhub.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("EmployeeCoefficient")
public class EmployeeCoefficientModel implements Serializable {

  @Id
  private String username;

  private String firstName;

  private String lastName;

  private List<Skill> skills;
}
