package com.example.thymeleaftest.repository;

import com.example.thymeleaftest.model.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Board findByTitle(String title);
    Board findByContent(String content);
    Page<Board> findByTitleOrContentContaining(String title, String content, Pageable pageable);
}
