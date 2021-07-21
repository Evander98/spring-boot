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
@Table(name = "kelurahan")
@Data
@NoArgsConstructor
public class Kelurahan {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(length = 5, nullable = false, unique = true)
  private String kodeKelurahan;

  @Column(length = 50, nullable = false)
  private String namaKelurahan;

  @ManyToOne
  @JoinColumn(name = "id_kecamatan")
  private Kecamatan kecamatan;

  @Column()
  private boolean isDeleted;

  public Kelurahan(String kodeKelurahan, String namaKelurahan){
    this.kodeKelurahan = kodeKelurahan;
    this.namaKelurahan = namaKelurahan;
  }
}
