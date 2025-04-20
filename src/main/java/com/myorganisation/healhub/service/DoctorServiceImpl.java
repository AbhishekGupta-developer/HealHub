package com.myorganisation.healhub.service;

import com.myorganisation.healhub.dto.DoctorInputDto;
import com.myorganisation.healhub.dto.DoctorOutputDto;
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
    public DoctorOutputDto getDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElse(null);

        DoctorOutputDto doctorOutputDto = new DoctorOutputDto();

        doctorOutputDto.setId(doctor.getId());
        doctorOutputDto.setName(doctor.getName());
        doctorOutputDto.setAge(doctor.getAge());
        doctorOutputDto.setGender(doctor.getGender());
        doctorOutputDto.setDesignation(doctor.getDesignation());
        doctorOutputDto.setSpeciality(doctor.getSpeciality());

        return doctorOutputDto;
    }

    @Override
    public List<DoctorOutputDto> getAllDoctors() {

        List<Doctor> doctorList = new ArrayList<>(doctorRepository.findAll());

        List<DoctorOutputDto> doctorOutputDtoList = new ArrayList<>();

        for(Doctor doctor : doctorList) {

            DoctorOutputDto doctorOutputDto = new DoctorOutputDto();

            doctorOutputDto.setId(doctor.getId());
            doctorOutputDto.setName(doctor.getName());
            doctorOutputDto.setAge(doctor.getAge());
            doctorOutputDto.setGender(doctor.getGender());
            doctorOutputDto.setDesignation(doctor.getDesignation());
            doctorOutputDto.setSpeciality(doctor.getSpeciality());

            doctorOutputDtoList.add(doctorOutputDto);
        }

        return doctorOutputDtoList;
    }

    @Override
    public DoctorOutputDto addDoctor(DoctorInputDto doctorInputDto) {
        Doctor doctor = new Doctor();

        doctor.setName(doctorInputDto.getName());
        doctor.setAge(doctorInputDto.getAge());
        doctor.setGender(doctorInputDto.getGender());
        doctor.setDesignation(doctorInputDto.getDesignation());
        doctor.setSpeciality(doctorInputDto.getSpeciality());

        doctor = doctorRepository.save(doctor);

        DoctorOutputDto doctorOutputDto = new DoctorOutputDto();

        doctorOutputDto.setId(doctor.getId());
        doctorOutputDto.setName(doctor.getName());
        doctorOutputDto.setAge(doctor.getAge());
        doctorOutputDto.setGender(doctor.getGender());
        doctorOutputDto.setDesignation(doctor.getDesignation());
        doctorOutputDto.setSpeciality(doctor.getSpeciality());

        return doctorOutputDto;
    }

    @Override
    public DoctorOutputDto updateDoctor(Long id, DoctorInputDto doctorInputDto) {
        Doctor doctor = new Doctor();

        doctor.setId(id);
        doctor.setName(doctorInputDto.getName());
        doctor.setAge(doctorInputDto.getAge());
        doctor.setGender(doctorInputDto.getGender());
        doctor.setDesignation(doctorInputDto.getDesignation());
        doctor.setSpeciality(doctorInputDto.getSpeciality());

        doctor = doctorRepository.save(doctor);

        DoctorOutputDto doctorOutputDto = new DoctorOutputDto();

        doctorOutputDto.setId(doctor.getId());
        doctorOutputDto.setName(doctor.getName());
        doctorOutputDto.setAge(doctor.getAge());
        doctorOutputDto.setGender(doctor.getGender());
        doctorOutputDto.setDesignation(doctor.getDesignation());
        doctorOutputDto.setSpeciality(doctor.getSpeciality());

        return doctorOutputDto;
    }

    @Override
    public String removeDoctor(Long id) {
        String name = doctorRepository.findById(id).orElse(null).getName();

        doctorRepository.deleteById(id);

        return "Doctor name: " + name + " and their ID: " + id + " has been removed successfully!";
    }

    @Override
    public List<DoctorOutputDto> search(Gender gender, Speciality speciality) {
        List<Doctor> doctorList = doctorRepository.findByGenderAndSpeciality(gender, speciality);
        List<DoctorOutputDto> doctorOutputDtoList = new ArrayList<>();

        for(Doctor doctor : doctorList) {
            DoctorOutputDto doctorOutputDto = new DoctorOutputDto();

            doctorOutputDto.setId(doctor.getId());
            doctorOutputDto.setName(doctor.getName());
            doctorOutputDto.setAge(doctor.getAge());
            doctorOutputDto.setGender(doctor.getGender());
            doctorOutputDto.setDesignation(doctor.getDesignation());
            doctorOutputDto.setSpeciality(doctor.getSpeciality());

            doctorOutputDtoList.add(doctorOutputDto);
        }

        return doctorOutputDtoList;
    }

    @Override
    public List<DoctorOutputDto> search(Speciality speciality) {
        List<Doctor> doctorList = doctorRepository.findBySpeciality(speciality);
        List<DoctorOutputDto> doctorOutputDtoList = new ArrayList<>();

        for(Doctor doctor : doctorList) {
            DoctorOutputDto doctorOutputDto = new DoctorOutputDto();

            doctorOutputDto.setId(doctor.getId());
            doctorOutputDto.setName(doctor.getName());
            doctorOutputDto.setAge(doctor.getAge());
            doctorOutputDto.setGender(doctor.getGender());
            doctorOutputDto.setDesignation(doctor.getDesignation());
            doctorOutputDto.setSpeciality(doctor.getSpeciality());

            doctorOutputDtoList.add(doctorOutputDto);
        }

        return doctorOutputDtoList;
    }

}
