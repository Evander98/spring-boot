package com.example.demo.service;

import com.example.demo.model.dto.ProivinsiDto;
import com.example.demo.model.entity.Provinsi;
import com.example.demo.repository.ProvinsiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProvinsiImpl implements ProvinsiService {
  @Autowired
  private ProvinsiRepository provinsiRepository;

  @Override
  public ResponseEntity<?> insertProv(ProivinsiDto dto) {
    Provinsi provinsi = new Provinsi(dto.getKodeProvinsi(), dto.getNamaProvinsi());

    provinsiRepository.save(provinsi);
    return ResponseEntity.ok().body(provinsi);
  }

  @Override
  public ResponseEntity<?> deleteProv(Integer id) {
    Provinsi provinsi = provinsiRepository.findById(id).get();

    provinsi.setDeleted(true);

    provinsiRepository.save(provinsi);
    return ResponseEntity.ok().body(provinsi);
  }

  @Override
  public ResponseEntity<?> updateProv(Provinsi dto, Integer id) {
    Provinsi provinsi = provinsiRepository.findById(id).get();

    provinsi.setNamaProvinsi(dto.getNamaProvinsi());

    provinsiRepository.save(provinsi);
    return ResponseEntity.ok().body(provinsi);
  }
}
