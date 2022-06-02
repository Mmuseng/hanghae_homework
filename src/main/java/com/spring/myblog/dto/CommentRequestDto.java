package com.spring.myblog.dto;

import lombok.Getter;

@Getter
public class CommentRequestDto {
    private String username;
    private String comment;
    private Long postid;
}
