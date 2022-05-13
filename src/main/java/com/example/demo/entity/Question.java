package com.example.demo.entity;

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
public class Question implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String content;
    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<Answer> answers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Question question = (Question) o;
        return id != null && Objects.equals(id, question.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
