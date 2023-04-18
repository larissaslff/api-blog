package com.larissa.blogapi.services;

import com.larissa.blogapi.domain.Comment;
import com.larissa.blogapi.domain.DTO.CommentDto;
import com.larissa.blogapi.repositories.CommentRepository;
import com.larissa.blogapi.utils.exceptions.ResourceNotFound;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    ModelMapper mapper;
    @Override
    public CommentDto createComment(CommentDto commentDto) {
        Comment comment = mapper.map(commentDto, Comment.class);
        Comment commentSaved = commentRepository.save(comment);
        CommentDto response = mapper.map(commentSaved, CommentDto.class);
        return response;
    }

    @Override
    public CommentDto getCommentById(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFound("Comment not found"));
        CommentDto commentDto = mapper.map(comment, CommentDto.class);
        return commentDto;
    }

    @Override
    public List<CommentDto> getAllComments() {
        List<Comment> allComments = commentRepository.findAll();
        List<CommentDto> allCommentsDto = allComments.stream().map(x -> mapper.map(x, CommentDto.class)).toList();
        return allCommentsDto;
    }

    @Override
    public CommentDto updateComment(Long commentId, CommentDto commentDto) {
        Comment commentSaved = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFound("Comment not found"));
        Comment comment = Comment.builder()
                .id(commentId)
                .message(commentDto.getMessage())
                .autor(commentDto.getAutor())
                .postId(commentDto.getPostId())
                .build();
        CommentDto commentUpdated = mapper.map(comment, CommentDto.class);
        return commentUpdated;
    }

    @Override
    public void deleteComment(Long commentId) {
        Comment commentFound = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFound("Comment not found"));
        commentRepository.delete(commentFound);
    }
}
