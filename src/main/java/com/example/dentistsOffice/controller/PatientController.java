package com.example.dentistsOffice.controller;

import com.example.dentistsOffice.model.DTO.PatientDTO;
import com.example.dentistsOffice.service.intface.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    IPatientService patientService;

    @PostMapping
    public ResponseEntity<?> createPatient(@RequestBody PatientDTO patientDTO){
        patientService.createPatient(patientDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PatientDTO getPatient(@PathVariable Long id){
        return patientService.readPatient(id);
    }

    @PutMapping
    public ResponseEntity<?> editPatient(@RequestBody PatientDTO patientDTO){
        patientService.editPatient(patientDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removePatient(@PathVariable Long id){
        patientService.removePatient(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<PatientDTO> getAllPatients(){
        return patientService.getPatients();
    }
}
