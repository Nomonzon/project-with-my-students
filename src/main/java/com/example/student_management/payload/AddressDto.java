package com.example.student_management.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private Long id;
    private String country;
    private String region;
    private String street;
    private String homeNumber;

}
