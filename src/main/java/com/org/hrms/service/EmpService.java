package com.org.hrms.service;

import com.org.hrms.dto.request.AppraisalRequest;
import com.org.hrms.dto.response.EmployeeResponse;
import com.org.hrms.dto.response.PendingAppraisalResponse;
import com.org.hrms.dto.response.SuccessResponse;

public interface EmpService {

  EmployeeResponse getEmployeeDetails(String token);

  SuccessResponse submitAppraisal(AppraisalRequest appraisalRequest);

  PendingAppraisalResponse pendingAppraisals();
}
