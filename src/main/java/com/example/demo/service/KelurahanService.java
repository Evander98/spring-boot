package com.example.demo.service;

import com.example.demo.model.dto.KelurahanDto;
import com.example.demo.model.entity.Kelurahan;

import org.springframework.http.ResponseEntity;

public interface KelurahanService {
  public ResponseEntity<?> insertKel(KelurahanDto dto);

  public ResponseEntity<?> updateKel(Kelurahan dto, Integer id);

  public ResponseEntity<?> deleteKel(Integer id);
}
