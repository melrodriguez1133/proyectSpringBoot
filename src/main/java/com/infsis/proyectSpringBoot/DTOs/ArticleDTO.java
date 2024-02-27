package com.infsis.proyectSpringBoot.DTOs;

import com.infsis.proyectSpringBoot.Models.Article;

import java.time.LocalDateTime;

public class ArticleDTO {
    private Integer id;
    private String title;
    private String reference;
    private LocalDateTime createdAt;

    public ArticleDTO(Integer id, String title, String reference) {
        this.id = id;
        this.title = title;
        this.reference = reference;
        this.createdAt = createdAt;
    }

    public ArticleDTO(Article article) {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Object getContent() {
    }
}
