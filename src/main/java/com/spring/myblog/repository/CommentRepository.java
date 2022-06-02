package com.spring.myblog.repository;

import com.spring.myblog.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPostidOrderByModifiedAtDesc(Long postid);
}
