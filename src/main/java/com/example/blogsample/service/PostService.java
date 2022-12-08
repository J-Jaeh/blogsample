package com.example.blogsample.service;

import com.example.blogsample.dto.PostResponseDto;
import com.example.blogsample.dto.PostSaveRequestDto;
import com.example.blogsample.dto.PostUpdateRequestDto;
import com.example.blogsample.entity.Post;
import com.example.blogsample.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto){
        return postRepository.save(requestDto.toEntity()).getId();
    }
    @Transactional
    public Long update(Long id, PostUpdateRequestDto requestDto){
        Post post = postRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다"));

        post.update(requestDto.getTitle(),requestDto.getContent());

        return id;
    }


    public PostResponseDto findById(Long id){
        Post entity = postRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다"));

        return new PostResponseDto(entity);
    }
}
