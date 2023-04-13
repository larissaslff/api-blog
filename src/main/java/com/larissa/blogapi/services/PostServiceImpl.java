package com.larissa.blogapi.services;

import com.larissa.blogapi.domain.Post;
import com.larissa.blogapi.domain.PostDto;
import com.larissa.blogapi.repositories.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    PostRepository postRepository;

    PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }
    @Override
    public PostDto addPost(PostDto postDto) {
        Post post = Post.builder()
                .autor(postDto.getAutor())
                .titulo(postDto.getTitulo())
                .tags(postDto.getTags())
                .build();
        Post postSaved = postRepository.save(post);
        PostDto response = PostDto.builder()
                .autor(postSaved.getAutor())
                .tags(postSaved.getTags())
                .titulo(postSaved.getTitulo())
                .build();
        return response;
    }
}
