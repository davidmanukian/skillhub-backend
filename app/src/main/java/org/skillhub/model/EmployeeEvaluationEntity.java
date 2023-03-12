package org.skillhub.model;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee_evaluation", schema = "skillhub")
public class EmployeeEvaluationEntity {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private Integer assessmentId;
  private String usernameFor;
  private String usernameFrom;
  private String usernameCreated;
  private String firstName;
  private String lastName;
  private String status;
  @Column(name = "skills", columnDefinition = "jsonb")
  @Type(JsonType.class)
  private List<Skill> skills;
  @Column(name = "created_on")
  @CreationTimestamp
  private Date createdOn;
  @Column(name = "updated_on")
  @UpdateTimestamp
  private Date updatedOn;
}
