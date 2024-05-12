package com.org.hrms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.webresources.CachedResource;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private Integer employee;
  private Integer rating;
  private String comment;
  private String givenBy;
  @ManyToOne
  @JoinColumn(name = "criteria_id")
  private Criteria criteria;
}
