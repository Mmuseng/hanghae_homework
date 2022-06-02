package com.spring.myblog.controller;

import com.spring.myblog.domain.Comment;
import com.spring.myblog.dto.CommentRequestDto;
import com.spring.myblog.repository.CommentRepository;
import com.spring.myblog.security.UserDetailsImpl;
import com.spring.myblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentService commentService;

    @Autowired
    public CommentController (CommentRepository commentRepository, CommentService commentService) {
        this.commentRepository = commentRepository;
        this.commentService = commentService;
    }

    @PostMapping("/create/comment")
    public void createCommnet (@RequestBody CommentRequestDto requestDto) {
        Comment comment = new Comment(requestDto);
        commentRepository.save(comment);
    }

    @GetMapping("/views/commentList/{postid}")
    public List<Comment> readCommentList(@PathVariable Long postid) {

        return commentRepository.findAllByPostidOrderByModifiedAtDesc(postid);
    }

//    @PutMapping("/update/comment/{id}")
//    public void updateComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto) {
//        commentService.update(id, requestDto);
//    }

    @DeleteMapping("/delete/comment/{id}")
    public Long deleteComment(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {
            commentRepository.deleteById(id);
        }

        return id;
    }
}
