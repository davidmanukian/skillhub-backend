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
import org.hibernate.annotations.Type;

import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "assessment", schema = "skillhub")
public class AssessmentEntity {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "username")
  private String username;

  @Column(name = "assessment_for", columnDefinition = "jsonb")
  @Type(JsonType.class)
  private ProfileEntity assessmentFor;

  @Column(name = "assessment_people", columnDefinition = "jsonb")
  @Type(JsonType.class)
  private List<ProfileEntity> assessmentPeople;
}
