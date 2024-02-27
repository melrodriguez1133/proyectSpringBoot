package com.infsis.proyectSpringBoot.Service.Implement;

import com.infsis.proyectSpringBoot.DTOs.RoleDTO;
import com.infsis.proyectSpringBoot.Models.Role;
import com.infsis.proyectSpringBoot.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private List<Role> roles = new ArrayList<>();

    public List<RoleDTO> getRoles() {
        List<RoleDTO> roleDTOs = new ArrayList<>();
        for (Role role : roles) {
            roleDTOs.add(new RoleDTO(role));
        }
        return roleDTOs;
    }

    public RoleDTO getRoleById(Integer roleId) {
        Role role = findRoleById(roleId);
        if (role == null) {
            return null;
        }
        return new RoleDTO(role);
    }

    public RoleDTO saveRole(RoleDTO roleDTO) {
        Role role = new Role(roleDTO.getName());
        roles.add(role);
        return new RoleDTO(role);
    }

    public RoleDTO updateRole(Integer roleId, RoleDTO roleDTO) {
        Role role = findRoleById(roleId);
        if (role == null) {
            return null;
        }
        role.setName(roleDTO.getName());
        // Update other role fields if needed
        return new RoleDTO(role);
    }

    @Override
    public void delete(Integer roleId) {

    }

    public void deleteRole(Integer roleId) {
        Role role = findRoleById(roleId);
        if (role != null) {
            roles.remove(role);
        }
    }

    @Override
    public Role findById(Integer id) {
        return null;
    }

    @Override
    public List<Role> findAll() {
        return null;
    }

    @Override
    public void save(Role role) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    private Role findRoleById(Integer roleId) {
        for (Role role : roles) {
            if (role.getId().equals(roleId)) {
                return role;
            }
        }
        return null;
    }
}