package com.larissa.blogapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private List<String> tags = new ArrayList<>();
    private String autor;
    @OneToMany(mappedBy = "postId")
    @JsonIgnore
    private List<Comment> comments = new ArrayList<>();
}
