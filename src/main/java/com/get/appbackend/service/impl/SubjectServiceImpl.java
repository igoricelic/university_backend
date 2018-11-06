package com.get.appbackend.service.impl;

import com.get.appbackend.dao.SubjectDao;
import com.get.appbackend.domain.Subject;
import com.get.appbackend.domain.dto.ProffesorResponseDto;
import com.get.appbackend.domain.dto.SubjectRequestDto;
import com.get.appbackend.domain.dto.SubjectResponseDto;
import com.get.appbackend.service.SubjectService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    @Override
    public Page<SubjectResponseDto> findAll(Predicate predicate, Pageable pageable) {
        Page<Subject> page = subjectDao.findAll(predicate, pageable);
        List<SubjectResponseDto> result = page.stream().map(subject -> new SubjectResponseDto(subject)).collect(Collectors.toList());
        return new PageImpl<>(result, pageable, page.getTotalElements());
    }

    @Override
    public SubjectResponseDto findById(Long id) {
        if(!subjectDao.existsById(id)) {
            // TODO: please, handle me
        }
        Subject subject = subjectDao.getOne(id);
        SubjectResponseDto subjectResponseDto = new SubjectResponseDto(subject);
        subjectResponseDto.setProffesors(subject.getProffesors().stream().map(proffesor -> new ProffesorResponseDto(proffesor)).collect(Collectors.toList()));
        return subjectResponseDto;
    }

    @Override
    public SubjectResponseDto save(SubjectRequestDto subjectRequestDto) {
        Subject subject = Subject.builder()
                .name(subjectRequestDto.getName())
                .description(subjectRequestDto.getDescription()).build();
        subjectDao.save(subject);
        return new SubjectResponseDto(subject);
    }

    @Override
    public SubjectResponseDto update(SubjectRequestDto subjectRequestDto) {
        if(!subjectDao.existsById(subjectRequestDto.getId())) {
            // TODO: please, handle me
        }
        Subject subject = subjectDao.getOne(subjectRequestDto.getId());
        subject.setName(subjectRequestDto.getName());
        subject.setDescription(subjectRequestDto.getDescription());
        subjectDao.save(subject);
        return new SubjectResponseDto(subject);
    }

}
