package com.myorganisation.healhub.repository;

import com.myorganisation.healhub.entity.Doctor;
import com.myorganisation.healhub.enums.Gender;
import com.myorganisation.healhub.enums.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    //custom JPA method
    List<Doctor> findByGenderAndSpeciality(Gender gender, Speciality speciality);

    List<Doctor> findBySpeciality(Speciality speciality);
}
