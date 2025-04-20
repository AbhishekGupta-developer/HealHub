package com.myorganisation.healhub.entity;

import com.myorganisation.healhub.enums.Gender;
import com.myorganisation.healhub.enums.Speciality;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "doctor")
@Data
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String designation;

    @Enumerated(EnumType.STRING)
    private Speciality speciality;
}
