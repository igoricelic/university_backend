package com.get.appbackend.dao;

import com.get.appbackend.domain.QSubject;
import com.get.appbackend.domain.Subject;
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

import java.util.List;

public interface SubjectDao extends JpaRepository<Subject, Long>, QuerydslPredicateExecutor<Subject>, QuerydslBinderCustomizer<QSubject> {

    Page<Subject> findAll (Predicate predicate, Pageable pageable);

    List<Subject> findByIdIn (List<Long> ids);

    @Override
    default void customize(QuerydslBindings bindings, QSubject root) {
        bindings.bind(String.class)
                .first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
    }

}
