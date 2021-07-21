package com.example.demo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "education")
@Data
@NoArgsConstructor
public class Education {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(length = 10)
  private String educationCode;

  @Column()
  private String schoolName;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserEntity user;

  public Education(String educationCode, String schoolName){
    this.educationCode = educationCode;
    this.schoolName = schoolName;
  }
}
