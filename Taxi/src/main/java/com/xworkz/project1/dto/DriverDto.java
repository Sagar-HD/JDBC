package com.xworkz.project1.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DriverDto implements Serializable {
    private String name;
    private int age;
    private int experience;
    private String vehicleName;
    private LocalDate dob;

}
