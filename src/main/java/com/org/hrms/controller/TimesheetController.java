package com.org.hrms.controller;

import com.org.hrms.dto.TimesheetDto;
import com.org.hrms.dto.request.TimesheetRequest;
import com.org.hrms.dto.response.EmployeeResponse;
import com.org.hrms.dto.response.MenteesTimesheet;
import com.org.hrms.dto.response.SuccessResponse;
import com.org.hrms.dto.response.TimesheetResponse;
import com.org.hrms.service.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hrms-user/")
public class TimesheetController {

  @Autowired
  TimesheetService timesheetService;

  @PostMapping("save-timesheet")
  private ResponseEntity<SuccessResponse> saveTimesheet(@RequestBody TimesheetDto timesheetDto) {
    SuccessResponse successResponse = timesheetService.saveTimesheet(timesheetDto);
    return ResponseEntity.ok(successResponse);
  }

  @GetMapping("get-timesheet")
  private ResponseEntity<TimesheetResponse> getTimesheet(@RequestParam Integer id) {
    TimesheetResponse timesheetResponse = timesheetService.getTimesheetById(id);
    return ResponseEntity.ok(timesheetResponse);
  }

  @GetMapping("get-mentees-timesheet")
  private ResponseEntity<MenteesTimesheet> getMenteesTimesheet(@RequestParam Integer id) {
    MenteesTimesheet menteesTimesheet = timesheetService.getMenteesTimesheet(id);
    return ResponseEntity.ok(menteesTimesheet);
  }

}
