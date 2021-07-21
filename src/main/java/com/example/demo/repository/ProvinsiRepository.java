package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.entity.Provinsi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinsiRepository extends JpaRepository<Provinsi, Integer> {
  @Query(value = "select * from provinsi where is_deleted = 0", nativeQuery = true)
  List<Provinsi> findAllActive();

  Provinsi findByNamaProvinsi(String namaProvinsi);
}
