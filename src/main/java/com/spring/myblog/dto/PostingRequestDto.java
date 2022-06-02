package com.spring.myblog.dto;

import lombok.Getter;

@Getter
public class PostingRequestDto {
    private String title;
    private String username;
    private String contents;
}