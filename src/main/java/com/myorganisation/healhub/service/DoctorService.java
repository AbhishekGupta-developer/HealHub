package com.myorganisation.healhub.service;

import com.myorganisation.healhub.dto.DoctorRequestDTO;
import com.myorganisation.healhub.dto.DoctorResponseDTO;
import com.myorganisation.healhub.enums.Gender;
import com.myorganisation.healhub.enums.Speciality;

import java.util.List;

public interface DoctorService {

    DoctorResponseDTO getDoctor(Long id);
    List<DoctorResponseDTO> getAllDoctors();
    DoctorResponseDTO addDoctor(DoctorRequestDTO doctorRequestDTO);
    DoctorResponseDTO updateDoctor(Long id, DoctorRequestDTO doctorRequestDTO);
    String removeDoctor(Long id);
    List<DoctorResponseDTO> search(Gender gender, Speciality speciality);
    List<DoctorResponseDTO> search(Speciality speciality);
}
