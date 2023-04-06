package com.example.student_management.controller;


import com.example.student_management.entity.Address;
import com.example.student_management.entity.University;
import com.example.student_management.payload.UniversityDto;
import com.example.student_management.repository.AddressRepo;
import com.example.student_management.repository.UniverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequestMapping("university")
@RestController
public class UniversityController {

    @Autowired
    private UniverRepo univerRepo;

    @Autowired
    private AddressRepo addressRepo;


    @PreAuthorize(value = "hasAuthority('READ')")
    @GetMapping
    public List<University> getAll() {
        return univerRepo.findAll();
    }

    @PreAuthorize(value = "hasRole('DIRECTOR')")
    @PostMapping
    public String add(@RequestBody UniversityDto universityDto) {
        Optional<Address> address = addressRepo.findById(universityDto.getAddressId());
        if (address.isPresent()) {
            Address address1 = address.get();
            University university = new University(null, universityDto.getName(), address1);
            univerRepo.save(university);
        } else {
            return "address not found";
        }
        return "success";
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        univerRepo.deleteById(id);
        return "success";
    }

}
