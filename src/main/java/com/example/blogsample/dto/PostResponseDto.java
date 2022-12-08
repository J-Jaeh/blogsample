package com.example.blogsample.dto;

import com.example.blogsample.entity.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private String user;
    private int password;

    public PostResponseDto(Post entity) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
        this.password = password;
    }
}
