package com.example.demo.repository;

import com.example.demo.dto.Post;
import com.example.demo.service.PostService;
import com.example.demo.usecase.PostUseCase;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

public class PostRepository {
    private String URL = "https://jsonplaceholder.typicode.com/posts";
    private final RestTemplate restTemplate = new RestTemplate();
    private final PostUseCase postUseCase = new PostService();

    public List<Post> getPost(){
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL);
        Post[] posts = restTemplate.getForObject(builder.toUriString(), Post[].class);
        List<Post> postList = new ArrayList<>();
        if (posts != null){
            for (Post post : posts){
                postList.add(postUseCase.createPost(post.getUserId(), post.getTitle()));
            }
        }
        return postList;
    }
}
