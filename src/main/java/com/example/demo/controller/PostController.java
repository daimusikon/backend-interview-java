package com.example.demo.controller;

import com.example.demo.dto.Post;
import com.example.demo.exception.BadRequestException;
import com.example.demo.service.PostService;
import com.example.demo.usecase.PostUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    private final PostUseCase postUseCase = new PostService();

    @GetMapping("/")
    public ResponseEntity<String> healthCheck(){
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/post")
    public ResponseEntity<List<Post>> getPost(
            @RequestParam(defaultValue = "1") int pageNumber,
            @RequestParam(defaultValue = "5") int pageSize
    ) throws BadRequestException {
        if (pageNumber <= 0){
            throw new BadRequestException();
        }
        List<Post> posts = postUseCase.getPost(pageNumber, pageSize);
        return ResponseEntity.ok(posts);
    }
}
