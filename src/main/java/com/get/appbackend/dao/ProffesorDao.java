package com.get.appbackend.dao;

import com.get.appbackend.domain.Proffesor;
import com.get.appbackend.domain.QProffesor;
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

public interface ProffesorDao extends JpaRepository<Proffesor, Long>, QuerydslPredicateExecutor<Proffesor>, QuerydslBinderCustomizer<QProffesor> {

    Page<Proffesor> findAll (Predicate predicate, Pageable pageable);

    @Override
    default void customize(QuerydslBindings bindings, QProffesor root) {
        bindings.bind(String.class)
                .first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
    }

}
