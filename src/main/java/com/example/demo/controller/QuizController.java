package com.example.demo.controller;

import com.example.demo.entity.Quiz;
import com.example.demo.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/quizzes")
public class QuizController {
    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }


    @PostMapping()
    public Quiz addQuiz(@RequestBody Quiz quiz){
        return quizService.save(quiz);
    }

    @GetMapping()
    @ResponseBody
    public ResponseEntity<Page<Quiz>> getQuizzes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "date,desc") String[] sort,
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        try {
            Page<Quiz> moviePage = quizService.find(name, date, page, size, sort);
            return new ResponseEntity<>(moviePage, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
