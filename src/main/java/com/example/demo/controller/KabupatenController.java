package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.dto.KabupatenDto;
import com.example.demo.model.entity.Kabupaten;
import com.example.demo.model.entity.Provinsi;
import com.example.demo.repository.KabupatenRepository;
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
@RequestMapping("/kab")
public class KabupatenController {
  @Autowired
  private KabupatenRepository kabupatenRepository;

  @Autowired
  private ProvinsiRepository provinsiRepository;

  @GetMapping("/all")
  public ResponseEntity<?> getAllKab(){
    List<Kabupaten> kabupaten = kabupatenRepository.findAllActive();
    return ResponseEntity.ok().body(kabupaten);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getByIdKab(@PathVariable Integer id){
    Kabupaten kabupaten = kabupatenRepository.findById(id).get();
    return ResponseEntity.ok().body(kabupaten);
  }
  
  @GetMapping("/foreign/{id}")
  public ResponseEntity<?> getByForeignId(@PathVariable Integer id){
    Provinsi provinsi = provinsiRepository.findById(id).get();
    List<Kabupaten> kabupaten  = kabupatenRepository.findByProvinsi(provinsi);
    return ResponseEntity.ok().body(kabupaten);
  }

  @PostMapping("/insert")
  public ResponseEntity<?> insertKab(@RequestBody KabupatenDto dto){
    Kabupaten kabupaten = new Kabupaten(dto.getKodeKabupaten(), dto.getNamaKabupaten());
    Provinsi provinsi = provinsiRepository.findByNamaProvinsi(dto.getNamaProvinsi());
    
    kabupaten.setProvinsi(provinsi);

    kabupatenRepository.save(kabupaten);

    return ResponseEntity.ok().body(kabupaten);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<?> updateKab(@RequestBody Kabupaten dto, @PathVariable Integer id){
    Kabupaten kabupaten = kabupatenRepository.findById(id).get();

    kabupaten.setNamaKabupaten(dto.getNamaKabupaten());

    kabupatenRepository.save(kabupaten);
    return ResponseEntity.ok().body(kabupaten);
  }

  @PutMapping("/delete/{id}")
  public ResponseEntity<?> deleteKab(@PathVariable Integer id){
    Kabupaten kabupaten = kabupatenRepository.findById(id).get();

    kabupaten.setDeleted(true);

    kabupatenRepository.save(kabupaten);
    return ResponseEntity.ok().body(kabupaten);
  }

}
