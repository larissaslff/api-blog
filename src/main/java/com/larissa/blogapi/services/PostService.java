package com.larissa.blogapi.services;

import com.larissa.blogapi.domain.DTO.PostDto;

import java.util.List;

public interface PostService {

    PostDto addPost(PostDto postDto);
    PostDto getPostById(Long postId);
    List<PostDto> getAllPosts();
    PostDto updatePost(Long postId, PostDto postDto);
    void deletePost(Long postId);
    PostDto findPostByCommentId(Long commentId);
}
