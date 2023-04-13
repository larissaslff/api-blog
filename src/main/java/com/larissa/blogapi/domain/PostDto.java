package com.larissa.blogapi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Builder
@Getter
@Setter
public class PostDto {
    private String titulo;
    private List<String> tags;
    private String autor;
}
