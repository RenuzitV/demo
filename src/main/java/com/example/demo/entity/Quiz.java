package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder=true)
public class Quiz implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;
    private String name;
    private LocalDate date;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Quiz quiz = (Quiz) o;
        return id != null && Objects.equals(id, quiz.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
