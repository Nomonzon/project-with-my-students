package com.example.student_management.controller;
import com.example.student_management.entity.Address;
import com.example.student_management.entity.Group;
import com.example.student_management.entity.Student;
import com.example.student_management.entity.University;
import com.example.student_management.payload.StudentDto;
import com.example.student_management.repository.AddressRepo;
import com.example.student_management.repository.GroupRepo;
import com.example.student_management.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private GroupRepo groupRepo;
    @Autowired
    private AddressRepo addressRepo;


    @GetMapping("student")
    public List<Student> getAll() {
        return studentRepo.findAll();
    }


    @PostMapping("student")
     public String add1(@RequestBody StudentDto studentDto){
        Optional<Address> address = addressRepo.findById(studentDto.getAddressId());
        Optional<Group> group = groupRepo.findById(studentDto.getAddressId());
        if (address.isPresent() && group.isPresent()) {
            Address address1 = address.get();
            Group group1 = group.get();
            Student student = new Student(null,"Umid","Sharipov","Otkir",16,"2023-02-23T14:44:04","AMD12A",address1,group1);
            studentRepo.save(student);
        }  else {
        return "address not found";
    }
        return "success";
    }


    }




/*    @DeleteMapping("student/{id}")
    public String delete(@PathVariable Long id) {
        studentRepo.deleteById(id);
        return "success";
    }

    @PutMapping("editt/{id}")
    public String update(@RequestBody Student student, @PathVariable Long id) {
        Optional<Student> byId = studentRepo.findById(id);
        if (byId.isPresent()) {
            Student editedStudent = byId.get();
            editedStudent.setFirstName(student.getFirstName());
            editedStudent.setLastName(student.getLastName());
            studentRepo.save(editedStudent);
            return "success";
        } else return "student by this id is not found";
    }
}}*/
