package com.org.hrms.dto.response;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {
  public Boolean status;
  public String message;
  public EmployeeDto data;

  @Getter
  @Setter
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class EmployeeDto {
    public Integer id;
    public String firstName;
    public String lastName;
    public String email;
    public String phoneNumber;
    public String employeeRole;
    public Date joiningDate;
    public String address;
    public String projectName;
    public String reportingManager;
    public String reviewingManager;
  }
}
