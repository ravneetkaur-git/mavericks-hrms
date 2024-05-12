package com.org.hrms.controller;
import com.org.hrms.dto.request.AppraisalRequest;
import com.org.hrms.dto.response.EmployeeResponse;
import com.org.hrms.dto.response.PendingAppraisalResponse;
import com.org.hrms.dto.response.SuccessResponse;
import com.org.hrms.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hrms-user/")
public class EmployeeController {

  @Autowired
  EmpService empService;

  @GetMapping("get-employee-details")
  private ResponseEntity<EmployeeResponse> getEmployee(@RequestParam String token) {
    EmployeeResponse employeeResponse = empService.getEmployeeDetails(token.trim());
    return ResponseEntity.ok(employeeResponse);
  }

  @PostMapping("submit-appraisal")
  private ResponseEntity<SuccessResponse> submitAppraisal(@RequestBody AppraisalRequest appraisalRequest) {
    SuccessResponse successResponse = empService.submitAppraisal(appraisalRequest);
    return ResponseEntity.ok(successResponse);
  }

  @GetMapping("pending-appraisal")
  private ResponseEntity<PendingAppraisalResponse> pendingAppraisal() {
    PendingAppraisalResponse pendingAppraisalResponse = empService.pendingAppraisals();
    return ResponseEntity.ok(pendingAppraisalResponse);
  }

}
