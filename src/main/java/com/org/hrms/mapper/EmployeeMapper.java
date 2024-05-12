package com.org.hrms.mapper;
import com.org.hrms.dto.response.EmployeeResponse;
import com.org.hrms.entity.Employee;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {

  EmployeeResponse.EmployeeDto toDto(Employee employee);

  Employee toEntity(EmployeeResponse.EmployeeDto employee);

}
