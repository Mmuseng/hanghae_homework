package com.spring.myblog.domain;

import com.spring.myblog.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Comment extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // GeneratedValue의 strategy를 IDENTITY로 선언해 테이블 별 id 할당
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private Long postid;

    public Comment(CommentRequestDto requsetDto) {
        this.username = requsetDto.getUsername();
        this.comment = requsetDto.getComment();
        this.postid = requsetDto.getPostid();
    }

    public void update(CommentRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.comment = requestDto.getComment();
        this.postid = requestDto.getPostid();
    }
}
