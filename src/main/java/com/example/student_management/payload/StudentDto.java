package com.example.student_management.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private Long id;
    private String lastName;
    private String firstName;
    private String fathersName;
    private int age;
    private String birthdate;
    private String passportNumber;
    private Long groupId;
    private Long addressId;



}
