package com.get.appbackend.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.get.appbackend.domain.Exam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter @NoArgsConstructor
public class ExamResponseDto {

    private String schoolYear;

    private Date dateTime;

    private SubjectResponseDto subject;

    private ProffesorResponseDto proffesor;

    private StudentResponseDto studentResponseDto;

    private Boolean success;

    public ExamResponseDto(Exam exam) {
        this.schoolYear = exam.getSchoolYear().getYear();
        this.dateTime = exam.getDateAndTime();
        this.subject = new SubjectResponseDto(exam.getSubject());
        this.proffesor = new ProffesorResponseDto(exam.getProffesor());
        this.studentResponseDto = new StudentResponseDto(exam.getStudent());
        this.success = exam.getSuccess();
    }

}
