package com.example.demo.DatabaseLoader;

import com.example.demo.entity.Answer;
import com.example.demo.entity.Question;
import com.example.demo.entity.Quiz;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Component
public class QuizDatabaseLoader implements CommandLineRunner {
    private final QuestionRepository repository;

    @Autowired
    public QuizDatabaseLoader(QuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception{
        Answer trueAnswer = Answer.builder().content("No").isCorrectAnswer(true).build();
        Answer falseAnswer = Answer.builder().content("Yes").isCorrectAnswer(false).build();
        Quiz quiz = Quiz.builder().name("final test").date(LocalDate.of(2022, 5, 13)).build();
        Question question1 = Question.builder().content("is javascript java with scripts?").answers(List.of(trueAnswer, falseAnswer)).quiz(quiz).build();
        trueAnswer.setQuestion(question1);
        falseAnswer.setQuestion(question1);
        repository.save(question1);

        trueAnswer = Answer.builder().content("Yes").isCorrectAnswer(true).build();
        falseAnswer = Answer.builder().content("No").isCorrectAnswer(false).build();
        quiz = Quiz.builder().name("mid semester test").date(LocalDate.of(2022, 1, 11)).build();
        question1 = Question.builder().content("is the creator of this final test handsome?").answers(List.of(trueAnswer, falseAnswer)).quiz(quiz).build();
        trueAnswer.setQuestion(question1);
        falseAnswer.setQuestion(question1);
        repository.save(question1);

        trueAnswer = Answer.builder().content("No").isCorrectAnswer(true).build();
        falseAnswer = Answer.builder().content("Yes").isCorrectAnswer(false).build();
        quiz = Quiz.builder().name("entry level test").date(LocalDate.of(2010, 5, 20)).build();
        question1 = Question.builder().content("will this student get full marks for this test?").answers(List.of(trueAnswer, falseAnswer)).quiz(quiz).build();
        trueAnswer.setQuestion(question1);
        falseAnswer.setQuestion(question1);
        repository.save(question1);

        trueAnswer = Answer.builder().content("Yes").isCorrectAnswer(true).build();
        falseAnswer = Answer.builder().content("No").isCorrectAnswer(false).build();
        quiz = Quiz.builder().name("universal level quiz").date(LocalDate.of(2022, 5, 21)).build();
        question1 = Question.builder().content("will the universe go to a heat death?").answers(List.of(trueAnswer, falseAnswer)).quiz(quiz).build();
        trueAnswer.setQuestion(question1);
        falseAnswer.setQuestion(question1);
        repository.save(question1);

        trueAnswer = Answer.builder().content("Yes").isCorrectAnswer(true).build();
        falseAnswer = Answer.builder().content("No").isCorrectAnswer(false).build();
        quiz = Quiz.builder().name("first year uni level quiz").date(LocalDate.of(2022, 5, 22)).build();
        question1 = Question.builder().content("is copy and pasting the same lines of code over and over bad?").answers(List.of(trueAnswer, falseAnswer)).quiz(quiz).build();
        trueAnswer.setQuestion(question1);
        falseAnswer.setQuestion(question1);
        repository.save(question1);
    }
}
