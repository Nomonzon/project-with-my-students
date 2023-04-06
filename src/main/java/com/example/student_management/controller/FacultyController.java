package com.example.student_management.controller;

import com.example.student_management.entity.Faculty;
import com.example.student_management.entity.University;
import com.example.student_management.payload.FacultyDto;
import com.example.student_management.repository.FacultyRepo;
import com.example.student_management.repository.UniverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/faculty")
@RestController
public class FacultyController {


    @Autowired
    private FacultyRepo facultyRepo;

    @Autowired
    private UniverRepo univerRepo;

    @PreAuthorize(value = "hasAuthority('READ')")
    @GetMapping
    public List<Faculty> getAll() {
        return facultyRepo.findAll();
    }

    @PreAuthorize(value = "hasRole('DIRECTOR')")
    @PostMapping
    public String add(@RequestBody FacultyDto facultyDto) {
        Optional<University> address = univerRepo.findById(facultyDto.getUniversityId());
        if (address.isPresent()) {
            University university1 = address.get();
            Faculty faculty = new Faculty(null, facultyDto.getName(), university1);
            facultyRepo.save(faculty);
        } else {
            return "address not found";
        }
        return "success";
    }

    @PreAuthorize(value = "hasRole('DIRECTOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        facultyRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize(value = "hasRole('DIRECTOR')")
    @PutMapping("/{id}")
    public ResponseEntity<Faculty> update(@RequestBody Faculty faculty, @PathVariable Long id) {
        Optional<Faculty> byId = facultyRepo.findById(id);
        if (byId.isPresent()) {
            Faculty editedFaculty = byId.get();
            editedFaculty.setId(faculty.getId());
            editedFaculty.setName(faculty.getName());
            editedFaculty.setUniversity(faculty.getUniversity());
            facultyRepo.save(editedFaculty);
            return ResponseEntity.ok(facultyRepo.save(editedFaculty));
        }return ResponseEntity.notFound().build();
    }

    @PreAuthorize(value = "hasAuthority('READ_BY_ID')")
    @GetMapping("/{id}")
    public HttpEntity<?> getProduct(@PathVariable Long id) {
        Optional<Faculty> facultyOptional = facultyRepo.findById(id);
        return ResponseEntity.status(facultyOptional.isPresent() ? 200 : 404).body(facultyOptional.orElse(null));

}}