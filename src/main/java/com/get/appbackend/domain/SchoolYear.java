package com.get.appbackend.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "school_year")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SchoolYear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String year;

    @OneToMany(mappedBy = "schoolYear")
    private List<Exam> exams = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolYear that = (SchoolYear) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(year, that.year) &&
                Objects.equals(exams, that.exams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, exams);
    }

}
