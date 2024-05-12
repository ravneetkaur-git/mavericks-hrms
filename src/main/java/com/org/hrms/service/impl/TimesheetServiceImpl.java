package com.org.hrms.service.impl;

import com.org.hrms.dto.TimesheetDto;
import com.org.hrms.dto.response.MenteesTimesheet;
import com.org.hrms.dto.response.SuccessResponse;
import com.org.hrms.dto.response.TimesheetResponse;
import com.org.hrms.entity.Employee;
import com.org.hrms.entity.Timesheet;
import com.org.hrms.exception.EntityAlreadyExistsException;
import com.org.hrms.exception.EntityNotFoundException;
import com.org.hrms.mapper.EmployeeMapper;
import com.org.hrms.mapper.TimesheetMapper;
import com.org.hrms.repository.EmployeeRepository;
import com.org.hrms.repository.TimesheetRepository;
import com.org.hrms.service.TimesheetService;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TimesheetServiceImpl implements TimesheetService {

  @Autowired
  TimesheetRepository timesheetRepository;

  @Autowired
  EmployeeRepository employeeRepository;

  private final TimesheetMapper timesheetMapper = Mappers.getMapper(TimesheetMapper.class);


  @Override
  public SuccessResponse saveTimesheet(TimesheetDto timesheetDto) {
    Employee employee = employeeRepository.findById(timesheetDto.getEmployeeId())
        .orElseThrow(() -> EntityNotFoundException.employee("Employee not found"));

    Optional<Timesheet> existingTimesheet = timesheetRepository.findByEmployeeAndMonth(employee, timesheetDto.getMonth());
    if (existingTimesheet.isPresent()) {
      throw EntityAlreadyExistsException.employee("You already saved the timesheet for this month");
    }

    Timesheet timesheet = new Timesheet();
    timesheet.setEmployee(employee);
    timesheet.setProjectName(timesheetDto.getProjectName());
    timesheet.setMonth(timesheetDto.getMonth());
    timesheet.setBillableHours(timesheetDto.getBillableHours());
    timesheet.setNonBillableHours(timesheetDto.getNonBillableHours());
    timesheet.setLeaves(timesheetDto.getLeaves());
    timesheet.setExtraWorkingDays(timesheetDto.getExtraWorkingDays());
    timesheet.setTotalWorkingDays(timesheetDto.getTotalWorkingDays());
    timesheet.setComments(timesheetDto.getComments());
    timesheetRepository.save(timesheet);
    return SuccessResponse.builder().status(true).message("Timesheet saved successfully").build();
  }


  @Override
  public TimesheetResponse getTimesheetById(Integer id, YearMonth month) {
    Timesheet timesheet = timesheetRepository.findByEmployeeIdAndMonth(id,month);
    return TimesheetResponse.builder().status(true).message("Timesheet Details").data(timesheetMapper.toDto(timesheet)).build();
  }

  @Override
  public MenteesTimesheet getMenteesTimesheet(Integer id) {
    Employee employee = employeeRepository.findById(id)
        .orElseThrow(() -> EntityNotFoundException.employee("Employee not found"));

    List<Employee> mentees = employeeRepository.findByReportingManagerOrReviewingManager(employee.getFirstName(), employee.getLastName());

    List<Integer> menteeIds = mentees.stream()
        .map(Employee::getId)
        .collect(Collectors.toList());

    List<TimesheetDto> timesheetDtos = timesheetRepository.findByEmployeeIdIn(menteeIds)
        .stream()
        .map(timesheetMapper::toDto)
        .collect(Collectors.toList());

    return MenteesTimesheet.builder().status(true).message("Timesheet Details").data(timesheetDtos).build();
  }

}
