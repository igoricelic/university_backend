package com.get.appbackend.service.impl;

import com.get.appbackend.dao.*;
import com.get.appbackend.domain.*;
import com.get.appbackend.domain.dto.ExamRequestDto;
import com.get.appbackend.domain.dto.ExamResponseDto;
import com.get.appbackend.domain.dto.StudentResponseDto;
import com.get.appbackend.service.ExamService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamDao examDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private SubjectDao subjectDao;

    @Autowired
    private ProffesorDao proffesorDao;

    @Autowired
    private SchoolYearDao schoolYearDao;

    @Override
    public Page<ExamResponseDto> findAll(Predicate predicate, Pageable pageable) {
        Page<Exam> page = examDao.findAll(predicate, pageable);
        List<ExamResponseDto> result = page.stream().map(exam -> new ExamResponseDto(exam)).collect(Collectors.toList());

        return new PageImpl<>(result, pageable, page.getTotalElements());
    }

    @Override
    public ExamResponseDto findById(Long id) {
        if(!examDao.existsById(id)) {
            // exception
        }
        Exam exam = examDao.getOne(id);
        ExamResponseDto examResponseDto = new ExamResponseDto(exam);
        return examResponseDto;
    }

    @Override
    public ExamResponseDto save(ExamRequestDto examRequestDto) {
        if(!studentDao.existsById(examRequestDto.getStudentId()) || !schoolYearDao.existsById(examRequestDto.getSchoolYearId()) ||
                !subjectDao.existsById(examRequestDto.getSubjectId()) || !proffesorDao.existsById(examRequestDto.getProffesorId())) {
            // TODO: Exception
        }
        Student student = studentDao.getOne(examRequestDto.getStudentId());
        Subject subject = subjectDao.getOne(examRequestDto.getSubjectId());
        Proffesor proffesor = proffesorDao.getOne(examRequestDto.getProffesorId());
        SchoolYear schoolYear = schoolYearDao.getOne(examRequestDto.getSchoolYearId());

        if(!proffesor.getSubjects().contains(subject)) {
            // TODO: Exception
        }

        if(examDao.countByStudentAndSchoolYear(student, schoolYear) >= 5) {
            // TODO: Exception
        }

        Exam exam = Exam.builder().dateAndTime(new Date()).proffesor(proffesor).subject(subject)
                .student(student).schoolYear(schoolYear).success(examRequestDto.getResult()).build();

        examDao.save(exam);
        ExamResponseDto examResponseDto = new ExamResponseDto(exam);
        examResponseDto.setStudentResponseDto(new StudentResponseDto(student));
        return examResponseDto;
    }

}
