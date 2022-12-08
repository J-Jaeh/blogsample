package com.example.blogsample.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false, length = 4)
    private int password;

    @Builder
    public Post(String title, String username, String contents, int password){
        this.title = title;
        this.username = username;
        this.contents = contents;
        this.password = password;
    }
    public void update(String title, String contents){
        this.title =title;
        this.contents=contents;
    }
}