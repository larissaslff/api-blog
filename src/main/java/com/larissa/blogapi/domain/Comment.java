package com.larissa.blogapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private String autor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id-post")
    @JsonIgnore
    private Post postId;
}
