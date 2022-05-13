package com.example.demo.DatabaseLoader;

import com.example.demo.entity.Answer;
import com.example.demo.entity.Question;
import com.example.demo.entity.Quiz;
import com.example.demo.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Component
public class QuizDatabaseLoader implements CommandLineRunner {
    private final QuizRepository repository;

    @Autowired
    public QuizDatabaseLoader(QuizRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception{
        Answer trueAnswer = Answer.builder().content("No").isCorrectAnswer(true).build();
        Answer falseAnswer = Answer.builder().content("Yes").isCorrectAnswer(false).build();
        Question question1 = Question.builder().content("is javascript java with scripts?").answers(List.of(trueAnswer, falseAnswer)).build();
        Quiz quiz = Quiz.builder().name("final test").date(LocalDate.of(2022, 5, 13)).questions(List.of(question1)).build();
        repository.save(quiz);

        trueAnswer = Answer.builder().content("Yes").isCorrectAnswer(true).build();
        falseAnswer = Answer.builder().content("No").isCorrectAnswer(false).build();
        question1 = Question.builder().content("is the creator of this final test handsome?").answers(List.of(trueAnswer, falseAnswer)).build();
        quiz = Quiz.builder().name("mid semester test").date(LocalDate.of(2022, 1, 11)).questions(List.of(question1)).build();
        repository.save(quiz);

        trueAnswer = Answer.builder().content("No").isCorrectAnswer(true).build();
        falseAnswer = Answer.builder().content("Yes").isCorrectAnswer(false).build();
        question1 = Question.builder().content("will this student get full marks for this test?").answers(List.of(trueAnswer, falseAnswer)).build();
        quiz = Quiz.builder().name("entry level quiz").date(LocalDate.of(2010, 5, 20)).questions(List.of(question1)).build();
        repository.save(quiz);

        trueAnswer = Answer.builder().content("Yes").isCorrectAnswer(true).build();
        falseAnswer = Answer.builder().content("No").isCorrectAnswer(false).build();
        question1 = Question.builder().content("will the universe go to a heat death?").answers(List.of(trueAnswer, falseAnswer)).build();
        quiz = Quiz.builder().name("universal level quiz").date(LocalDate.of(2022, 5, 21)).questions(List.of(question1)).build();
        repository.save(quiz);

        trueAnswer = Answer.builder().content("Yes").isCorrectAnswer(true).build();
        falseAnswer = Answer.builder().content("No").isCorrectAnswer(false).build();
        question1 = Question.builder().content("is copy and pasting the same lines of code over and over bad?").answers(List.of(trueAnswer, falseAnswer)).build();
        quiz = Quiz.builder().name("first year uni level quiz").date(LocalDate.of(2022, 5, 22)).questions(List.of(question1)).build();
        repository.save(quiz);
    }
}
