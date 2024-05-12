package com.org.hrms.dto;

import com.org.hrms.entity.Employee;
import jakarta.persistence.OneToOne;
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
public class TimesheetDto {
  private Integer id;
  private Integer employeeId;
  private Employee employee;
  private String projectName;
  private double billableHours;
  private double nonBillableHours;
  private int leaves;
  private int extraWorkingDays;
  private String comments;
}
