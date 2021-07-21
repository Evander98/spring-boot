package com.example.demo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user")
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(length = 20, nullable = false, unique = true)
  private String username;

  @Column(nullable = false, unique = true)
  private String password;

  @Column()
  private boolean isDeleted = false;


  // @Column(length = 50, nullable = false)
  // private String firstName;

  // @Column(length = 50, nullable = false)
  // private String lastName;

  // @Column(length = 16, nullable = false, unique = true)
  // private String nik;

  // @Column(nullable = false, unique = true)
  // private String password;

  // public UserEntity(){
  // }

  public UserEntity(String username, String password){
    // this.firstName = firstName;
    // this.lastName = lastNamen;
    // this.nik = nik;
    this.username = username;
    this.password = password;
  }

  // public Integer getId(){
  //   return id;
  // }

  // public String getFirstName() {
  //   return firstName;
  // }

  // public void setFirstName(String firstName) {
  //   this.firstName = firstName;
  // }

  // public String getLastName() {
  //   return lastName;
  // }

  // public void setLastName(String lastName) {
  //   this.lastName = lastName;
  // }

  // public String getNik() {
  //   return nik;
  // }

  // public void setNik(String nik) {
  //   this.nik = nik;
  // }

  // public String getPassword(){
  //   return password;
  // }

  // public void setPassword(String password){
  //   this.password = password;
  // }

}
