package com.larissa.blogapi.domain;

import lombok.*;

import java.util.List;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private String titulo;
    private List<String> tags;
    private String autor;
}
