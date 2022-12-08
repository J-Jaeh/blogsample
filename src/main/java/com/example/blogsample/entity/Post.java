package com.example.blogsample.entity;

import com.example.blogsample.dto.PostSaveRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String username;

    @Column
    private String contents;

    @Column
    private Integer password;


    public Post(PostSaveRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
    }

    public void update(String title, String contents){
        this.title =title;
        this.contents=contents;
    }
}