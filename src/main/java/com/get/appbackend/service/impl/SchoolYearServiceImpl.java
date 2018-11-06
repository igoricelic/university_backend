package com.get.appbackend.service.impl;

import com.get.appbackend.dao.SchoolYearDao;
import com.get.appbackend.domain.SchoolYear;
import com.get.appbackend.domain.dto.SchoolYearResponseDto;
import com.get.appbackend.service.SchoolYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolYearServiceImpl implements SchoolYearService {

    @Autowired
    private SchoolYearDao schoolYearDao;

    @Override
    public List<SchoolYearResponseDto> findAll() {
        List<SchoolYear> schoolYears = schoolYearDao.findAll();
        return schoolYears.stream().map(schoolYear -> new SchoolYearResponseDto(schoolYear)).collect(Collectors.toList());
    }

}
