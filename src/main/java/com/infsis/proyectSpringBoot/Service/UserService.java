package com.infsis.proyectSpringBoot.Service;

import com.infsis.proyectSpringBoot.DTOs.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDTO> getUsers();
    UserDTO getUserById(Integer userId);

    UserDTO saveUser(UserDTO userDTO);

    UserDTO updateUser(Integer userId, UserDTO userDTO);
    void delete(Integer userId);
}
