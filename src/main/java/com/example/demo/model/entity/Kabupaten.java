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
@Table(name = "kabupaten")
@Data
@NoArgsConstructor
public class Kabupaten {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(length = 5, nullable = false, unique = true)
  private String kodeKabupaten;

  @Column(length = 50, nullable = false)
  private String namaKabupaten;

  @ManyToOne
  @JoinColumn(name = "id_provinsi")
  private Provinsi provinsi;

  @Column()
  private boolean isDeleted;


  public Kabupaten(String kodeKabupaten, String namaKabupaten){
    this.kodeKabupaten = kodeKabupaten;
    this.namaKabupaten = namaKabupaten;
  }
}
