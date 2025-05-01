package com.myorganisation.healhub.controller;

import com.myorganisation.healhub.dto.DoctorRequestDTO;
import com.myorganisation.healhub.dto.DoctorResponseDTO;
import com.myorganisation.healhub.enums.Gender;
import com.myorganisation.healhub.enums.Speciality;
import com.myorganisation.healhub.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponseDTO> getDoctor(@PathVariable Long id) {
        return new ResponseEntity<>(doctorService.getDoctor(id), HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public ResponseEntity<List<DoctorResponseDTO>> getAllDoctors() {
        return new ResponseEntity<>(doctorService.getAllDoctors(), HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<DoctorResponseDTO> addDoctor(@RequestBody DoctorRequestDTO doctorRequestDTO) {
        return new ResponseEntity<>(doctorService.addDoctor(doctorRequestDTO), HttpStatusCode.valueOf(201));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorResponseDTO> updateDoctor(@PathVariable Long id, @RequestBody DoctorRequestDTO doctorRequestDTO) {
        return new ResponseEntity<>(doctorService.updateDoctor(id, doctorRequestDTO), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping
    public ResponseEntity<String> removeDoctor(@RequestParam Long id) {
        return new ResponseEntity<>(doctorService.removeDoctor(id), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/search/{gender}/{speciality}")
    public ResponseEntity<List<DoctorResponseDTO>> search(@PathVariable Gender gender, @PathVariable Speciality speciality) {
        return new ResponseEntity<>(doctorService.search(gender, speciality), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/search/{speciality}")
    public ResponseEntity<List<DoctorResponseDTO>> search(@PathVariable Speciality speciality) {
        return new ResponseEntity<>(doctorService.search(speciality), HttpStatusCode.valueOf(200));
    }
}
