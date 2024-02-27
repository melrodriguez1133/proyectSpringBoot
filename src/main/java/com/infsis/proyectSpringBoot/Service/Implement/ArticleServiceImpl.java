package com.infsis.proyectSpringBoot.Service.Implement;

import com.infsis.proyectSpringBoot.DTOs.ArticleDTO;
import com.infsis.proyectSpringBoot.Models.Article;
import com.infsis.proyectSpringBoot.Repositories.ArticleRepository;
import com.infsis.proyectSpringBoot.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    private List<Article> articles = new ArrayList<>();

    public List<ArticleDTO> getArticles() {
        List<ArticleDTO> articleDTOs = new ArrayList<>();
        for (Article article : articles) {
            articleDTOs.add(new ArticleDTO(article));
        }
        return articleDTOs;
    }

    public ArticleDTO getArticleById(Integer articleId) {
        Article article = findArticleById(articleId);
        if (article == null) {
            return null;
        }
        return new ArticleDTO(article);
    }

    private Article findArticleById(Integer articleId) {
    }

    public ArticleDTO saveArticle(ArticleDTO articleDTO) {
        Article article = new Article(articleDTO.getTitle(), articleDTO.getContent());
        articles.add(article);
        return new ArticleDTO(article);
    }

    public ArticleDTO updateArticle(Integer articleId, ArticleDTO articleDTO) {
        Article article = findArticleById(articleId);
        if (article == null) {
            return null;
        }
        article.setTitle(articleDTO.getTitle());
}
