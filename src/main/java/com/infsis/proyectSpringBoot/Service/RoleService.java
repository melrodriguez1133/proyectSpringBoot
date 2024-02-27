package com.infsis.proyectSpringBoot.Service;

import com.infsis.proyectSpringBoot.DTOs.RoleDTO;
import com.infsis.proyectSpringBoot.Models.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<RoleDTO> getRoles();
    RoleDTO getRoleById(Integer roleId);

    RoleDTO saveRole(RoleDTO roleDTO);

    RoleDTO updateRole(Integer roleId, RoleDTO roleDTODTO);
    void delete(Integer roleId);

    void deleteRole(Integer roleId);

    Role findById(Integer id);

    List<Role> findAll();

    void save(Role role);

    void deleteById(Integer id);
}