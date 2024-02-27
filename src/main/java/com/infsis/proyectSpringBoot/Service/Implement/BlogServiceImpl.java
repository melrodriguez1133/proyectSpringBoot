package com.infsis.proyectSpringBoot.Service.Implement;

import com.infsis.proyectSpringBoot.DTOs.BlogDTO;
import com.infsis.proyectSpringBoot.Models.Blog;
import com.infsis.proyectSpringBoot.Service.BlogService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    private List<Blog> blogs = new ArrayList<>();

    public List<BlogDTO> getBlogs() {
        List<BlogDTO> blogDTOs = new ArrayList<>();
        for (Blog blog : blogs) {
            blogDTOs.add(new BlogDTO(blog));
        }
        return blogDTOs;
    }

    public BlogDTO getBlogById(Integer blogId) {
        Blog blog = findBlogById(blogId);
        if (blog == null) {
            return null;
        }
        return new BlogDTO(blog);
    }

    public BlogDTO saveBlog(BlogDTO blogDTO) {
        Blog blog = new Blog(blogDTO.getName());
        blogs.add(blog);
        return new BlogDTO(blog);
    }

    public BlogDTO updateBlog(Integer blogId, BlogDTO blogDTO) {
        Blog blog = findBlogById(blogId);
        if (blog == null) {
            return null;
        }
        blog.setName(blogDTO.getName());
        // Update other blog fields if needed
        return new BlogDTO(blog);
    }

    public void deleteBlog(Integer blogId) {
        Blog blog = findBlogById(blogId);
        if (blog != null) {
            blogs.remove(blog);
        }
    }

    @Override
    public List<Blog> findAll() {
        return null;
    }

    @Override
    public Blog findById(Integer id) {
        return null;
    }

    @Override
    public Blog save(Blog blog) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    private Blog findBlogById(Integer blogId) {
        for (Blog blog : blogs) {
            if (blog.getId().equals(blogId)) {
                return blog;
            }
        }
        return null;
    }
}