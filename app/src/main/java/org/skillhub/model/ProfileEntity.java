package org.skillhub.model;

import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import io.hypersistence.utils.hibernate.type.json.JsonBlobType;
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
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "profiles", schema = "skillhub")
public class ProfileEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Integer id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "username")
  private String username;

  @Column(name = "title")
  private String position;

  @Column(name = "team")
  private String team;

  @Column(name = "about", columnDefinition = "text", length = 1500)
  private String about;

  @Column(name = "skills", columnDefinition = "jsonb")
  @Type(JsonType.class)
  private List<Skill> skills;

  @Column(name = "certificates", columnDefinition = "jsonb")
  @Type(JsonType.class)
  private List<Certificate> certificates;

  @Column(name = "image", columnDefinition = "jsonb")
  @Type(JsonType.class)
  private Image image;
}
