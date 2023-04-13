package com.larissa.blogapi.services;

import com.larissa.blogapi.domain.Post;
import com.larissa.blogapi.domain.PostDto;
import com.larissa.blogapi.repositories.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    PostRepository postRepository;

    ModelMapper mapper;

    private PostServiceImpl(PostRepository postRepository, ModelMapper mapper){
        this.postRepository = postRepository;
        this.mapper = mapper;
    }
    @Override
    public PostDto addPost(PostDto postDto) {
        Post post = mapper.map(postDto, Post.class);
        Post postSaved = postRepository.save(post);
        PostDto response = mapper.map(postSaved, PostDto.class);
        return response;
    }

    @Override
    public PostDto getPostById(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(null);
        PostDto response = mapper.map(post, PostDto.class);
        return response;
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> allPosts = postRepository.findAll();
        List<PostDto> postsResponse = allPosts.stream().map(x -> mapper.map(x, PostDto.class)).toList();
        return postsResponse;
    }

    @Override
    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(null);
        postRepository.delete(post);
    }

}
