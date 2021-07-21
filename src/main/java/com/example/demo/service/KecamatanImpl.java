package com.example.demo.service;

import com.example.demo.model.dto.KecamatanDto;
import com.example.demo.model.entity.Kabupaten;
import com.example.demo.model.entity.Kecamatan;
import com.example.demo.repository.KabupatenRepository;
import com.example.demo.repository.KecamatanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KecamatanImpl implements KecamatanService {
  @Autowired
  private KecamatanRepository kecamatanRepository;

  @Autowired
  private KabupatenRepository kabupatenRepository;
  @Override
  public ResponseEntity<?> deleteKec(Integer id) {
    Kecamatan kecamatan = kecamatanRepository.findById(id).get();

    kecamatan.setDeleted(true);

    kecamatanRepository.save(kecamatan);
    return ResponseEntity.ok().body(kecamatan);
  }

  @Override
  public ResponseEntity<?> insertKec(KecamatanDto dto) {
    Kecamatan kecamatan = new Kecamatan(dto.getKodeKecamatan(), dto.getNamaKecamatan());
    Kabupaten kabupaten = kabupatenRepository.findByNamaKabupaten(dto.getNamaKabupaten());
    
    kecamatan.setKabupaten(kabupaten);

    kecamatanRepository.save(kecamatan);

    return ResponseEntity.ok().body(kecamatan);
  }

  @Override
  public ResponseEntity<?> updateKec(Kecamatan dto, Integer id) {
    Kecamatan kecamatan = kecamatanRepository.findById(id).get();

    kecamatan.setNamaKecamatan(dto.getNamaKecamatan());

    kecamatanRepository.save(kecamatan);
    return ResponseEntity.ok().body(kecamatan);
  }
  
}
