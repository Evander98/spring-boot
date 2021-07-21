package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.entity.Kabupaten;
import com.example.demo.model.entity.Provinsi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KabupatenRepository extends JpaRepository<Kabupaten, Integer> {
  @Query(value = "select * from kabupaten where is_deleted = 0", nativeQuery = true)
  List<Kabupaten> findAllActive();

  List<Kabupaten> findByProvinsi(Provinsi provinsi);

  Kabupaten findByNamaKabupaten(String namaKabupaten);
}
