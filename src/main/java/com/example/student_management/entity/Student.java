package com.example.student_management.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastName;
    private String firstName;
    private String fathersName;
    private int age;
    private String birthdate;
    private String passportNumber;
    @ManyToOne // MANY students To ONE Address
    private Address address;
    @ManyToOne
    private Group group;
    @OneToMany
    private List<Subject> subject;

}
