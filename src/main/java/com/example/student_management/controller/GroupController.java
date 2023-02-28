package com.example.student_management.controller;

import com.example.student_management.entity.Faculty;
import com.example.student_management.entity.Group;
import com.example.student_management.repository.FacultyRepo;
import com.example.student_management.repository.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GroupController {

    @Autowired
    private GroupRepo groupRepo;


    @GetMapping("group")
    public List<Group> getAll() {
        return groupRepo.findAll();
    }


    @PostMapping("group")
    public String add(@RequestBody Group group) {
        groupRepo.save(group);
        return "success";
    }


    @DeleteMapping("group/{id}")
    public String delete(@PathVariable Long id) {
        groupRepo.deleteById(id);
        return "success";
    }

    @PutMapping("editt/{id}")
    public String update(@RequestBody Group group, @PathVariable Long id) {
        Optional<Group> byId = groupRepo.findById(id);
        if (byId.isPresent()) {
            Group editedGroup = byId.get();
            editedGroup.setNumberOfGroup(group.getNumberOfGroup());
            editedGroup.setId(group.getId());
            editedGroup.setFaculty(group.getFaculty());
            groupRepo.save(editedGroup);
            return "success";
        } else return "group by this id is not found";
    }
}
