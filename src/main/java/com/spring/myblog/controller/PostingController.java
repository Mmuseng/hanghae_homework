package com.spring.myblog.controller;


import com.spring.myblog.domain.Posting;
import com.spring.myblog.dto.CommentRequestDto;
import com.spring.myblog.dto.PostingRequestDto;
import com.spring.myblog.repository.PostingRepository;
import com.spring.myblog.security.UserDetailsImpl;
import com.spring.myblog.service.PostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PostingController {

    private final PostingRepository postingRepository;
    private final PostingService postingService;

    @Autowired
    public PostingController(PostingService postingService, PostingRepository postingRepository) {
        this.postingService = postingService;
        this.postingRepository = postingRepository;
    }

    @ResponseBody
    @GetMapping("/views/postList")
    public List<Posting> getPosting() {
        System.out.println("view 작동 확인");
        return postingRepository.findAllByOrderByModifiedAtDesc();
    }

    @GetMapping("/views/postings/{id}")
    public ModelAndView detail(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView modelAndView = new ModelAndView();

        Posting posting = postingRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("id가 존재하지 않습니다.")
        );

        try {
            modelAndView.addObject("login_username", userDetails.getUsername());
        } catch (NullPointerException exception) {
            modelAndView.addObject("login_username", null);
        }
        modelAndView.addObject("post",posting);
        modelAndView.addObject("timaAt",posting.getModifiedAt());
        modelAndView.setViewName("viewPost");
        return modelAndView;
    }

    @PutMapping("/update/postings/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody PostingRequestDto requestDto) {
        System.out.println(id + "PUT 통신");
        postingService.update(id, requestDto);
    }

    @GetMapping("/create/writePost")
    public String viewCreatePost(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {

        try{
            model.addAttribute("username", userDetails.getUsername());
        } catch (NullPointerException exception) {
            System.out.println("/create/writePost - username 값이 없습니다");
        }
        return "createPost";
    }

    @ResponseBody
    @PostMapping("/create/writePost")
    public void createPost(@RequestBody PostingRequestDto requestDto) {
        System.out.println("create 작동 확인");
        Posting posting = new Posting(requestDto);
        postingRepository.save(posting);
    }
}