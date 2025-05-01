package com.myorganisation.healhub.dto;

import com.myorganisation.healhub.enums.Gender;
import com.myorganisation.healhub.enums.Speciality;
import lombok.Data;

@Data
public class DoctorResponseDTO {
    private Long id;
    private String name;
    private Integer age;
    private Gender gender;
    private String designation;
    private Speciality speciality;
}
