package com.example.demo.repository;

// import java.util.List;

import com.example.demo.model.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
  // @Query(value = "select first_name from user_entity", nativeQuery = true)
  // public List<String> getFirstName();

  // public List<String> findByFirstNameAndLastName(String firstName, String lastName);

  // public List<UserEntity> findByLastNameIgnoreCase(String lastName);

  UserEntity findByUsername(String username);
}
