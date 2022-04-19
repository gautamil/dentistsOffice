package com.example.dentistsOffice.service.intface;

import com.example.dentistsOffice.model.DTO.PatientDTO;

import java.util.Set;

public interface IPatientService {
    void createPatient(PatientDTO patientDTO);
    PatientDTO readPatient(Long id);
    void editPatient(PatientDTO patientDTO);
    void removePatient(Long id);
    Set<PatientDTO> getPatients();
}
