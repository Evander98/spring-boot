package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.entity.Kabupaten;
import com.example.demo.model.entity.Kecamatan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KecamatanRepository extends JpaRepository<Kecamatan, Integer> {
  @Query(value = "select * from kecamatan where is_deleted = 0", nativeQuery = true)
  List<Kecamatan> findAllActive();

  List<Kecamatan> findByKabupaten(Kabupaten kabupaten);

  Kecamatan findByNamaKecamatan(String namaKecamatan);
  
}
