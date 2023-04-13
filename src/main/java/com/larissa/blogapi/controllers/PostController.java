package com.larissa.blogapi.controllers;

import com.larissa.blogapi.domain.PostDto;
import com.larissa.blogapi.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

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
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") Long postId){
        PostDto postResponse = postService.getById(postId);
        return ok(postResponse);
    }

}
