package com.example.demo.usecase;

import com.example.demo.dto.Post;

import java.util.List;

public interface PostUseCase {
    Post createPost(Long userId, String title);
    List<Post> getPost();
    List<Post> getPost(int pageNumber, int pageSize);
}
