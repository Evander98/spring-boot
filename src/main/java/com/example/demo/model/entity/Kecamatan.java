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
@Table(name = "kecamatan")
@Data
@NoArgsConstructor
public class Kecamatan {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(length = 5, nullable = false, unique = true)
  private String kodeKecamatan;

  @Column(length = 50, nullable = false)
  private String namaKecamatan;

  @ManyToOne
  @JoinColumn(name = "id_kabupaten")
  private Kabupaten kabupaten;

  @Column()
  private boolean isDeleted;

  public Kecamatan(String kodeKecamatan, String namaKecamatan){
    this.kodeKecamatan = kodeKecamatan;
    this.namaKecamatan = namaKecamatan;
  }
}
