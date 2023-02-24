package com.example.student_management.controller;


import com.example.student_management.entity.Student;
import com.example.student_management.entity.University;
import com.example.student_management.repository.UniverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class univer {

    @Autowired
    private UniverRepo univerRepo;


    @GetMapping("university")
    public List<University> getAll() {
        return univerRepo.findAll();
    }


    @PostMapping("university")
    public String add(@RequestBody University university) {
        univerRepo.save(university);
        return "success";
    }


    @DeleteMapping("university/{id}")
    public String delete(@PathVariable Long id) {
        univerRepo.deleteById(id);
        return "success";
    }

    @PutMapping("editt/{id}")
    public String update(@RequestBody University university, @PathVariable Long id) {
        Optional<University> byId = univerRepo.findById(id);
        if (byId.isPresent()) {
            University editedUniver = byId.get();
            editedUniver.setId(university.getId());
            editedUniver.setName(university.getName());
            editedUniver.setAddress(university.getAddress());
            univerRepo.save(editedUniver);
            return "success";
        } else return "student by this id is not found";
    }
}
