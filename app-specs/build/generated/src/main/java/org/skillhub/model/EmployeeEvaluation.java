package org.skillhub.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import org.skillhub.model.Skill;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * EmployeeEvaluation
 */
@lombok.Builder(toBuilder=true)
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-03-14T19:45:14.512692+04:00[Asia/Yerevan]")
public class EmployeeEvaluation {

  @JsonProperty("assessmentId")
  private Integer assessmentId;

  @JsonProperty("usernameFor")
  private String usernameFor;

  @JsonProperty("usernameFrom")
  private String usernameFrom;

  @JsonProperty("usernameCreated")
  private String usernameCreated;

  @JsonProperty("status")
  private String status;

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("skills")
  @Valid
  private List<Skill> skills = null;

  public EmployeeEvaluation assessmentId(Integer assessmentId) {
    this.assessmentId = assessmentId;
    return this;
  }

  /**
   * Get assessmentId
   * @return assessmentId
  */
  
  @Schema(name = "assessmentId", required = false)
  public Integer getAssessmentId() {
    return assessmentId;
  }

  public void setAssessmentId(Integer assessmentId) {
    this.assessmentId = assessmentId;
  }

  public EmployeeEvaluation usernameFor(String usernameFor) {
    this.usernameFor = usernameFor;
    return this;
  }

  /**
   * Get usernameFor
   * @return usernameFor
  */
  
  @Schema(name = "usernameFor", required = false)
  public String getUsernameFor() {
    return usernameFor;
  }

  public void setUsernameFor(String usernameFor) {
    this.usernameFor = usernameFor;
  }

  public EmployeeEvaluation usernameFrom(String usernameFrom) {
    this.usernameFrom = usernameFrom;
    return this;
  }

  /**
   * Get usernameFrom
   * @return usernameFrom
  */
  
  @Schema(name = "usernameFrom", required = false)
  public String getUsernameFrom() {
    return usernameFrom;
  }

  public void setUsernameFrom(String usernameFrom) {
    this.usernameFrom = usernameFrom;
  }

  public EmployeeEvaluation usernameCreated(String usernameCreated) {
    this.usernameCreated = usernameCreated;
    return this;
  }

  /**
   * Get usernameCreated
   * @return usernameCreated
  */
  
  @Schema(name = "usernameCreated", required = false)
  public String getUsernameCreated() {
    return usernameCreated;
  }

  public void setUsernameCreated(String usernameCreated) {
    this.usernameCreated = usernameCreated;
  }

  public EmployeeEvaluation status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  
  @Schema(name = "status", required = false)
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public EmployeeEvaluation firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
  */
  
  @Schema(name = "firstName", required = false)
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public EmployeeEvaluation lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
  */
  
  @Schema(name = "lastName", required = false)
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public EmployeeEvaluation skills(List<Skill> skills) {
    this.skills = skills;
    return this;
  }

  public EmployeeEvaluation addSkillsItem(Skill skillsItem) {
    if (this.skills == null) {
      this.skills = new ArrayList<>();
    }
    this.skills.add(skillsItem);
    return this;
  }

  /**
   * Get skills
   * @return skills
  */
  @Valid 
  @Schema(name = "skills", required = false)
  public List<Skill> getSkills() {
    return skills;
  }

  public void setSkills(List<Skill> skills) {
    this.skills = skills;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmployeeEvaluation employeeEvaluation = (EmployeeEvaluation) o;
    return Objects.equals(this.assessmentId, employeeEvaluation.assessmentId) &&
        Objects.equals(this.usernameFor, employeeEvaluation.usernameFor) &&
        Objects.equals(this.usernameFrom, employeeEvaluation.usernameFrom) &&
        Objects.equals(this.usernameCreated, employeeEvaluation.usernameCreated) &&
        Objects.equals(this.status, employeeEvaluation.status) &&
        Objects.equals(this.firstName, employeeEvaluation.firstName) &&
        Objects.equals(this.lastName, employeeEvaluation.lastName) &&
        Objects.equals(this.skills, employeeEvaluation.skills);
  }

  @Override
  public int hashCode() {
    return Objects.hash(assessmentId, usernameFor, usernameFrom, usernameCreated, status, firstName, lastName, skills);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmployeeEvaluation {\n");
    sb.append("    assessmentId: ").append(toIndentedString(assessmentId)).append("\n");
    sb.append("    usernameFor: ").append(toIndentedString(usernameFor)).append("\n");
    sb.append("    usernameFrom: ").append(toIndentedString(usernameFrom)).append("\n");
    sb.append("    usernameCreated: ").append(toIndentedString(usernameCreated)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    skills: ").append(toIndentedString(skills)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

