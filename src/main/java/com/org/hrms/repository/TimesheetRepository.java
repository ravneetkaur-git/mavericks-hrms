package com.org.hrms.repository;

import com.org.hrms.entity.Employee;
import com.org.hrms.entity.Timesheet;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimesheetRepository extends JpaRepository<Timesheet, Integer> {
  List<Timesheet> findByEmployeeIdIn(List<Integer> employeeIds);

  Timesheet   findByEmployeeIdAndMonth(Integer employeeId,YearMonth month);

  Optional<Timesheet> findByEmployeeAndMonth(Employee employee, YearMonth month);

}
