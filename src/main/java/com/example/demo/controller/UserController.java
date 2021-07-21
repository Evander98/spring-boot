package com.example.demo.controller;


// import com.example.demo.model.dto.UserDto;
// import com.example.demo.service.UserServiceImpl;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
  // @Autowired
  // private UserServiceImpl userService;

  // @GetMapping("/all")
  // public ResponseEntity<?> getUsers(){
  //   try{
  //     // List<UserEntity> users = userService.findAll();
  //     return ResponseEntity.ok().body(userService.getUsers());
  //     // return ResponseEntity.ok().body(users);
  //   }catch(Exception e){
  //     return ResponseEntity.badRequest().body(e);
  //   }
  // }

  // @PostMapping("/insert")
  // public ResponseEntity<?> insertUser(@RequestBody UserDto dto){
  //   // UserEntity userEntity = new UserEntity(dto.getfName(), dto.getlName(),
  //   // dto.getNik());
  //   // if (dto.getNik() == userEntity.getNik()) {
  //   // // nik sama ulangi nik
  //   // }
  //   // userEntity.setPassword(dto.getPassword());

  //   // userRepository.save(userEntity);
  //   return ResponseEntity.ok().body(userService.insertUser(dto));
  // }

  // // Find by id
  // @GetMapping("/{id}")
  // public ResponseEntity<?> getById(@PathVariable Integer id) {
  //   // if (userRepository.findById(id).isPresent()) {
  //   // UserEntity userEntity = userRepository.findById(id).get();
  //   // return ResponseEntity.ok().body(userEntity);
  //   // }
  //   // return ResponseEntity.badRequest().body("id tidak ditemukan.");
  //   return userService.getById(id);
  // }

  // // Find by name
  // @GetMapping("/test")
  // public ResponseEntity<?> getByLastName(@RequestParam String dto) {
  //   return userService.getByLastName(dto);
  // }

  // // Update user
  // @PutMapping("/update/{id}")
  // public ResponseEntity<?> updateUser(@RequestBody UserDto dto, @PathVariable Integer id) {
  //   // UserEntity userEntity = userRepository.findById(id).get();
  //   // userEntity.setFirstName(dto.getfName());
  //   // userEntity.setLastName(dto.getlName());
  //   // userRepository.save(userEntity);
  //   // return ResponseEntity.ok().body(userEntity);
  //   return userService.updateUser(dto, id);
  // }

  // // Delete user
  // @DeleteMapping("/delete/{id}")
  // public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
  //   // UserEntity userEntity = userRepository.findById(id).get();
  //   // userRepository.delete(userEntity);
  //   // return ResponseEntity.ok().body("user berhasil dihapus!");
  //   return userService.deleteUser(id);
  // }
}
