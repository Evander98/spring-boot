package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.dto.KelurahanDto;
import com.example.demo.model.entity.Kecamatan;
import com.example.demo.model.entity.Kelurahan;
import com.example.demo.repository.KecamatanRepository;
import com.example.demo.repository.KelurahanRepository;
import com.example.demo.service.KelurahanImpl;

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
@RequestMapping("/kel")
public class KelurahanController {
  @Autowired
  private KelurahanRepository kelurahanRepository;

  @Autowired
  private KecamatanRepository kecamatanRepository;

  @Autowired
  private KelurahanImpl kelurahanImpl;

  @GetMapping("/all")
  public ResponseEntity<?> getAllKel(){
    List<Kelurahan> kelurahan = kelurahanRepository.findAllActive();
    return ResponseEntity.ok().body(kelurahan);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getByIdKel(@PathVariable Integer id){
    Kelurahan kelurahan = kelurahanRepository.findById(id).get();
    return ResponseEntity.ok().body(kelurahan);
  }
  
  @GetMapping("/foreign/{id}")
  public ResponseEntity<?> getByForeignId(@PathVariable Integer id){
    Kecamatan kecamatan = kecamatanRepository.findById(id).get();
    List<Kelurahan> kelurahan  = kelurahanRepository.findByKecamatan(kecamatan);
    return ResponseEntity.ok().body(kelurahan);
  }

  @PostMapping("/insert")
  public ResponseEntity<?> insertKel(@RequestBody KelurahanDto dto){
    return kelurahanImpl.insertKel(dto);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<?> updateKel(@RequestBody Kelurahan dto, @PathVariable Integer id){
    return kelurahanImpl.updateKel(dto, id);
  }

  @PutMapping("/delete/{id}")
  public ResponseEntity<?> deleteKel(@PathVariable Integer id){
    return kelurahanImpl.deleteKel(id);
  }

}
