package com.get.appbackend.controller;

import com.get.appbackend.dao.ProffesorDao;
import com.get.appbackend.domain.Proffesor;
import com.get.appbackend.domain.dto.ProffesorRequestDto;
import com.get.appbackend.domain.dto.ProffesorResponseDto;
import com.get.appbackend.service.ProffesorService;
import com.get.appbackend.utils.ValidationGroup;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/proffesor")
public class ProffesorController {

    @Autowired
    private ProffesorService proffesorService;

    @GetMapping(path = "/findAll")
    public @ResponseBody Page<ProffesorResponseDto> findAll (@QuerydslPredicate(root = Proffesor.class, bindings = ProffesorDao.class) Predicate predicate, Pageable pageable) {
        return proffesorService.findAll(predicate, pageable);
    }

    @GetMapping(path = "/findById")
    public @ResponseBody ProffesorResponseDto findById (@RequestParam(required = true) Long id) {
        return proffesorService.findById(id);
    }

    @PostMapping(path = "/save")
    public @ResponseBody ProffesorResponseDto save (@Validated(ValidationGroup.Save.class) @RequestBody ProffesorRequestDto proffesorRequestDto) {
        return proffesorService.save(proffesorRequestDto);
    }

    @PutMapping(path = "/update")
    public @ResponseBody ProffesorResponseDto update (@Validated(ValidationGroup.Update.class) @RequestBody ProffesorRequestDto proffesorRequestDto) {
        return proffesorService.update(proffesorRequestDto);
    }

}
