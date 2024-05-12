package com.org.hrms.dto.request;

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
public class TimesheetRequest {
  private Integer id;
  private Integer employee;
  private String projectName;
  private double billableHours;
  private double nonBillableHours;
  private int leaves;
  private int extraWorkingDays;
  private String comments;

}
