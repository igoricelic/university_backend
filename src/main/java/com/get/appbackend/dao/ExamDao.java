package com.get.appbackend.dao;

import com.get.appbackend.domain.Exam;
import com.get.appbackend.domain.SchoolYear;
import com.get.appbackend.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamDao extends JpaRepository<Exam, Long> {

    Long countByStudentAndSchoolYear (Student student, SchoolYear schoolYear);

}
