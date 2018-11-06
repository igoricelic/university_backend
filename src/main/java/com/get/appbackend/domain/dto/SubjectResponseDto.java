package com.get.appbackend.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.get.appbackend.domain.Subject;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
public class SubjectResponseDto {

    private Long id;

    private String name;

    private String description;

    private List<ProffesorResponseDto> proffesors;

    public SubjectResponseDto(Subject subject) {
        this.id = subject.getId();
        this.name = subject.getName();
        this.description = subject.getDescription();
    }

}
