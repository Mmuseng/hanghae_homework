package com.spring.myblog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자를 만듦 (아래 주석으로 있는 생성자를 생성해준다)
@Getter
public class KakaoUserInfoDto {
    private Long id;
    private String nickname;
    private String email;
}