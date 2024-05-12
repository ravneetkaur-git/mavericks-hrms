package com.org.hrms.repository;

import com.org.hrms.entity.Employee;
import com.org.hrms.entity.Timesheet;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimesheetRepository extends JpaRepository<Timesheet, Integer> {
  List<Timesheet> findByEmployeeIdIn(List<Integer> employeeIds);
}
