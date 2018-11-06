package com.get.appbackend.controller;

import com.get.appbackend.dao.SubjectDao;
import com.get.appbackend.domain.Subject;
import com.get.appbackend.domain.dto.SubjectRequestDto;
import com.get.appbackend.domain.dto.SubjectResponseDto;
import com.get.appbackend.service.SubjectService;
import com.get.appbackend.utils.ValidationGroup;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping(path = "/findAll")
    public @ResponseBody Page<SubjectResponseDto> findAll (@QuerydslPredicate(root = Subject.class, bindings = SubjectDao.class) Predicate predicate, Pageable pageable) {
        return subjectService.findAll(predicate, pageable);
    }

    @GetMapping(path = "/findById")
    public @ResponseBody SubjectResponseDto findById (@RequestParam(required = true) Long id) {
        return subjectService.findById(id);
    }

    @PostMapping(path = "/save")
    public @ResponseBody SubjectResponseDto save (@Validated(ValidationGroup.Save.class) @RequestBody SubjectRequestDto subjectRequestDto) {
        return subjectService.save(subjectRequestDto);
    }

    @PutMapping(path = "/update")
    public @ResponseBody SubjectResponseDto update (@Validated(ValidationGroup.Update.class) @RequestBody SubjectRequestDto subjectRequestDto) {
        return subjectService.update(subjectRequestDto);
    }

}
