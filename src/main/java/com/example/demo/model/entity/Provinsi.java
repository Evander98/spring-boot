package com.example.demo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "provinsi")
@Data
@NoArgsConstructor
public class Provinsi {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(length = 5, unique = true, nullable = false)
  private String kodeProvinsi;

  @Column(length = 50, nullable = false)
  private String namaProvinsi;

  @Column()
  private boolean isDeleted;

  public Provinsi(String kodeProvinsi, String namaProvinsi){
    this.kodeProvinsi = kodeProvinsi;
    this.namaProvinsi = namaProvinsi;
  }
}
