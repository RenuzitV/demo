package com.example.demo.service;

import com.example.demo.entity.Question;
import com.example.demo.repository.QuestionRepository;
import com.querydsl.core.BooleanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) return Sort.Direction.ASC;
        return Sort.Direction.DESC;
    }

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question add(Question question) {
        return questionRepository.save(question);
    }

    public Question update(Long id, Question question) {
        if (!questionRepository.existsById(id)) return null;
        question.setId(id);
        return questionRepository.save(question);
    }

    public Page<Question> find(int page, int size, String[] sort) {
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

        return questionRepository.findAll(pagingSort);
    }
}
