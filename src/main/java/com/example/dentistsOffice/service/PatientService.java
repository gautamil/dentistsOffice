package com.example.dentistsOffice.service;

import com.example.dentistsOffice.model.DTO.PatientDTO;
import com.example.dentistsOffice.model.Patient;
import com.example.dentistsOffice.repository.IPatientRepository;
import com.example.dentistsOffice.service.intface.IPatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PatientService implements IPatientService {

    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    ObjectMapper mapper;

    public void savePatient(PatientDTO patientDTO) {
        Patient patient = mapper.convertValue(patientDTO,Patient.class);
        patientRepository.save(patient);
    }

    @Override
    public void createPatient(PatientDTO patientDTO) {
        savePatient(patientDTO);
    }

    @Override
    public PatientDTO readPatient(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        PatientDTO patientDTO = null;
        if(patient.isPresent()){
            patientDTO = mapper.convertValue(patientDTO, PatientDTO.class);
        }
        return patientDTO;
    }

    @Override
    public void editPatient(PatientDTO patientDTO) {
        savePatient(patientDTO);
    }

    @Override
    public void removePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public Set<PatientDTO> getPatients() {
        List<Patient> patients = patientRepository.findAll();
        Set<PatientDTO> patientsDTO = new HashSet<>();
        for(Patient patient : patients){
            patientsDTO.add(mapper.convertValue(patient, PatientDTO.class));
        }
        return patientsDTO;
    }
}
