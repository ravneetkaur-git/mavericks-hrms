package com.org.hrms.service;

import com.org.hrms.dto.TimesheetDto;
import com.org.hrms.dto.response.MenteesTimesheet;
import com.org.hrms.dto.response.SuccessResponse;
import com.org.hrms.dto.response.TimesheetResponse;
import org.springframework.stereotype.Service;

@Service
public interface TimesheetService {
  SuccessResponse saveTimesheet(TimesheetDto timesheetDto);

  TimesheetResponse getTimesheetById(Integer id);

  MenteesTimesheet getMenteesTimesheet(Integer id);
}
