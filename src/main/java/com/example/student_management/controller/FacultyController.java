package com.example.student_management.controller;


import com.example.student_management.repository.FacultyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/faculty")
public class FacultyController {

    @Autowired
    private FacultyRepo facultyRepo;

    @PreAuthorize(value = "hasAnyRole('DIRECTOR', 'TEACHER', 'STUDENT')")
    @GetMapping
    public HttpEntity<?> getFaculties() {
        return ResponseEntity.ok().body(facultyRepo.findAll());
    }

    @PreAuthorize(value = "hasRole('DIRECTOR')")
    @PostMapping
    public HttpEntity<?> addFaculty() {

    }


}
