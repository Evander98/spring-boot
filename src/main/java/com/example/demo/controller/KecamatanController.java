package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.dto.KecamatanDto;
import com.example.demo.model.entity.Kabupaten;
import com.example.demo.model.entity.Kecamatan;
import com.example.demo.repository.KabupatenRepository;
import com.example.demo.repository.KecamatanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kec")
public class KecamatanController {
  @Autowired
  private KecamatanRepository kecamatanRepository;

  @Autowired
  private KabupatenRepository kabupatenRepository;

  @GetMapping("/all")
  public ResponseEntity<?> getAllKec(){
    List<Kecamatan> kecamatan = kecamatanRepository.findAllActive();
    return ResponseEntity.ok().body(kecamatan);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getByIdKec(@PathVariable Integer id){
    Kecamatan kecamatan = kecamatanRepository.findById(id).get();
    return ResponseEntity.ok().body(kecamatan);
  }
  
  @GetMapping("/foreign/{id}")
  public ResponseEntity<?> getByForeignId(@PathVariable Integer id){
    Kabupaten kabupaten = kabupatenRepository.findById(id).get();
    List<Kecamatan> kecamatan  = kecamatanRepository.findByKabupaten(kabupaten);
    return ResponseEntity.ok().body(kecamatan);
  }

  @PostMapping("/insert")
  public ResponseEntity<?> insertKec(@RequestBody KecamatanDto dto){
    Kecamatan kecamatan = new Kecamatan(dto.getKodeKecamatan(), dto.getNamaKecamatan());
    Kabupaten kabupaten = kabupatenRepository.findByNamaKabupaten(dto.getNamaKabupaten());
    
    kecamatan.setKabupaten(kabupaten);

    kecamatanRepository.save(kecamatan);

    return ResponseEntity.ok().body(kecamatan);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<?> updateKec(@RequestBody Kecamatan dto, @PathVariable Integer id){
    Kecamatan kecamatan = kecamatanRepository.findById(id).get();

    kecamatan.setNamaKecamatan(dto.getNamaKecamatan());

    kecamatanRepository.save(kecamatan);
    return ResponseEntity.ok().body(kecamatan);
  }

  @PutMapping("/delete/{id}")
  public ResponseEntity<?> deleteKec(@PathVariable Integer id){
    Kecamatan kecamatan = kecamatanRepository.findById(id).get();

    kecamatan.setDeleted(true);

    kecamatanRepository.save(kecamatan);
    return ResponseEntity.ok().body(kecamatan);
  }
}
