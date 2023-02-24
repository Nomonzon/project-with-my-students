package com.example.student_management.controller;


import com.example.student_management.entity.Address;
import com.example.student_management.entity.University;
import com.example.student_management.payload.UniversityDto;
import com.example.student_management.repository.AddressRepo;
import com.example.student_management.repository.UniverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UniversityController {

    @Autowired
    private UniverRepo univerRepo;

    @Autowired
    private AddressRepo addressRepo;

    @GetMapping("university")
    public List<University> getAll() {
        return univerRepo.findAll();
    }


    @PostMapping("university")
    public String add(@RequestBody UniversityDto universityDto) {
        Optional<Address> address = addressRepo.findById(universityDto.getAddressId());
        if (address.isPresent()) {
            Address address1 = address.get();
            University university = new University(null, "TATU", address1);
            univerRepo.save(university);
        } else {
            return "address not found";
        }
        return "success";
    }


    @DeleteMapping("university/{id}")
    public String delete(@PathVariable Long id) {
        univerRepo.deleteById(id);
        return "success";
    }

}
