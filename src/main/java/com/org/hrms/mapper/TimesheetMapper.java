package com.org.hrms.mapper;

import com.org.hrms.dto.TimesheetDto;
import com.org.hrms.dto.response.TimesheetResponse;
import com.org.hrms.entity.Timesheet;
import org.mapstruct.Mapper;

@Mapper
public interface TimesheetMapper {
  TimesheetDto toDto(Timesheet timesheet);

  Timesheet toEntity(TimesheetDto timesheetDto);
}
