package com.example.demojpaonetoone.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demojpaonetoone.model.Child;

public interface ChildJpaRepository extends JpaRepository<Child, Long> {

}
