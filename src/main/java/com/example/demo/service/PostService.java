package com.example.demo.service;

import com.example.demo.dto.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.usecase.PostUseCase;

import java.util.List;

public class PostService implements PostUseCase {
    @Override
    public Post createPost(Long userId, String title) {
        return new Post(userId, title);
    }

    @Override
    public List<Post> getPost() {
        PostRepository postRepository = new PostRepository();
        return postRepository.getPost();
    }

    @Override
    public List<Post> getPost(int pageNumber, int pageSize) {
        List<Post> posts = this.getPost();
        int fromIndex = (pageNumber - 1) * pageSize;
        int toIndex = fromIndex + pageSize;
        return posts.subList(fromIndex, toIndex);
    }
}
