package com.larissa.blogapi.domain.DTO;

import com.larissa.blogapi.domain.Comment;
import lombok.*;

import java.util.List;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private Long postId;
    private String titulo;
    private List<String> tags;
    private String autor;
    private List<Comment> comments;
}
