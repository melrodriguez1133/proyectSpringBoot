package com.infsis.proyectSpringBoot.Controllers;

import com.infsis.proyectSpringBoot.DTOs.BlogDTO;
import com.infsis.proyectSpringBoot.Models.Blog;
import com.infsis.proyectSpringBoot.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService; // Assuming a BlogService exists

    @GetMapping
    public ResponseEntity<List<BlogDTO>> getBlogs() {
        List<Blog> blogs = blogService.findAll();
        List<BlogDTO> blogDTOs = new ArrayList<>();
        for (Blog blog : blogs) {
            blogDTOs.add(new BlogDTO(blog)); // Convert Blog to BlogDTO
        }
        return ResponseEntity.ok().body(blogDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogDTO> getBlog(@PathVariable Integer id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(new BlogDTO(blog)); // Convert Blog to BlogDTO
    }

    @PostMapping
    public ResponseEntity<BlogDTO> saveBlog(@RequestBody BlogDTO blogDTO) {
        Blog blog = new Blog(blogDTO.getName()); // Use BlogDTO properties to create a Blog
        blog = blogService.save(blog); // Save the Blog and retrieve the saved object
        return ResponseEntity.ok().body(new BlogDTO(blog)); // Convert saved Blog to BlogDTO
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogDTO> updateBlog(@PathVariable Integer id, @RequestBody BlogDTO blogDTO) {
        Blog existingBlog = blogService.findById(id);
        if (existingBlog == null) {
            return ResponseEntity.notFound().build();
        }
        existingBlog.setName(blogDTO.getName()); // Update Blog properties
        blogService.save(existingBlog); // Save the updated Blog
        return ResponseEntity.ok().body(new BlogDTO(existingBlog)); // Convert saved Blog to BlogDTO
    }

    @DeleteMapping("/{id}")
    public void deleteBlog(@PathVariable Integer id) {
        blogService.deleteById(id);
    }

}