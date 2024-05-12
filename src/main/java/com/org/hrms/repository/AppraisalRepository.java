package com.org.hrms.repository;

import com.org.hrms.dto.response.PendingAppraisalResponse;
import com.org.hrms.entity.Appraisal;
import com.org.hrms.entity.Criteria;
import com.org.hrms.utils.AppraisalStatusEnum;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppraisalRepository extends JpaRepository<Appraisal, Integer> {
  List<PendingAppraisalResponse.PendingAppraisal> findByStatus(AppraisalStatusEnum status);

}
