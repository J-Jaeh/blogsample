package com.example.blogsample.service;

//import com.example.blogsample.dto.PostResponseDto;
import com.example.blogsample.dto.PostResponseDto;
import com.example.blogsample.dto.PostSaveRequestDto;
//import com.example.blogsample.dto.PostUpdateRequestDto;
import com.example.blogsample.entity.Post;
import com.example.blogsample.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

 /*   @Transactional
    public Long update(Long id, PostUpdateRequestDto requestDto){
        Post post = postRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다"));

        post.update(requestDto.getTitle(),requestDto.getContent());

        return id;
    }
    */
    @Transactional
    public Post createPost(PostSaveRequestDto requestDto){
        Post post = new Post(requestDto);
        postRepository.save(post);

        return post;
    }

    @Transactional
    public List<Post> getPost() {
        return postRepository.findAllByOrderByModifiedAtDesc();
    }

   /* public PostResponseDto findById(Long id){
        Post entity = postRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다"));

        return new PostResponseDto(entity);
    }*/
   @Transactional
   public PostResponseDto getPosting(Long id) {
       Post post = checkPost(id);
       return new PostResponseDto(post);
   }
    private Post checkPost(Long id){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new RuntimeException("게시물이 존재하지 않습니다"));
        return post;
    }

}
