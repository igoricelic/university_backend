package com.get.appbackend.controller;

import com.get.appbackend.dao.StudentDao;
import com.get.appbackend.domain.Student;
import com.get.appbackend.domain.dto.StudentRequestDto;
import com.get.appbackend.domain.dto.StudentResponseDto;
import com.get.appbackend.service.StudentService;
import com.get.appbackend.utils.ValidationGroup;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/findAll")
    public @ResponseBody Page<StudentResponseDto> findAll (@QuerydslPredicate(root = Student.class, bindings = StudentDao.class) Predicate predicate, Pageable pageable) {
        return studentService.findAll(predicate, pageable);
    }

    @GetMapping(path = "/findById")
    public @ResponseBody StudentResponseDto findById (@RequestParam(required = true) Long id) {
        return studentService.findById(id);
    }

    @PostMapping(path = "/save")
    public @ResponseBody StudentResponseDto save (@Validated(ValidationGroup.Save.class) @RequestBody  StudentRequestDto studentRequestDto) {
        return studentService.save(studentRequestDto);
    }

    @PutMapping(path = "/update")
    public @ResponseBody StudentResponseDto update (@Validated(ValidationGroup.Update.class) @RequestBody StudentRequestDto studentRequestDto) {
        return studentService.update(studentRequestDto);
    }

}
