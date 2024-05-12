package com.org.hrms.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppraisalRequest {
  private Integer employeeId;
  private Integer appraisalCycle;
  private String criteriaName;
  private Integer rating;
  private String comment;
  private String givenBy;

}
