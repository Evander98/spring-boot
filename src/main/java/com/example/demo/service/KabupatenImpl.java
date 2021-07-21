package com.example.demo.service;

import com.example.demo.model.dto.KabupatenDto;
import com.example.demo.model.entity.Kabupaten;
import com.example.demo.model.entity.Provinsi;
import com.example.demo.repository.KabupatenRepository;
import com.example.demo.repository.ProvinsiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KabupatenImpl implements KabupatenService {
  @Autowired
  private KabupatenRepository kabupatenRepository;

  @Autowired
  private ProvinsiRepository provinsiRepository;

  @Override
  public ResponseEntity<?> deleteKab(Integer id) {
    Kabupaten kabupaten = kabupatenRepository.findById(id).get();

    kabupaten.setDeleted(true);

    kabupatenRepository.save(kabupaten);
    return ResponseEntity.ok().body(kabupaten);
  }

  @Override
  public ResponseEntity<?> insertKab(KabupatenDto dto) {
    Kabupaten kabupaten = new Kabupaten(dto.getKodeKabupaten(), dto.getNamaKabupaten());
    Provinsi provinsi = provinsiRepository.findByNamaProvinsi(dto.getNamaProvinsi());
    
    kabupaten.setProvinsi(provinsi);

    kabupatenRepository.save(kabupaten);

    return ResponseEntity.ok().body(kabupaten);
  }

  @Override
  public ResponseEntity<?> updateKab(Kabupaten dto, Integer id) {
    Kabupaten kabupaten = kabupatenRepository.findById(id).get();

    kabupaten.setNamaKabupaten(dto.getNamaKabupaten());

    kabupatenRepository.save(kabupaten);
    return ResponseEntity.ok().body(kabupaten);
  }
  
}
