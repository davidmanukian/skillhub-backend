package org.skillhub.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import org.skillhub.model.Profile;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Assessment
 */
@lombok.Builder(toBuilder=true)
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-03-14T19:45:14.512692+04:00[Asia/Yerevan]")
public class Assessment {

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("assessmentFor")
  private Profile assessmentFor;

  @JsonProperty("assessmentPeople")
  @Valid
  private List<Profile> assessmentPeople = null;

  public Assessment id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", required = false)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Assessment assessmentFor(Profile assessmentFor) {
    this.assessmentFor = assessmentFor;
    return this;
  }

  /**
   * Get assessmentFor
   * @return assessmentFor
  */
  @Valid 
  @Schema(name = "assessmentFor", required = false)
  public Profile getAssessmentFor() {
    return assessmentFor;
  }

  public void setAssessmentFor(Profile assessmentFor) {
    this.assessmentFor = assessmentFor;
  }

  public Assessment assessmentPeople(List<Profile> assessmentPeople) {
    this.assessmentPeople = assessmentPeople;
    return this;
  }

  public Assessment addAssessmentPeopleItem(Profile assessmentPeopleItem) {
    if (this.assessmentPeople == null) {
      this.assessmentPeople = new ArrayList<>();
    }
    this.assessmentPeople.add(assessmentPeopleItem);
    return this;
  }

  /**
   * Get assessmentPeople
   * @return assessmentPeople
  */
  @Valid 
  @Schema(name = "assessmentPeople", required = false)
  public List<Profile> getAssessmentPeople() {
    return assessmentPeople;
  }

  public void setAssessmentPeople(List<Profile> assessmentPeople) {
    this.assessmentPeople = assessmentPeople;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Assessment assessment = (Assessment) o;
    return Objects.equals(this.id, assessment.id) &&
        Objects.equals(this.assessmentFor, assessment.assessmentFor) &&
        Objects.equals(this.assessmentPeople, assessment.assessmentPeople);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, assessmentFor, assessmentPeople);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Assessment {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    assessmentFor: ").append(toIndentedString(assessmentFor)).append("\n");
    sb.append("    assessmentPeople: ").append(toIndentedString(assessmentPeople)).append("\n");
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

