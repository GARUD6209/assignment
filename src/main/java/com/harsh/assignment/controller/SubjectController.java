package com.harsh.assignment.controller;


import com.harsh.assignment.pojo.internal.Subject;
import com.harsh.assignment.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService service;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> createSubject(@RequestBody Subject subject){

        String s=service.create(subject);

        return new ResponseEntity<>("Subject created : " + s, HttpStatus.CREATED);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Set<Subject>> getAllSubject(){

        Set<Subject> subjects=service.getAll();

        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }
}
