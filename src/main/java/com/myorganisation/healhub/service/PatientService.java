package com.myorganisation.healhub.service;

import com.myorganisation.healhub.dto.PatientRequestDTO;
import com.myorganisation.healhub.dto.PatientResponseDTO;

import java.util.List;

public interface PatientService {
    PatientResponseDTO addPatient(PatientRequestDTO patientRequestDTO);
    PatientResponseDTO getPatient(Long id);
    List<PatientResponseDTO> getAllPatients();
    PatientResponseDTO updatePatient(Long id, PatientRequestDTO patientRequestDTO);
    String removePatient(Long id);

}
