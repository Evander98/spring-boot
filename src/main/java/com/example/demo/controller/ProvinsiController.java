package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.dto.ProivinsiDto;
import com.example.demo.model.entity.Provinsi;
import com.example.demo.repository.ProvinsiRepository;
import com.example.demo.service.ProvinsiImpl;

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

  @Autowired
  private ProvinsiImpl provinsiImpl;

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
    return provinsiImpl.insertProv(dto);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<?> updateProv(@RequestBody Provinsi dto, @PathVariable Integer id){
    return provinsiImpl.updateProv(dto, id);
  }

  @PutMapping("/delete/{id}")
  public ResponseEntity<?> deleteProv(@PathVariable Integer id){
    return provinsiImpl.deleteProv(id);
  }

}
