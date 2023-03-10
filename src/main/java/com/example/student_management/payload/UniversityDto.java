package com.example.student_management.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UniversityDto {

    private Long id;
    private String name;
    private Long addressId;
}
