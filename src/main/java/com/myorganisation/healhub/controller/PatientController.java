package com.myorganisation.healhub.controller;

import com.myorganisation.healhub.dto.PatientRequestDTO;
import com.myorganisation.healhub.dto.PatientResponseDTO;
import com.myorganisation.healhub.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> getPatient(@PathVariable Long id) {
        return new ResponseEntity<>(patientService.getPatient(id), HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients() {
        return new ResponseEntity<>(patientService.getAllPatients(), HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<PatientResponseDTO> addPatient(@RequestBody PatientRequestDTO patientRequestDTO) {
        return new ResponseEntity<>(patientService.addPatient(patientRequestDTO), HttpStatusCode.valueOf(201));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable Long id, @RequestBody PatientRequestDTO patientRequestDTO) {
        return new ResponseEntity<>(patientService.updatePatient(id, patientRequestDTO), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping
    public ResponseEntity<String> removePatient(@RequestParam Long id) {
        return new ResponseEntity<>(patientService.removePatient(id), HttpStatusCode.valueOf(200));
    }
}
