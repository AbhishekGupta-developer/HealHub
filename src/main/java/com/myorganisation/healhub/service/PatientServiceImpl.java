package com.myorganisation.healhub.service;

import com.myorganisation.healhub.dto.PatientInputDto;
import com.myorganisation.healhub.dto.PatientOutputDto;
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
    public PatientOutputDto addPatient(PatientInputDto patientInputDto) {
        Patient patient = new Patient();

        patient.setName(patientInputDto.getName());
        patient.setAge(patientInputDto.getAge());
        patient.setGender(patientInputDto.getGender());
        patient.setDisease(patientInputDto.getDisease());

        Bill bill = new Bill();

//        bill = billRepository.save(bill); //old code

        patient.setBill(bill);

        bill.setPatient(patient); //new code

        patient = patientRepository.save(patient);

//        bill.setPatient(patient); //old code
//
//        billRepository.save(bill); //old code

        PatientOutputDto patientOutputDto = new PatientOutputDto();

        patientOutputDto.setId(patient.getId());
        patientOutputDto.setName(patient.getName());
        patientOutputDto.setAge(patient.getAge());
        patientOutputDto.setGender(patient.getGender());
        patientOutputDto.setDisease(patient.getDisease());
        patientOutputDto.setBill(patient.getBill());

        return patientOutputDto;
    }

    @Override
    public PatientOutputDto getPatient(Long id) {
        Patient patient = patientRepository.findById(id).orElse(null);

        PatientOutputDto patientOutputDto = new PatientOutputDto();

        patientOutputDto.setId(patient.getId());
        patientOutputDto.setName(patient.getName());
        patientOutputDto.setAge(patient.getAge());
        patientOutputDto.setGender(patient.getGender());
        patientOutputDto.setDisease(patient.getDisease());
        patientOutputDto.setBill(patient.getBill());

        return patientOutputDto;
    }

    @Override
    public List<PatientOutputDto> getAllPatients() {
        List<Patient> patientList = new ArrayList<>(patientRepository.findAll());

        List<PatientOutputDto> patientOutputDtoList = new ArrayList<>();

        for(Patient patient : patientList) {
            PatientOutputDto patientOutputDto = new PatientOutputDto();

            patientOutputDto.setId(patient.getId());
            patientOutputDto.setName(patient.getName());
            patientOutputDto.setAge(patient.getAge());
            patientOutputDto.setGender(patient.getGender());
            patientOutputDto.setDisease(patient.getDisease());
            patientOutputDto.setBill(patient.getBill());

            patientOutputDtoList.add(patientOutputDto);
        }

        return patientOutputDtoList;
    }

    @Override
    public PatientOutputDto updatePatient(Long id, PatientInputDto patientInputDto) {
        Patient patient = patientRepository.findById(id).orElse(null);

        patient.setName(patientInputDto.getName());
        patient.setAge(patientInputDto.getAge());
        patient.setGender(patientInputDto.getGender());
        patient.setDisease(patientInputDto.getDisease());

        patient = patientRepository.save(patient);

        PatientOutputDto patientOutputDto = new PatientOutputDto();

        patientOutputDto.setId(id);
        patientOutputDto.setName(patient.getName());
        patientOutputDto.setAge(patient.getAge());
        patientOutputDto.setGender(patient.getGender());
        patientOutputDto.setDisease(patient.getDisease());
        patientOutputDto.setBill(patient.getBill());

        return patientOutputDto;
    }

    @Override
    public String removePatient(Long id) {
        String name = patientRepository.findById(id).orElse(null).getName();

        patientRepository.deleteById(id);

        return "Patient name: " + name + "(" + id + ") has been removed successfully!";
    }
}
