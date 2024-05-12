package com.org.hrms.dto.response;


import com.org.hrms.utils.AppraisalStatusEnum;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PendingAppraisalResponse {
  private Boolean status;
  private String message;
  private List<PendingAppraisal> pendingAppraisalList;

  @Getter
  @Setter
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class PendingAppraisal{
    private Integer id;
    private Integer employeeId;
    private int appraisalCycle;
    private AppraisalStatusEnum status;
  }
}
