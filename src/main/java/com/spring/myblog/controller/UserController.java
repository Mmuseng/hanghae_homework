package com.spring.myblog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.myblog.dto.SignupRequestDto;
import com.spring.myblog.repository.UserRepository;
import com.spring.myblog.service.KakaoUserService;
import com.spring.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;
    private final KakaoUserService kakaoUserService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, KakaoUserService kakaoUserService, UserRepository userRepository) {

        this.userService = userService;
        this.kakaoUserService = kakaoUserService;
        this.userRepository = userRepository;
    }

    // 회원 로그인 페이지
    @GetMapping("/user/login")
    public String login() {

        return "login";
    }

    // 회원 가입 페이지
    @GetMapping("/user/signup")
    public String signup() {

        return "signup";
    }

    @PostMapping("/user/signup")
    public String registerUser(SignupRequestDto requestDto) {
        System.out.println("~~~post /user/signup username : " + requestDto.getUsername());
        userService.registerUser(requestDto);
        return "redirect:/user/login";
    }

    @ResponseBody
    @GetMapping("/user/idDupCheck/{userid}")
    public Boolean idDupCheck(@PathVariable String userid) {

        return userService.checkIdDuplicate(userid);
    }

    @GetMapping("/user/kakao/callback")
    public String kakaoLogin(@RequestParam String code) throws JsonProcessingException {
        kakaoUserService.kakaoLogin(code);

        return "redirect:/";
    }

}