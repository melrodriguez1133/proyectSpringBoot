package com.infsis.proyectSpringBoot.Controllers;

import com.infsis.proyectSpringBoot.DTOs.ArticleDTO;
import com.infsis.proyectSpringBoot.Models.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/articles")
public class ArticleController {

    private ArticleService articleService; // Inject the ArticleService

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public ResponseEntity<List<ArticleDTO>> getArticles() {
        List<ArticleDTO> articleDTOs = articleService.getArticles();
        return ResponseEntity.ok().body(articleDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDTO> getArticle(@PathVariable Integer id) {
        ArticleDTO articleDTO = articleService.getArticleById(id);
        if (articleDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(articleDTO);
    }

    @PostMapping
    public ResponseEntity<ArticleDTO> saveArticle(@RequestBody ArticleDTO articleDTO) {
        ArticleDTO savedArticleDTO = articleService.saveArticle(articleDTO);
        return ResponseEntity.ok().body(savedArticleDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleDTO> updateArticle(@PathVariable Integer id, @RequestBody ArticleDTO articleDTO) {
        articleDTO.setId(id); // Set the id for update operation
        ArticleDTO updatedArticleDTO = articleService.updateArticle(id, articleDTO);
        if (updatedArticleDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(updatedArticleDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Integer id) {
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }
}
