package com.org.hrms.service.impl;
import com.org.hrms.dto.request.AppraisalRequest;
import com.org.hrms.dto.response.EmployeeResponse;
import com.org.hrms.dto.response.PendingAppraisalResponse;
import com.org.hrms.dto.response.SuccessResponse;
import com.org.hrms.entity.Appraisal;
import com.org.hrms.entity.Criteria;
import com.org.hrms.entity.Employee;
import com.org.hrms.entity.Feedback;
import com.org.hrms.exception.EntityNotFoundException;
import com.org.hrms.mapper.EmployeeMapper;
import com.org.hrms.repository.AppraisalRepository;
import com.org.hrms.repository.CriteriaRepository;
import com.org.hrms.repository.EmployeeRepository;
import com.org.hrms.repository.FeedbackRepository;
import com.org.hrms.service.EmpService;
import com.org.hrms.service.JwtService;
import com.org.hrms.utils.AppraisalStatusEnum;
import jakarta.transaction.Transactional;
import java.util.List;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmpService {

  @Autowired
  EmployeeRepository employeeRepository;

  @Autowired
  CriteriaRepository criteriaRepository;

  @Autowired
  FeedbackRepository feedbackRepository;


  @Autowired
  AppraisalRepository appraisalRepository;

  @Autowired
  private JwtService jwtService;

  private final EmployeeMapper employeeMapper = Mappers.getMapper(EmployeeMapper.class);

  @Override
  public EmployeeResponse getEmployeeDetails(String token) {
    String email = jwtService.extractUsername(token);
    Employee employee = employeeRepository.findByEmail(email).orElseThrow(
        () -> EntityNotFoundException.employee("Employee with email " + email + " not found")
        );
    return EmployeeResponse.builder().status(true).message("Employee Details").data(employeeMapper.toDto(employee)).build();
  }

  @Override
  @Transactional
  public SuccessResponse submitAppraisal(AppraisalRequest appraisalRequest){
    Employee employee = employeeRepository.findById(appraisalRequest.getEmployeeId())
        .orElseThrow(() -> EntityNotFoundException.employee("Employee not found"));
    Criteria criteria = new Criteria();
    criteria.setCriteriaName(appraisalRequest.getCriteriaName());
    criteriaRepository.save(criteria);

    Feedback feedback = new Feedback();
    feedback.setRating(appraisalRequest.getRating());
    feedback.setComment(appraisalRequest.getComment());
    feedback.setGivenBy(appraisalRequest.getGivenBy());
    feedback.setCriteria(criteria);
    feedback.setEmployee(appraisalRequest.getEmployeeId());
    feedbackRepository.save(feedback);

    Appraisal appraisal = new Appraisal();
    appraisal.setEmployeeId(appraisalRequest.getEmployeeId());
    appraisal.setAppraisalCycle(appraisalRequest.getAppraisalCycle());
    appraisal.setStatus(AppraisalStatusEnum.SUBMITTED);
    appraisalRepository.save(appraisal);

    return SuccessResponse.builder().status(true).message("Appraisal Form Submitted Successfully").build();

  }

  @Override
  public PendingAppraisalResponse pendingAppraisals(){
    List<PendingAppraisalResponse.PendingAppraisal> pendingAppraisals = appraisalRepository.findByStatus(AppraisalStatusEnum.PENDING);
    return PendingAppraisalResponse.builder().status(true).message("Pending Appraisals").pendingAppraisalList(pendingAppraisals).build();

  }


}
