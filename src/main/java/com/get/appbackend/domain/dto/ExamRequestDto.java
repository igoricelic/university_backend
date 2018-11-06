package com.get.appbackend.domain.dto;

import com.get.appbackend.utils.ValidationGroup;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter @Setter @NoArgsConstructor
public class ExamRequestDto {

    @NotNull(groups = ValidationGroup.Save.class, message = "Proffesor Id can not be null")
    private Long proffesorId;

    @NotNull(groups = ValidationGroup.Save.class, message = "Student Id can not be null")
    private Long studentId;

    @NotNull(groups = ValidationGroup.Save.class, message = "Subject Id can not be null")
    private Long subjectId;

    @NotNull(groups = ValidationGroup.Save.class, message = "School year Id can not be null")
    private Long schoolYearId;

    private Boolean result;

}
