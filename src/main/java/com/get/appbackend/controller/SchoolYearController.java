package com.get.appbackend.controller;

import com.get.appbackend.domain.dto.SchoolYearResponseDto;
import com.get.appbackend.service.SchoolYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/schoolYear")
public class SchoolYearController {

    @Autowired
    private SchoolYearService schoolYearService;

    @GetMapping(path = "/findAll")
    public @ResponseBody List<SchoolYearResponseDto> findAll () {
        return schoolYearService.findAll();
    }

}
