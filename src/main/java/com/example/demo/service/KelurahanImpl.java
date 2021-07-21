package com.example.demo.service;

import com.example.demo.model.dto.KelurahanDto;
import com.example.demo.model.entity.Kecamatan;
import com.example.demo.model.entity.Kelurahan;
import com.example.demo.repository.KecamatanRepository;
import com.example.demo.repository.KelurahanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KelurahanImpl implements KelurahanService {
  @Autowired
  private KelurahanRepository kelurahanRepository;

  @Autowired
  private KecamatanRepository kecamatanRepository;

  @Override
  public ResponseEntity<?> deleteKel(Integer id) {
    Kelurahan kelurahan = kelurahanRepository.findById(id).get();

    kelurahan.setDeleted(true);

    kelurahanRepository.save(kelurahan);
    return ResponseEntity.ok().body(kelurahan);
  }

  @Override
  public ResponseEntity<?> insertKel(KelurahanDto dto) {
    Kelurahan kelurahan = new Kelurahan(dto.getKodeKelurahan(), dto.getNamaKelurahan());
    Kecamatan kecamatan = kecamatanRepository.findByNamaKecamatan(dto.getNamaKecamatan());
    
    kelurahan.setKecamatan(kecamatan);

    kelurahanRepository.save(kelurahan);

    return ResponseEntity.ok().body(kelurahan);
  }

  @Override
  public ResponseEntity<?> updateKel(Kelurahan dto, Integer id) {
    Kelurahan kelurahan = kelurahanRepository.findById(id).get();

    kelurahan.setNamaKelurahan(dto.getNamaKelurahan());

    kelurahanRepository.save(kelurahan);
    return ResponseEntity.ok().body(kelurahan);
  }
  
}
