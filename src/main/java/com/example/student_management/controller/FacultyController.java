package com.example.student_management.controller;

import com.example.student_management.entity.Faculty;
import com.example.student_management.entity.University;
import com.example.student_management.payload.FacultyDto;
import com.example.student_management.repository.FacultyRepo;
import com.example.student_management.repository.UniverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class FacultyController {


    @Autowired
    private FacultyRepo facultyRepo;

    @Autowired
    private UniverRepo univerRepo;


    @GetMapping("faculty")
    public List<Faculty> getAll() {
        return facultyRepo.findAll();
    }


    @PostMapping("faculty")
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


    @DeleteMapping("faculty/{id}")
    public String delete(@PathVariable Long id) {
        facultyRepo.deleteById(id);
        return "success";
    }

//    @PutMapping("editt/{id}")
//    public String update(@RequestBody Faculty faculty, @PathVariable Long id) {
//        Optional<Faculty> byId = facultyRepo.findById(id);
//        if (byId.isPresent()) {
//            Faculty editedFaculty = byId.get();
//            editedFaculty.setId(faculty.getId());
//            editedFaculty.setName(faculty.getName());
//            editedFaculty.setUniversity(faculty.getUniversity());
//            facultyRepo.save(editedFaculty);
//            return "success";
//        } else return "faculty by this id is not found";
//    }
}
