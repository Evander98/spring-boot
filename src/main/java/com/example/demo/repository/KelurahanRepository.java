package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.entity.Kecamatan;
import com.example.demo.model.entity.Kelurahan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KelurahanRepository extends JpaRepository<Kelurahan, Integer> {
  @Query(value = "select * from kelurahan where is_deleted = 0", nativeQuery = true)
  List<Kelurahan> findAllActive();

  List<Kelurahan> findByKecamatan(Kecamatan kecamatan);
}
