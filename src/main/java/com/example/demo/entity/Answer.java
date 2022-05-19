package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder=true)
public class Answer implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String content;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "question_id")
    @JsonBackReference
    private Question question;
    @JsonProperty("isCorrectAnswer")
    private boolean isCorrectAnswer;

    @PrePersist
    void prePersist(){
        List<Answer> answerList = question.getAnswers();
        answerList.add(this);
        question.setAnswers(answerList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Answer answer = (Answer) o;
        return id != null && Objects.equals(id, answer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
