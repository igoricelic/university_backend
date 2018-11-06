package com.get.appbackend.service;

import com.get.appbackend.domain.dto.StudentRequestDto;
import com.get.appbackend.domain.dto.StudentResponseDto;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {

    Page<StudentResponseDto> findAll (Predicate predicate, Pageable pageable);

    StudentResponseDto findById (Long id);

    StudentResponseDto save (StudentRequestDto studentRequestDto);

    StudentResponseDto update (StudentRequestDto studentRequestDto);

}
