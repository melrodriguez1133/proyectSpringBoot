package com.infsis.proyectSpringBoot.Service;

import com.infsis.proyectSpringBoot.DTOs.BlogDTO;
import com.infsis.proyectSpringBoot.Models.Blog;

import java.util.Optional;
import java.util.List;

public interface BlogService {
    List<BlogDTO> getBlogs();
    BlogDTO getBlogById(Integer blogId);

    BlogDTO saveBlog(BlogDTO blogDTO);

    BlogDTO updateBlog(Integer blogId, BlogDTO blogDTO);

    void deleteBlog(Integer blogId);

    List<Blog> findAll();

    Blog findById(Integer id);

    Blog save(Blog blog);

    void deleteById(Integer id);
}