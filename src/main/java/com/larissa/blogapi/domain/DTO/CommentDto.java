package com.larissa.blogapi.domain.DTO;

import com.larissa.blogapi.domain.Post;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CommentDto {
    private Long id;
    private String message;
    private String autor;
    private Post postId;
}
