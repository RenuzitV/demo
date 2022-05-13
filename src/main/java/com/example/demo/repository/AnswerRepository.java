package com.example.demo.repository;

import com.example.demo.entity.Answer;
import com.example.demo.entity.Quiz;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends PagingAndSortingRepository<Answer, Long> {

}
