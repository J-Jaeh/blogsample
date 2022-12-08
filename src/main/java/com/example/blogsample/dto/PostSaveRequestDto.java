package com.example.blogsample.dto;

import com.example.blogsample.entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {
    private String tilte;
    private String content;
    private String user;
    private  int password;
    @Builder
    public PostSaveRequestDto(String tilte, String content, String user, int password){
        this.tilte = tilte;
        this.content = content;
        this.user = user;
        this.password = password;
    }

    public Post toEntity(){
        return Post.builder()
                .title(tilte)
                .contents(content)
                .username(user)
                .password(password).build();
    }
}
