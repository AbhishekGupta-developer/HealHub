package com.myorganisation.healhub.service;

import com.myorganisation.healhub.dto.PatientRequestDTO;
import com.myorganisation.healhub.dto.PatientResponseDTO;
import com.myorganisation.healhub.entity.Bill;
import com.myorganisation.healhub.entity.Patient;
import com.myorganisation.healhub.repository.BillRepository;
import com.myorganisation.healhub.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    BillRepository billRepository;

    @Override
    public PatientResponseDTO addPatient(PatientRequestDTO patientRequestDTO) {
        Patient patient = new Patient();

        patient.setName(patientRequestDTO.getName());
        patient.setAge(patientRequestDTO.getAge());
        patient.setGender(patientRequestDTO.getGender());
        patient.setDisease(patientRequestDTO.getDisease());

        Bill bill = new Bill();

//        bill = billRepository.save(bill); //old code

        patient.setBill(bill);

        bill.setPatient(patient); //new code

        patient = patientRepository.save(patient);

//        bill.setPatient(patient); //old code
//
//        billRepository.save(bill); //old code

        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();

        patientResponseDTO.setId(patient.getId());
        patientResponseDTO.setName(patient.getName());
        patientResponseDTO.setAge(patient.getAge());
        patientResponseDTO.setGender(patient.getGender());
        patientResponseDTO.setDisease(patient.getDisease());
        patientResponseDTO.setBill(patient.getBill());

        return patientResponseDTO;
    }

    @Override
    public PatientResponseDTO getPatient(Long id) {
        Patient patient = patientRepository.findById(id).orElse(null);

        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();

        patientResponseDTO.setId(patient.getId());
        patientResponseDTO.setName(patient.getName());
        patientResponseDTO.setAge(patient.getAge());
        patientResponseDTO.setGender(patient.getGender());
        patientResponseDTO.setDisease(patient.getDisease());
        patientResponseDTO.setBill(patient.getBill());

        return patientResponseDTO;
    }

    @Override
    public List<PatientResponseDTO> getAllPatients() {
        List<Patient> patientList = new ArrayList<>(patientRepository.findAll());

        List<PatientResponseDTO> patientResponseDTOList = new ArrayList<>();

        for(Patient patient : patientList) {
            PatientResponseDTO patientResponseDTO = new PatientResponseDTO();

            patientResponseDTO.setId(patient.getId());
            patientResponseDTO.setName(patient.getName());
            patientResponseDTO.setAge(patient.getAge());
            patientResponseDTO.setGender(patient.getGender());
            patientResponseDTO.setDisease(patient.getDisease());
            patientResponseDTO.setBill(patient.getBill());

            patientResponseDTOList.add(patientResponseDTO);
        }

        return patientResponseDTOList;
    }

    @Override
    public PatientResponseDTO updatePatient(Long id, PatientRequestDTO patientRequestDTO) {
        Patient patient = patientRepository.findById(id).orElse(null);

        patient.setName(patientRequestDTO.getName());
        patient.setAge(patientRequestDTO.getAge());
        patient.setGender(patientRequestDTO.getGender());
        patient.setDisease(patientRequestDTO.getDisease());

        patient = patientRepository.save(patient);

        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();

        patientResponseDTO.setId(id);
        patientResponseDTO.setName(patient.getName());
        patientResponseDTO.setAge(patient.getAge());
        patientResponseDTO.setGender(patient.getGender());
        patientResponseDTO.setDisease(patient.getDisease());
        patientResponseDTO.setBill(patient.getBill());

        return patientResponseDTO;
    }

    @Override
    public String removePatient(Long id) {
        String name = patientRepository.findById(id).orElse(null).getName();

        patientRepository.deleteById(id);

        return "Patient name: " + name + "(" + id + ") has been removed successfully!";
    }
}
