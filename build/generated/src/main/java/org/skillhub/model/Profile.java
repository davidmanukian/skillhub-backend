package org.skillhub.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Profile
 */
@lombok.Builder(toBuilder=true)
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-01-21T01:53:09.787552+04:00[Asia/Yerevan]")
public class Profile {

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("about")
  private String about;

  @JsonProperty("skillsAndTechnologies")
  private String skillsAndTechnologies;

  @JsonProperty("certifications")
  private String certifications;

  public Profile firstName(String firstName) {
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

  public Profile lastName(String lastName) {
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

  public Profile about(String about) {
    this.about = about;
    return this;
  }

  /**
   * Get about
   * @return about
  */
  
  @Schema(name = "about", required = false)
  public String getAbout() {
    return about;
  }

  public void setAbout(String about) {
    this.about = about;
  }

  public Profile skillsAndTechnologies(String skillsAndTechnologies) {
    this.skillsAndTechnologies = skillsAndTechnologies;
    return this;
  }

  /**
   * Get skillsAndTechnologies
   * @return skillsAndTechnologies
  */
  
  @Schema(name = "skillsAndTechnologies", required = false)
  public String getSkillsAndTechnologies() {
    return skillsAndTechnologies;
  }

  public void setSkillsAndTechnologies(String skillsAndTechnologies) {
    this.skillsAndTechnologies = skillsAndTechnologies;
  }

  public Profile certifications(String certifications) {
    this.certifications = certifications;
    return this;
  }

  /**
   * Get certifications
   * @return certifications
  */
  
  @Schema(name = "certifications", required = false)
  public String getCertifications() {
    return certifications;
  }

  public void setCertifications(String certifications) {
    this.certifications = certifications;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Profile profile = (Profile) o;
    return Objects.equals(this.firstName, profile.firstName) &&
        Objects.equals(this.lastName, profile.lastName) &&
        Objects.equals(this.about, profile.about) &&
        Objects.equals(this.skillsAndTechnologies, profile.skillsAndTechnologies) &&
        Objects.equals(this.certifications, profile.certifications);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, about, skillsAndTechnologies, certifications);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Profile {\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    about: ").append(toIndentedString(about)).append("\n");
    sb.append("    skillsAndTechnologies: ").append(toIndentedString(skillsAndTechnologies)).append("\n");
    sb.append("    certifications: ").append(toIndentedString(certifications)).append("\n");
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

