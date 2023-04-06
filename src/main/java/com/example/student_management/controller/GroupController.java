package com.example.student_management.controller;

import com.example.student_management.entity.Faculty;
import com.example.student_management.entity.Group;
import com.example.student_management.payload.GroupDto;
import com.example.student_management.repository.FacultyRepo;
import com.example.student_management.repository.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequestMapping("api/group")

@RestController
public class GroupController {

    @Autowired
    private GroupRepo groupRepo;

    @Autowired
    private FacultyRepo facultyRepo;

@PreAuthorize(value = "hasAuthority('READ')")
    @GetMapping
    public List<Group> getAll() {
        return groupRepo.findAll();
    }

    @PreAuthorize(value = "hasRole('DIRECTOR')")
    @PostMapping
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

    @PreAuthorize(value = "hasRole('DIRECTOR')")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        groupRepo.deleteById(id);
        return "success";
    }
    @PreAuthorize(value = "hasRole('DIRECTOR')")
    @PutMapping("/{id}")
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
    @PreAuthorize(value = "hasAuthority('READ_BY_ID')")
    @GetMapping("/{id}")
    public HttpEntity<?> getProduct(@PathVariable Long id) {
        Optional<Group> groupOptional = groupRepo.findById(id);
        return ResponseEntity.status(groupOptional.isPresent() ? 200 : 404).body(groupOptional.orElse(null));
}}
