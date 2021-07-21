package com.example.demo.service;

import com.example.demo.model.dto.KecamatanDto;
import com.example.demo.model.entity.Kecamatan;

import org.springframework.http.ResponseEntity;

public interface KecamatanService {
  public ResponseEntity<?> insertKec(KecamatanDto dto);

  public ResponseEntity<?> updateKec(Kecamatan dto, Integer id);

  public ResponseEntity<?> deleteKec(Integer id);
}
