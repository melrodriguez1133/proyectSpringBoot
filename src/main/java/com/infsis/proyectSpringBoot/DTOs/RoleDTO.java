package com.infsis.proyectSpringBoot.DTOs;

import com.infsis.proyectSpringBoot.Models.Role;

public class RoleDTO {

    private Integer id;
    private String name;

    public RoleDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public RoleDTO(Role role) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}