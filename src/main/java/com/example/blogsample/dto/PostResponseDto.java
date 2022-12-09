package com.example.blogsample.dto;

import com.example.blogsample.entity.Post;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private String username;
    private Integer password;

    /*public PostResponseDto(Post entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContents();
        this.user = entity.getUsername();
        this.password = entity.getPassword();
    }*/

    @Builder
    public PostResponseDto(String title, String content,String username,Long id){
        this.title = title;
        this.content = content;
        this.username = username;
        this.id = id;
    }
}


