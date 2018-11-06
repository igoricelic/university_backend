package com.get.appbackend.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "subject")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "subject")
    private List<Exam> exams = new ArrayList<>();

    @ManyToMany(cascade = { CascadeType.PERSIST })
    @JoinTable(name = "subject_proffesor",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "proffesor_id")
    )
    private List<Proffesor> proffesors;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(id, subject.id) &&
                Objects.equals(name, subject.name) &&
                Objects.equals(description, subject.description) &&
                Objects.equals(exams, subject.exams) &&
                Objects.equals(proffesors, subject.proffesors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, exams, proffesors);
    }

}
