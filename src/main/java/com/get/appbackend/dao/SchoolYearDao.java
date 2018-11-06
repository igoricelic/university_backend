package com.get.appbackend.dao;

import com.get.appbackend.domain.SchoolYear;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolYearDao extends JpaRepository<SchoolYear, Long> {
}
