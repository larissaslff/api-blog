package com.larissa.blogapi.services;

import com.larissa.blogapi.domain.DTO.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto);
    CommentDto getCommentById(Long commentId);
    List<CommentDto> getAllComments();
    CommentDto updateComment(Long commentId, CommentDto commentDto);
    void deleteComment(Long commentId);
}
