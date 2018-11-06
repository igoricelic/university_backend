package com.get.appbackend.service;

import com.get.appbackend.domain.dto.SubjectRequestDto;
import com.get.appbackend.domain.dto.SubjectResponseDto;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SubjectService {

    Page<SubjectResponseDto> findAll (Predicate predicate, Pageable pageable);

    SubjectResponseDto findById (Long id);

    SubjectResponseDto save (SubjectRequestDto subjectRequestDto);

    SubjectResponseDto update (SubjectRequestDto subjectRequestDto);

}
