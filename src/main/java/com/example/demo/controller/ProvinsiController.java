package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.dto.ProivinsiDto;
import com.example.demo.model.entity.Provinsi;
import com.example.demo.repository.ProvinsiRepository;

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
@RequestMapping("/prov")
public class ProvinsiController {
  @Autowired
  private ProvinsiRepository provinsiRepository;

  @GetMapping("/all")
  public ResponseEntity<?> getAllProv(){
    List<Provinsi> provinsi = provinsiRepository.findAllActive();
    return ResponseEntity.ok().body(provinsi);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getByIdProv(@PathVariable Integer id){
    Provinsi provinsi = provinsiRepository.findById(id).get();
    return ResponseEntity.ok().body(provinsi);
  }

  @PostMapping("/insert")
  public ResponseEntity<?> insertProv(@RequestBody ProivinsiDto dto){
    Provinsi provinsi = new Provinsi(dto.getKodeProvinsi(), dto.getNamaProvinsi());

    provinsiRepository.save(provinsi);

    return ResponseEntity.ok().body(provinsi);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<?> updateProv(@RequestBody Provinsi dto, @PathVariable Integer id){
    Provinsi provinsi = provinsiRepository.findById(id).get();

    provinsi.setNamaProvinsi(dto.getNamaProvinsi());

    provinsiRepository.save(provinsi);
    return ResponseEntity.ok().body(provinsi);
  }

  @PutMapping("/delete/{id}")
  public ResponseEntity<?> deleteProv(@PathVariable Integer id){
    Provinsi provinsi = provinsiRepository.findById(id).get();

    provinsi.setDeleted(true);

    provinsiRepository.save(provinsi);
    return ResponseEntity.ok().body(provinsi);
  }

}
