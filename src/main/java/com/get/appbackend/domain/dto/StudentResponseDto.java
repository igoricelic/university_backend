package com.get.appbackend.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.get.appbackend.domain.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
public class StudentResponseDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String index;

    private List<ExamResponseDto> exams;

    public StudentResponseDto(Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.index = student.getIndex();
    }

}
