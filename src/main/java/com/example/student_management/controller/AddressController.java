package com.example.student_management.controller;

import com.example.student_management.entity.Address;
import com.example.student_management.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AddressController {

    @Autowired
    private AddressRepo addressRepo;


    @GetMapping("address")
    public List<Address> getAll() {
        return addressRepo.findAll();
    }


    @PostMapping("address")
    public String add(@RequestBody Address address) {
        addressRepo.save(address);
        return "success";
    }


//    @DeleteMapping("address/{id}")
//    public String delete(@PathVariable Long id) {
//        addressRepo.deleteById(id);
//        return "success";
//    }
//
//    @PutMapping("editt/{id}")
//    public String update(@RequestBody Address address, @PathVariable Long id) {
//        Optional<Address> byId = addressRepo.findById(id);
//        if (byId.isPresent()) {
//            Address editedAddress = byId.get();
//            editedAddress.setId(address.getId());
//            editedAddress.setCountry(address.getCountry());
//            editedAddress.setStreet(address.getStreet());
//            editedAddress.setHomeNumber(address.getHomeNumber());
//            editedAddress.setRegion(address.getRegion());
//            addressRepo.save(editedAddress);
//            return "success";
//        } else return "faculty by this id is not found";
//    }


}
