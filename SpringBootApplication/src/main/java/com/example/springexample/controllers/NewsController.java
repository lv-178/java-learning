package com.example.springexample.controllers;

import com.example.springexample.dto.NewsDto;
import com.example.springexample.services.NewsCRUDService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/news")
public class NewsController {
    private final NewsCRUDService newsService;

    public NewsController(NewsCRUDService newsService) {
        this.newsService = newsService;
    }

//    @GetMapping("/{id}")
//    public ResponseEntity getById(@PathVariable Integer id) {
//        String ans = newsService.getById(id).toString();
//        return new ResponseEntity(ans, HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        return newsService.getById(id);
    }

    @GetMapping
    public Collection<NewsDto> getAll() {
        return newsService.getAll();
    }

    @PostMapping
    public ResponseEntity create(@RequestBody NewsDto commentDto) {
        return newsService.create(commentDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody NewsDto commentDto) {
        return newsService.update(id, commentDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        return newsService.delete(id);
    }

}
