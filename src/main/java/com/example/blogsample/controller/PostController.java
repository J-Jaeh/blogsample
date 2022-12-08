package com.example.blogsample.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
public class PostController {
    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }    //ModelAndView라는 객체에 데이터도 넣어줄수 있고 templates의 html파일 반환할수있다.!

}
