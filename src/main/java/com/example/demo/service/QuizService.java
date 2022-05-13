package com.example.demo.service;

import com.example.demo.entity.QQuiz;
import com.example.demo.entity.Quiz;
import com.example.demo.repository.QuizRepository;
import com.querydsl.core.BooleanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {
    private final QuizRepository quizRepository;
    private final QQuiz quiz;

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) return Sort.Direction.ASC;
        return Sort.Direction.DESC;
    }

    @Autowired
    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
        this.quiz = QQuiz.quiz;
    }

    public Quiz save(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public Page<Quiz> find(String name, LocalDate date, int page, int size, String[] sort) {
        List<Sort.Order> orders = new ArrayList<>();
        for (int i = 0; i < sort.length; i += 2){
            if (i + 1 < sort.length) {
                orders.add(new Sort.Order(getSortDirection(sort[i+1]), sort[i]));
            }
            else {
                orders.add(new Sort.Order(getSortDirection("desc"), sort[i]));
            }
        }
        Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if (name != null) booleanBuilder.and(quiz.name.likeIgnoreCase("%"+name+"%"));
        if (date != null) booleanBuilder.and(quiz.date.goe(date));

        return quizRepository.findAll(booleanBuilder, pagingSort);
    }
}
