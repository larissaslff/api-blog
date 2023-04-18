package com.larissa.blogapi.controllers;

import com.larissa.blogapi.domain.DTO.CommentDto;
import com.larissa.blogapi.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    CommentService commentService;
    @PostMapping
    public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto commentDto) {
        CommentDto commentCreated = commentService.createComment(commentDto);
        return new ResponseEntity<>(commentCreated, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable(name = "id") Long commentId){
        CommentDto commentResponse = commentService.getCommentById(commentId);
        return ok(commentResponse);
    }
    @GetMapping
    public ResponseEntity<List<CommentDto>> getAllComments(){
        List<CommentDto> allComments = commentService.getAllComments();
        return ok(allComments);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable(name = "id") Long commentId,
                                                 @RequestBody CommentDto commentDto){
        CommentDto commentResponse = commentService.updateComment(commentId, commentDto);
        return ok(commentResponse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteComment(@PathVariable(name = "id") Long commentId){
        commentService.deleteComment(commentId);
        return status(HttpStatus.NO_CONTENT).build();
    }
}
