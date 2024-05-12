package com.org.hrms.entity;
import com.org.hrms.utils.AppraisalStatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appraisal {
  @Id
  @GeneratedValue(strategy =  GenerationType.AUTO)
  private Integer id;
  private Integer employeeId;
  private int appraisalCycle;
  @Enumerated(EnumType.STRING)
  private AppraisalStatusEnum status = AppraisalStatusEnum.PENDING;
}
