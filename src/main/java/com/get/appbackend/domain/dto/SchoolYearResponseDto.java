package com.get.appbackend.domain.dto;

import com.get.appbackend.domain.SchoolYear;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SchoolYearResponseDto {

    private Long id;

    private String schoolYear;

    public SchoolYearResponseDto(SchoolYear schoolYear) {
        this.id = schoolYear.getId();
        this.schoolYear = schoolYear.getYear();
    }

}
