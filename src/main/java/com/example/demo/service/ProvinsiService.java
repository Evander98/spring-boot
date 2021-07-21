package com.example.demo.service;

import com.example.demo.model.dto.ProivinsiDto;
import com.example.demo.model.entity.Provinsi;

import org.springframework.http.ResponseEntity;

public interface ProvinsiService {
  public ResponseEntity<?> insertProv(ProivinsiDto dto);

  public ResponseEntity<?> updateProv(Provinsi dto, Integer id);

  public ResponseEntity<?> deleteProv(Integer id);

}
