package com.example.blogsample.controller;

import com.example.blogsample.dto.PostSaveRequestDto;
import com.example.blogsample.dto.PostUpdateRequestDto;
import com.example.blogsample.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
public class PostController {
    private  final PostService postService;
    @GetMapping("/api/posts")
    public Long save(@RequestBody PostSaveRequestDto requestDto){
        return postService.save(requestDto);
    }
    @PutMapping("/api/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto){
        return postService.update(id,requestDto);
    }
    @GetMapping("/api/posts/{id}")
    public PostSaveRequestDto findByID (@PathVariable Long id){
        return postService.findById(id);
    }
}
