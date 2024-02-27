package com.infsis.proyectSpringBoot.Controllers;


import com.infsis.proyectSpringBoot.DTOs.RoleDTO;
import com.infsis.proyectSpringBoot.Models.Role;
import com.infsis.proyectSpringBoot.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping()
    public ResponseEntity<List<RoleDTO>> getRoles() {
        List<Role> roles = roleService.findAll();
        List<RoleDTO> roleDTOs = new ArrayList<>();
        for (Role role : roles) {
            roleDTOs.add(new RoleDTO(role));
        }
        return ResponseEntity.ok().body(roleDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> getRole(@PathVariable Integer id) {
        Role role = roleService.findById(id);
        if (role == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(new RoleDTO(role));
    }

    @PostMapping()
    public ResponseEntity<RoleDTO> saveRole(@RequestBody RoleDTO roleDTO) {
        Role role = new Role(roleDTO.getName());
        roleService.save(role);
        return ResponseEntity.ok().body(new RoleDTO(role));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDTO> updateRole(@PathVariable Integer id, @RequestBody RoleDTO roleDTO) {
        Role existingRole = roleService.findById(id);
        if (existingRole == null) {
            return ResponseEntity.notFound().build();
        }
        existingRole.setName(roleDTO.getName());
        roleService.save(existingRole);
        return ResponseEntity.ok().body(new RoleDTO(existingRole));
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Integer id) {
        roleService.deleteById(id);
    }
}