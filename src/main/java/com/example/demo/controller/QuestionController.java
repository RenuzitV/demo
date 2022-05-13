package com.example.demo.controller;

import com.example.demo.entity.Question;
import com.example.demo.entity.Quiz;
import com.example.demo.service.QuestionService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController()
@RequestMapping("/questions")
public class QuestionController {
    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        return new ResponseEntity<>(questionService.add(question), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @RequestBody Question question){
        return new ResponseEntity<>(questionService.update(id, question), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Page<Question>> getQuestions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort){
        try {
            Page<Question> questionPage = questionService.find(page, size, sort);
            return new ResponseEntity<>(questionPage, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
