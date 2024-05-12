package com.org.hrms.dto.response;

import com.org.hrms.dto.TimesheetDto;
import com.org.hrms.entity.Employee;
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
public class TimesheetResponse {
  public Boolean status;
  public String message;
  public TimesheetDto data;

}
