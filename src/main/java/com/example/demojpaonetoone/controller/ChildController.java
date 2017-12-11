package com.example.demojpaonetoone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demojpaonetoone.model.Child;
import com.example.demojpaonetoone.persistence.ChildJpaRepository;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ChildController {

    @Autowired
    private ChildJpaRepository repository;

    @GetMapping
    public List<Child> children() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Child child(@PathVariable(name = "id") Long id) {
        return repository.findOne(id);
    }

}
