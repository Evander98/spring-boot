package com.example.demo.service;


import java.util.List;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.UserEntity;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;

  @Override
  public ResponseEntity<?> deleteUser(Integer id) {
    // TODO Auto-generated method stub
    UserEntity userEntity = userRepository.findById(id).get();
    userRepository.delete(userEntity);
    return ResponseEntity.ok().body("user berhasil dihapus!");
  }

  @Override
  public ResponseEntity<?> getById(Integer id) {
    // TODO Auto-generated method stub
    if(userRepository.findById(id).isPresent()){
      UserEntity userEntity = userRepository.findById(id).get();
      return ResponseEntity.ok().body(userEntity);
    }
    return ResponseEntity.badRequest().body("id tidak ditemukan.");
  }

  @Override
  public List<UserEntity> getUsers() {
    // TODO Auto-generated method stub
    List<UserEntity> users = userRepository.findAll();
    return users;
  }

  @Override
  public UserEntity insertUser(UserDto dto) {
    // TODO Auto-generated method stub
    // UserEntity userEntity = new UserEntity(dto.getfName(), dto.getlName(), dto.getNik());
    // if(dto.getNik() == userEntity.getNik()) {

    // }
    // userEntity.setPassword(dto.getPassword());
    // userRepository.save(userEntity);
    // return userEntity;
    return null;
  }

  // @Override
  // public ResponseEntity<?> getByLastName(String lName) {
    // TODO Auto-generated method stub
    // List<UserEntity> userEntities = userRepository.findByLastNameIgnoreCase(lName);
    // return ResponseEntity.ok().body(userEntities);
  // }

  @Override
  public ResponseEntity<?> updateUser(UserDto dto, Integer id) {
    // TODO Auto-generated method stub
    // UserEntity userEntity = userRepository.findById(id).get();
    // userEntity.setFirstName(dto.getfName());
    // userEntity.setLastName(dto.getlName());
    // userRepository.save(userEntity);
    // return ResponseEntity.ok().body(userEntity);
    return ResponseEntity.ok().body("");
  }

  
}
