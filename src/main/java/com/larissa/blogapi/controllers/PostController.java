package com.larissa.blogapi.controllers;

import com.larissa.blogapi.domain.PostDto;
import com.larissa.blogapi.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/posts")
public class PostController {

    PostService postService;
    PostController(PostService postService){
        this.postService = postService;
    }
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto postResponse = postService.addPost(postDto);
        return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    }
}
