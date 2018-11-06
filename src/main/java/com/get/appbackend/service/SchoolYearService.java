package com.get.appbackend.service;

import com.get.appbackend.domain.dto.SchoolYearResponseDto;

import java.util.List;

public interface SchoolYearService {

    List<SchoolYearResponseDto> findAll ();

}
