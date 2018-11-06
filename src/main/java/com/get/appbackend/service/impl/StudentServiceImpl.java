package com.get.appbackend.service.impl;

import com.get.appbackend.dao.StudentDao;
import com.get.appbackend.domain.Student;
import com.get.appbackend.domain.dto.ExamResponseDto;
import com.get.appbackend.domain.dto.StudentRequestDto;
import com.get.appbackend.domain.dto.StudentResponseDto;
import com.get.appbackend.service.StudentService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Page<StudentResponseDto> findAll(Predicate predicate, Pageable pageable) {
        Page<Student> page = studentDao.findAll(predicate, pageable);
        List<StudentResponseDto> students = page.stream().map(student -> new StudentResponseDto(student)).collect(Collectors.toList());
        return new PageImpl<>(students, pageable, page.getTotalElements());
    }

    @Override
    public StudentResponseDto findById(Long id) {
        if(!studentDao.existsById(id)) {
           // TODO: Please, handle me
        }
        Student student = studentDao.getOne(id);
        StudentResponseDto studentResponseDto = new StudentResponseDto(student);
        studentResponseDto.setExams(student.getExams().stream().filter(exam -> exam.getSuccess()).map(exam -> new ExamResponseDto(exam)).collect(Collectors.toList()));
        return studentResponseDto;
    }

    @Override
    public StudentResponseDto save(StudentRequestDto studentRequestDto) {
        if(studentDao.existsByIndex(studentRequestDto.getIndex())) {
            // TODO: Please, handle me
        }
        Student student = Student.builder()
                .firstName(studentRequestDto.getFirstName())
                .lastName(studentRequestDto.getLastName())
                .index(studentRequestDto.getIndex()).build();
        studentDao.save(student);
        return new StudentResponseDto(student);
    }

    @Override
    public StudentResponseDto update(StudentRequestDto studentRequestDto) {
        if(!studentDao.existsById(studentRequestDto.getId())) {
            // TODO: Please, handle me
        }
        Student student = studentDao.getOne(studentRequestDto.getId());
        if(!student.getIndex().equals(studentRequestDto.getIndex())) {
            if(studentDao.existsByIndex(studentRequestDto.getIndex())) {
                // TODO: Please, handle me
            }
        }
        student.setFirstName(studentRequestDto.getFirstName());
        student.setLastName(studentRequestDto.getLastName());
        student.setIndex(studentRequestDto.getIndex());
        studentDao.save(student);
        return new StudentResponseDto(student);
    }

}
