package com.myorganisation.healhub.dto;

import com.myorganisation.healhub.entity.Bill;
import com.myorganisation.healhub.enums.Gender;
import lombok.Data;

@Data
public class PatientResponseDTO {
    private Long id;
    private String name;
    private Integer age;
    private Gender gender;
    private String disease;
    private Bill bill;
}
