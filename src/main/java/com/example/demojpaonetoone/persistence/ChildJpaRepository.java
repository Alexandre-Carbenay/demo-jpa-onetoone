package com.example.demojpaonetoone.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.example.demojpaonetoone.model.Child;
import com.querydsl.core.types.Predicate;

public interface ChildJpaRepository extends JpaRepository<Child, Long>, QueryDslPredicateExecutor<Child> {

    @Override
    @EntityGraph("Child.withParent")
    List<Child> findAll();

    @Override
    @EntityGraph("Child.withParent")
    List<Child> findAll(Predicate predicate);

}
