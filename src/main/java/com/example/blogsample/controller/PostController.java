package com.example.blogsample.controller;


import com.example.blogsample.dto.PostResponseDto;
import com.example.blogsample.dto.PostSaveRequestDto;
//import com.example.blogsample.dto.PostUpdateRequestDto;
import com.example.blogsample.entity.Post;
import com.example.blogsample.repository.PostRepository;
import com.example.blogsample.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final PostRepository postRepository;

    @GetMapping("/api")
    public ModelAndView home() {
        return new ModelAndView("layout");
    }

    @PostMapping("/api/memos")
    public Post createPost(@RequestBody PostSaveRequestDto requestDto) {
        return postService.createPost(requestDto);
    }

    @GetMapping("/api/memos")
    public List<Post> getPost() {

        return postService.getPost();
    }



 /*   @PutMapping("/api/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto){
        return postService.update(id,requestDto);
    }*/
   /* @GetMapping("/api/posts/{id}")
    public List<Post> getContent(){

        return postService.getPost();
    }*/

    @GetMapping(value = "/api/post/{id}")
    public ModelAndView detail(@PathVariable("id") Integer id) { //이방법이 아닌가보다 ... 파라미터가없으면 되는데 있으니까 안되네 물어봐야겠다.
        return new ModelAndView("post_detail");

    }

    @GetMapping("/api/post")
    public PostResponseDto getPosting(@RequestParam Long id) {
        return postService.getPosting(id);
    }
}
