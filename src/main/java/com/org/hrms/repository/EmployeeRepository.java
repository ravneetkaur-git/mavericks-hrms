package com.org.hrms.repository;

import com.org.hrms.entity.Employee;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
  Optional<Employee> findByEmail(String email);

  List<Employee> findByReportingManagerOrReviewingManager(String firstName, String lastName);

}
