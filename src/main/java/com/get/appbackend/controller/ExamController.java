package com.get.appbackend.controller;

import com.get.appbackend.domain.dto.ExamRequestDto;
import com.get.appbackend.domain.dto.ExamResponseDto;
import com.get.appbackend.service.ExamService;
import com.get.appbackend.utils.ValidationGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/exam")
public class ExamController {

    @Autowired
    private ExamService examService;

    @GetMapping(path = "/findAll")
    public @ResponseBody Page<ExamResponseDto> findAll (Pageable pageable) {
        return examService.findAll(pageable);
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
