package com.example.thymeleaftest.controller;

import java.util.List;

import com.example.thymeleaftest.model.Board;
import com.example.thymeleaftest.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
class BoardApiController {

    @Autowired
    private BoardRepository repository;

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/Boards")
    List<Board> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @GetMapping("/Boards/title")
    public Board getBoardByTitle(@RequestParam(required = true) String title){
        return repository.findByTitle(title);
    }

    @GetMapping("/Boards/content")
    public Board getBoardByContent(@RequestParam(required = true) String content){
        return repository.findByContent(content);
    }

    @PostMapping("/Boards")
    Board newBoard(@RequestBody Board newBoard) {
        return repository.save(newBoard);
    }

    // Single item

    @GetMapping("/Boards/{id}")
    Board one(@PathVariable Long id) {

        return repository.findById(id).orElse(null);
    }

    @PutMapping("/Boards/{id}")
    Board replaceBoard(@RequestBody Board newBoard, @PathVariable Long id) {

        return repository.findById(id)
                .map(Board -> {
                    Board.setTitle(newBoard.getTitle());
                    Board.setContent(newBoard.getContent());
                    return repository.save(Board);
                })
                .orElseGet(() -> {
                    newBoard.setId(id);
                    return repository.save(newBoard);
                });
    }

    @DeleteMapping("/Boards/{id}")
    void deleteBoard(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
