package com.get.appbackend.service.impl;

import com.get.appbackend.dao.ProffesorDao;
import com.get.appbackend.dao.SubjectDao;
import com.get.appbackend.domain.Proffesor;
import com.get.appbackend.domain.Subject;
import com.get.appbackend.domain.dto.ProffesorRequestDto;
import com.get.appbackend.domain.dto.ProffesorResponseDto;
import com.get.appbackend.domain.dto.SubjectResponseDto;
import com.get.appbackend.exceptions.ResourceNotFoundException;
import com.get.appbackend.service.ProffesorService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProffesorServiceImpl implements ProffesorService {

    @Autowired
    private ProffesorDao proffesorDao;

    @Autowired
    private SubjectDao subjectDao;

    @Override
    public Page<ProffesorResponseDto> findAll(Predicate predicate, Pageable pageable) {
        Page<Proffesor> page = proffesorDao.findAll(predicate, pageable);
        List<ProffesorResponseDto> proffesors = page.stream().map(proffesor -> new ProffesorResponseDto(proffesor)).collect(Collectors.toList());
        return new PageImpl<>(proffesors);
    }

    @Override
    public ProffesorResponseDto findById(Long id) {
        if(!proffesorDao.existsById(id)) {
            throw new ResourceNotFoundException("Proffesor with id: "+id+" not found!");
        }
        Proffesor proffesor = proffesorDao.getOne(id);
        ProffesorResponseDto proffesorResponseDto = new ProffesorResponseDto(proffesor);
        proffesorResponseDto.setSubjects(proffesor.getSubjects().stream().map(subject -> new SubjectResponseDto(subject)).collect(Collectors.toList()));
        return proffesorResponseDto;
    }

    @Override
    public ProffesorResponseDto save(ProffesorRequestDto proffesorRequestDto) {
        Proffesor proffesor = Proffesor.builder()
                .firstName(proffesorRequestDto.getFirstName())
                .lastName(proffesorRequestDto.getLastName()).build();
        proffesorDao.save(proffesor);

        List<Subject> subjects = subjectDao.findByIdIn(proffesorRequestDto.getSubjects());
        subjects.forEach(subject -> subject.getProffesors().add(proffesor));
        subjectDao.saveAll(subjects);

        ProffesorResponseDto proffesorResponseDto = new ProffesorResponseDto(proffesor);
        proffesorResponseDto.setTotalSubjects(subjects.size());
        proffesorResponseDto.setSubjects(subjects.stream().map(subject -> new SubjectResponseDto(subject)).collect(Collectors.toList()));
        return proffesorResponseDto;
    }

    @Override
    public ProffesorResponseDto update(ProffesorRequestDto proffesorRequestDto) {
        if(!proffesorDao.existsById(proffesorRequestDto.getId())) {
            throw new ResourceNotFoundException("Proffesor with id: "+proffesorRequestDto.getId()+" not found!");
        }
        Proffesor proffesor = proffesorDao.getOne(proffesorRequestDto.getId());
        proffesor.setFirstName(proffesorRequestDto.getFirstName());
        proffesor.setLastName(proffesorRequestDto.getLastName());
        proffesorDao.save(proffesor);
        return new ProffesorResponseDto(proffesor);
    }

}
