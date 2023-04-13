package com.larissa.blogapi.services;

import com.larissa.blogapi.domain.PostDto;

import java.util.List;

public interface PostService {

    PostDto addPost(PostDto postDto);
    PostDto getPostById(Long postId);
    List<PostDto> getAllPosts();
    void deletePost(Long postId);
}
