package com.get.appbackend.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.get.appbackend.domain.Proffesor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
public class ProffesorResponseDto {

    private Long id;

    private String firstName;

    private String lastName;

    private Integer totalSubjects;

    private List<SubjectResponseDto> subjects;

    public ProffesorResponseDto(Proffesor proffesor) {
        this.id = proffesor.getId();
        this.firstName = proffesor.getFirstName();
        this.lastName = proffesor.getLastName();
        this.totalSubjects = (proffesor.getSubjects() != null) ? proffesor.getSubjects().size() : 0;
    }

}
