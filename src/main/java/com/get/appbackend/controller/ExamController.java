package com.get.appbackend.controller;

import com.get.appbackend.dao.ExamDao;
import com.get.appbackend.dao.ProffesorDao;
import com.get.appbackend.domain.Exam;
import com.get.appbackend.domain.Proffesor;
import com.get.appbackend.domain.dto.ExamRequestDto;
import com.get.appbackend.domain.dto.ExamResponseDto;
import com.get.appbackend.service.ExamService;
import com.get.appbackend.utils.ValidationGroup;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/exam")
public class ExamController {

    @Autowired
    private ExamService examService;

    @GetMapping(path = "/findAll")
    public @ResponseBody Page<ExamResponseDto> findAll (@QuerydslPredicate(root = Exam.class, bindings = ExamDao.class) Predicate predicate, Pageable pageable) {
        return examService.findAll(predicate, pageable);
    }

    @GetMapping(path = "/findById")
    public @ResponseBody ExamResponseDto findById (@RequestParam(required = true) Long id) {
        return examService.findById(id);
    }

    @PostMapping(path = "/save")
    public @ResponseBody ExamResponseDto save (@Validated(ValidationGroup.Save.class) @RequestBody ExamRequestDto examRequestDto) {
        return examService.save(examRequestDto);
    }

}
