package org.skillhub.model;

import lombok.Data;

@Data
public class Certificate {
  private String name;
  private String issueMonth;
  private String issueYear;
  private String expirationMonth;
  private String expirationYear;
}
