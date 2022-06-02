package com.spring.myblog.service;


import com.spring.myblog.domain.Posting;
import com.spring.myblog.dto.PostingRequestDto;
import com.spring.myblog.repository.PostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostingService {

    private final PostingRepository postingRepository;

    public Long update(Long id, PostingRequestDto requestDto) {
        Posting posting = postingRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        posting.update(requestDto);
        return posting.getId();
    }
}