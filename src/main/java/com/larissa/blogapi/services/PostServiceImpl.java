package com.larissa.blogapi.services;

import com.larissa.blogapi.domain.Comment;
import com.larissa.blogapi.domain.DTO.PostDto;
import com.larissa.blogapi.domain.Post;
import com.larissa.blogapi.repositories.CommentRepository;
import com.larissa.blogapi.repositories.PostRepository;
import com.larissa.blogapi.utils.exceptions.ResourceNotFound;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    CommentRepository commentRepository;
    PostRepository postRepository;

    ModelMapper mapper;

    private PostServiceImpl(PostRepository postRepository, ModelMapper mapper, CommentRepository commentRepository){
        this.postRepository = postRepository;
        this.mapper = mapper;
        this.commentRepository = commentRepository;
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
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFound("Post not found"));
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
    public PostDto updatePost(Long postId, PostDto postDto) {
        Post postFound = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFound("Post not found"));
        Post postToUpdate = Post.builder()
                .id(postId)
                .tags(postDto.getTags())
                .autor(postDto.getAutor())
                .titulo(postDto.getTitulo())
                .build();
        Post postUpdated = postRepository.save(postToUpdate);
        return mapper.map(postUpdated, PostDto.class);
    }

    @Override
    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFound("Post not found"));
        postRepository.delete(post);
    }

    @Override
    public PostDto findPostByCommentId(Long commentId) {
        Comment commentSaved = commentRepository.findById(commentId).get();
        Post post = commentSaved.getPostId();
        PostDto postSaved = mapper.map(post, PostDto.class);
        return postSaved;
    }

}
