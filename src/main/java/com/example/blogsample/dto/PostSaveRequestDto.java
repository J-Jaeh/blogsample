package com.example.blogsample.dto;

import com.example.blogsample.entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter

public class PostSaveRequestDto {
    private String title;
    private String contents;
    private String username;
    private Integer password;

}


