package com.infsis.proyectSpringBoot.Controllers;

import com.infsis.proyectSpringBoot.DTOs.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping()
    public ResponseEntity<
            List<UserDTO>> getUsers(){
        UserDTO userDTO=new UserDTO(1,"users","users@users");

        return ResponseEntity.ok().body(Collections.emptyList());

    }

    @GetMapping("/{id}")
    public  ResponseEntity<UserDTO> getUser(@PathVariable Integer id){
        UserDTO userDTO=new UserDTO(1,"user","user@user");
        return ResponseEntity.ok().body(userDTO);
    }

    @PostMapping()
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok().body(userDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Integer id,@RequestBody UserDTO userDTO){

        return ResponseEntity.ok().body(userDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){

    }

}