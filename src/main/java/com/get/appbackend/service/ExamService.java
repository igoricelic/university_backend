package com.get.appbackend.service;

import com.get.appbackend.domain.dto.ExamRequestDto;
import com.get.appbackend.domain.dto.ExamResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ExamService {

    Page<ExamResponseDto> findAll (Pageable pageable);

    ExamResponseDto findById (Long id);

    ExamResponseDto save (ExamRequestDto examRequestDto);

}
