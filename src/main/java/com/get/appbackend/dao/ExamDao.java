package com.get.appbackend.dao;

import com.get.appbackend.domain.*;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;

import java.util.Date;
import java.util.Iterator;
import java.util.Optional;

public interface ExamDao extends JpaRepository<Exam, Long>, QuerydslPredicateExecutor<Exam>, QuerydslBinderCustomizer<QExam> {

    Long countByStudentAndSchoolYear (Student student, SchoolYear schoolYear);

    Page<Exam> findAll (Predicate predicate, Pageable pageable);

    @Override
    default void customize(QuerydslBindings bindings, QExam root) {
        bindings.bind(String.class)
                .first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);

        bindings.bind(root.dateAndTime).all((path, value) -> {
            Iterator<? extends Date> it = value.iterator();
            Date from = it.next();
            if (value.size() >= 2) {
                Date to = it.next();
                return Optional.of(path.between(from, to));
            } else {
                return Optional.of(path.goe(from));
            }
        });

    }

}
