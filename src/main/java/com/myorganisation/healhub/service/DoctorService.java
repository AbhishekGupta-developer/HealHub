package com.myorganisation.healhub.service;

import com.myorganisation.healhub.dto.DoctorInputDto;
import com.myorganisation.healhub.dto.DoctorOutputDto;
import com.myorganisation.healhub.enums.Gender;
import com.myorganisation.healhub.enums.Speciality;

import java.util.List;

public interface DoctorService {

    DoctorOutputDto getDoctor(Long id);
    List<DoctorOutputDto> getAllDoctors();
    DoctorOutputDto addDoctor(DoctorInputDto doctorInputDto);
    DoctorOutputDto updateDoctor(Long id, DoctorInputDto doctorInputDto);
    String removeDoctor(Long id);
    List<DoctorOutputDto> search(Gender gender, Speciality speciality);
    List<DoctorOutputDto> search(Speciality speciality);
}
