package com.get.appbackend.service;

import com.get.appbackend.domain.dto.ProffesorRequestDto;
import com.get.appbackend.domain.dto.ProffesorResponseDto;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProffesorService {

    Page<ProffesorResponseDto> findAll (Predicate predicate, Pageable pageable);

    ProffesorResponseDto findById (Long id);

    ProffesorResponseDto save (ProffesorRequestDto proffesorRequestDto);

    ProffesorResponseDto update (ProffesorRequestDto proffesorRequestDto);

}
