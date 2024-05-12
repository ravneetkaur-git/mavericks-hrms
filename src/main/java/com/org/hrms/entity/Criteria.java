package com.org.hrms.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
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
public class Criteria {
  @Id
  @GeneratedValue(strategy =  GenerationType.AUTO)
  private Integer id;
  private String criteriaName;
  @OneToMany(mappedBy = "criteria")
  private List<Feedback> feedbacks;
}
