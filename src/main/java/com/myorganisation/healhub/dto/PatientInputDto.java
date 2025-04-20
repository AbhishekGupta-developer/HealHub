package com.myorganisation.healhub.dto;

import com.myorganisation.healhub.enums.Gender;
import lombok.Data;

@Data
public class PatientInputDto {
    private String name;
    private Integer age;
    private Gender gender;
    private String disease;
}
