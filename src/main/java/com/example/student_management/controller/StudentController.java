package com.example.student_management.controller;

import com.example.student_management.entity.Student;
import com.example.student_management.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;


    @GetMapping("student")
    public List<Student> getAll() {
        return studentRepo.findAll();
    }


    @PostMapping("student")
    public String add(@RequestBody Student student) {
        studentRepo.save(student);
        return "success";
    }


    @DeleteMapping("student/{id}")
    public String delete(@PathVariable Integer id) {
        studentRepo.deleteById(id);
        return "success";
    }

    @PutMapping("editt/{id}")
    public String update(@RequestBody Student student, @PathVariable Integer id) {
        Optional<Student> byId = studentRepo.findById(id);
        if (byId.isPresent()) {
            Student editedStudent = byId.get();
            editedStudent.setFirstName(student.getFirstName());
            editedStudent.setLastName(student.getLastName());
            studentRepo.save(editedStudent);
            return "success";
        } else return "student by this id is not found";
    }
}
