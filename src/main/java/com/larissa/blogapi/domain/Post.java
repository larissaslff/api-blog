package com.larissa.blogapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Builder
@Table(name = "posts")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private List<String> tags;
    private String autor;
}
