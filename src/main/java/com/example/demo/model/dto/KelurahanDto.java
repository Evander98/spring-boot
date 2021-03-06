package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KelurahanDto {
  private String kodeKelurahan;
  private String namaKelurahan;
  private String namaKecamatan;
}
