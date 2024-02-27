package com.infsis.proyectSpringBoot.DTOs;

import com.infsis.proyectSpringBoot.Models.Blog;

import java.time.LocalDateTime;

public class BlogDTO {

    private Integer id;
    private String name;

    // Add other relevant fields here, such as:
    // - List<ArticleDTO> articles;
    // - UserDTO user;
    // - LocalDateTime createdAt;

    public BlogDTO() {
    }

    public BlogDTO(Blog blog) {
        this.id = blog.getId();
        this.name = blog.getName();

        // Add logic to map other fields from Blog to BlogDTO here.
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