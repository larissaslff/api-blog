package com.larissa.blogapi.controllers;

import com.larissa.blogapi.domain.DTO.PostDto;
import com.larissa.blogapi.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        PostDto postResponse = postService.getPostById(postId);
        return ok(postResponse);
    }
    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPost(){
        List<PostDto> allPosts = postService.getAllPosts();
        return ok(allPosts);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable(name = "id") Long postId, @RequestBody PostDto postDto){
        PostDto postResponse = postService.updatePost(postId, postDto);
        return ok(postResponse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deletePost(@PathVariable(name = "id") Long postId){
        postService.deletePost(postId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
