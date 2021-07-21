package com.example.demo.service;

import com.example.demo.model.dto.KabupatenDto;
import com.example.demo.model.entity.Kabupaten;

import org.springframework.http.ResponseEntity;

public interface KabupatenService {
  public ResponseEntity<?> insertKab(KabupatenDto dto);

  public ResponseEntity<?> updateKab(Kabupaten dto,Integer id);

  public ResponseEntity<?> deleteKab(Integer id);
}
