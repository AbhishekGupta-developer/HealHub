package com.myorganisation.healhub.service;

import com.myorganisation.healhub.dto.PatientInputDto;
import com.myorganisation.healhub.dto.PatientOutputDto;

import java.util.List;

public interface PatientService {
    PatientOutputDto addPatient(PatientInputDto patientInputDto);
    PatientOutputDto getPatient(Long id);
    List<PatientOutputDto> getAllPatients();
    PatientOutputDto updatePatient(Long id, PatientInputDto patientInputDto);
    String removePatient(Long id);

}
