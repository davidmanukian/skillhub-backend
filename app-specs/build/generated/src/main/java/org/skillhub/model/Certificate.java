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
 * Certificate
 */
@lombok.Builder(toBuilder=true)
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-03-14T19:45:14.512692+04:00[Asia/Yerevan]")
public class Certificate {

  @JsonProperty("name")
  private String name;

  @JsonProperty("issueMonth")
  private String issueMonth;

  @JsonProperty("issueYear")
  private String issueYear;

  @JsonProperty("expirationMonth")
  private String expirationMonth;

  @JsonProperty("expirationYear")
  private String expirationYear;

  public Certificate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", required = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Certificate issueMonth(String issueMonth) {
    this.issueMonth = issueMonth;
    return this;
  }

  /**
   * Get issueMonth
   * @return issueMonth
  */
  
  @Schema(name = "issueMonth", required = false)
  public String getIssueMonth() {
    return issueMonth;
  }

  public void setIssueMonth(String issueMonth) {
    this.issueMonth = issueMonth;
  }

  public Certificate issueYear(String issueYear) {
    this.issueYear = issueYear;
    return this;
  }

  /**
   * Get issueYear
   * @return issueYear
  */
  
  @Schema(name = "issueYear", required = false)
  public String getIssueYear() {
    return issueYear;
  }

  public void setIssueYear(String issueYear) {
    this.issueYear = issueYear;
  }

  public Certificate expirationMonth(String expirationMonth) {
    this.expirationMonth = expirationMonth;
    return this;
  }

  /**
   * Get expirationMonth
   * @return expirationMonth
  */
  
  @Schema(name = "expirationMonth", required = false)
  public String getExpirationMonth() {
    return expirationMonth;
  }

  public void setExpirationMonth(String expirationMonth) {
    this.expirationMonth = expirationMonth;
  }

  public Certificate expirationYear(String expirationYear) {
    this.expirationYear = expirationYear;
    return this;
  }

  /**
   * Get expirationYear
   * @return expirationYear
  */
  
  @Schema(name = "expirationYear", required = false)
  public String getExpirationYear() {
    return expirationYear;
  }

  public void setExpirationYear(String expirationYear) {
    this.expirationYear = expirationYear;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Certificate certificate = (Certificate) o;
    return Objects.equals(this.name, certificate.name) &&
        Objects.equals(this.issueMonth, certificate.issueMonth) &&
        Objects.equals(this.issueYear, certificate.issueYear) &&
        Objects.equals(this.expirationMonth, certificate.expirationMonth) &&
        Objects.equals(this.expirationYear, certificate.expirationYear);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, issueMonth, issueYear, expirationMonth, expirationYear);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Certificate {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    issueMonth: ").append(toIndentedString(issueMonth)).append("\n");
    sb.append("    issueYear: ").append(toIndentedString(issueYear)).append("\n");
    sb.append("    expirationMonth: ").append(toIndentedString(expirationMonth)).append("\n");
    sb.append("    expirationYear: ").append(toIndentedString(expirationYear)).append("\n");
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

