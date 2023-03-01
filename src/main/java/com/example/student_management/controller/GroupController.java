package com.example.student_management.controller;

import com.example.student_management.entity.Faculty;
import com.example.student_management.entity.Group;
import com.example.student_management.entity.University;
import com.example.student_management.payload.GroupDto;
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

    @Autowired
    private FacultyRepo facultyRepo;


    @GetMapping("group")
    public List<Group> getAll() {
        return groupRepo.findAll();
    }


    @PostMapping("group")
    public String add(@RequestBody GroupDto groupDto) {
        Optional<Faculty> address = facultyRepo.findById(groupDto.getFacultyId());
        if (address.isPresent()) {
            Faculty faculty1 = address.get();
            Group group = new Group(null, groupDto.getNumbOfGroup(), faculty1);
            groupRepo.save(group);
        } else {
            return "address not found";
        }
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
