package com.myorganisation.healhub.service;

import com.myorganisation.healhub.dto.DoctorRequestDTO;
import com.myorganisation.healhub.dto.DoctorResponseDTO;
import com.myorganisation.healhub.entity.Doctor;
import com.myorganisation.healhub.enums.Gender;
import com.myorganisation.healhub.enums.Speciality;
import com.myorganisation.healhub.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public DoctorResponseDTO getDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElse(null);

        DoctorResponseDTO doctorResponseDTO = new DoctorResponseDTO();

        doctorResponseDTO.setId(doctor.getId());
        doctorResponseDTO.setName(doctor.getName());
        doctorResponseDTO.setAge(doctor.getAge());
        doctorResponseDTO.setGender(doctor.getGender());
        doctorResponseDTO.setDesignation(doctor.getDesignation());
        doctorResponseDTO.setSpeciality(doctor.getSpeciality());

        return doctorResponseDTO;
    }

    @Override
    public List<DoctorResponseDTO> getAllDoctors() {

        List<Doctor> doctorList = new ArrayList<>(doctorRepository.findAll());

        List<DoctorResponseDTO> doctorResponseDTOList = new ArrayList<>();

        for(Doctor doctor : doctorList) {

            DoctorResponseDTO doctorResponseDTO = new DoctorResponseDTO();

            doctorResponseDTO.setId(doctor.getId());
            doctorResponseDTO.setName(doctor.getName());
            doctorResponseDTO.setAge(doctor.getAge());
            doctorResponseDTO.setGender(doctor.getGender());
            doctorResponseDTO.setDesignation(doctor.getDesignation());
            doctorResponseDTO.setSpeciality(doctor.getSpeciality());

            doctorResponseDTOList.add(doctorResponseDTO);
        }

        return doctorResponseDTOList;
    }

    @Override
    public DoctorResponseDTO addDoctor(DoctorRequestDTO doctorRequestDTO) {
        Doctor doctor = new Doctor();

        doctor.setName(doctorRequestDTO.getName());
        doctor.setAge(doctorRequestDTO.getAge());
        doctor.setGender(doctorRequestDTO.getGender());
        doctor.setDesignation(doctorRequestDTO.getDesignation());
        doctor.setSpeciality(doctorRequestDTO.getSpeciality());

        doctor = doctorRepository.save(doctor);

        DoctorResponseDTO doctorResponseDTO = new DoctorResponseDTO();

        doctorResponseDTO.setId(doctor.getId());
        doctorResponseDTO.setName(doctor.getName());
        doctorResponseDTO.setAge(doctor.getAge());
        doctorResponseDTO.setGender(doctor.getGender());
        doctorResponseDTO.setDesignation(doctor.getDesignation());
        doctorResponseDTO.setSpeciality(doctor.getSpeciality());

        return doctorResponseDTO;
    }

    @Override
    public DoctorResponseDTO updateDoctor(Long id, DoctorRequestDTO doctorRequestDTO) {
        Doctor doctor = new Doctor();

        doctor.setId(id);
        doctor.setName(doctorRequestDTO.getName());
        doctor.setAge(doctorRequestDTO.getAge());
        doctor.setGender(doctorRequestDTO.getGender());
        doctor.setDesignation(doctorRequestDTO.getDesignation());
        doctor.setSpeciality(doctorRequestDTO.getSpeciality());

        doctor = doctorRepository.save(doctor);

        DoctorResponseDTO doctorResponseDTO = new DoctorResponseDTO();

        doctorResponseDTO.setId(doctor.getId());
        doctorResponseDTO.setName(doctor.getName());
        doctorResponseDTO.setAge(doctor.getAge());
        doctorResponseDTO.setGender(doctor.getGender());
        doctorResponseDTO.setDesignation(doctor.getDesignation());
        doctorResponseDTO.setSpeciality(doctor.getSpeciality());

        return doctorResponseDTO;
    }

    @Override
    public String removeDoctor(Long id) {
        String name = doctorRepository.findById(id).orElse(null).getName();

        doctorRepository.deleteById(id);

        return "Doctor name: " + name + " and their ID: " + id + " has been removed successfully!";
    }

    @Override
    public List<DoctorResponseDTO> search(Gender gender, Speciality speciality) {
        List<Doctor> doctorList = doctorRepository.findByGenderAndSpeciality(gender, speciality);
        List<DoctorResponseDTO> doctorResponseDTOList = new ArrayList<>();

        for(Doctor doctor : doctorList) {
            DoctorResponseDTO doctorResponseDTO = new DoctorResponseDTO();

            doctorResponseDTO.setId(doctor.getId());
            doctorResponseDTO.setName(doctor.getName());
            doctorResponseDTO.setAge(doctor.getAge());
            doctorResponseDTO.setGender(doctor.getGender());
            doctorResponseDTO.setDesignation(doctor.getDesignation());
            doctorResponseDTO.setSpeciality(doctor.getSpeciality());

            doctorResponseDTOList.add(doctorResponseDTO);
        }

        return doctorResponseDTOList;
    }

    @Override
    public List<DoctorResponseDTO> search(Speciality speciality) {
        List<Doctor> doctorList = doctorRepository.findBySpeciality(speciality);
        List<DoctorResponseDTO> doctorResponseDTOList = new ArrayList<>();

        for(Doctor doctor : doctorList) {
            DoctorResponseDTO doctorResponseDTO = new DoctorResponseDTO();

            doctorResponseDTO.setId(doctor.getId());
            doctorResponseDTO.setName(doctor.getName());
            doctorResponseDTO.setAge(doctor.getAge());
            doctorResponseDTO.setGender(doctor.getGender());
            doctorResponseDTO.setDesignation(doctor.getDesignation());
            doctorResponseDTO.setSpeciality(doctor.getSpeciality());

            doctorResponseDTOList.add(doctorResponseDTO);
        }

        return doctorResponseDTOList;
    }

}
