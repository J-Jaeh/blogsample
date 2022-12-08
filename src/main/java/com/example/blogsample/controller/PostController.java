package com.example.blogsample.controller;


//import com.example.blogsample.dto.PostResponseDto;
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
    private  final PostRepository postRepository;

    @GetMapping("/api")
    public ModelAndView home() {
        return new ModelAndView("layout");
    }

    @PostMapping("/api/memos")
    public Post createPost(@RequestBody PostSaveRequestDto requestDto) {
        return postService.createPost(requestDto);
    }
    @GetMapping("/")
    public ModelAndView list(Model model){
        List<Post> postList = this.postRepository.findAll();
        return new ModelAndView("index");
    }
}


 /*   @PutMapping("/api/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto){
        return postService.update(id,requestDto);
    }
    @GetMapping("/api/posts/{id}")
    public PostResponseDto findById (@PathVariable Long id){
        return postService.findById(id);
    }
}
*/