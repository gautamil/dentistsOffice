package com.example.dentistsOffice.service;

import com.example.dentistsOffice.model.DTO.DomicileDTO;
import com.example.dentistsOffice.model.DTO.PatientDTO;
import com.example.dentistsOffice.model.Domicile;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class PatientServiceTest {

    private PatientService patientService;
    @Autowired
    public void setPatientService(PatientService patientService){
        this.patientService = patientService;
    }

    private DomicileService domicileService;
    @Autowired
    public void setDomicileService(DomicileService domicileService){
        this.domicileService = domicileService;
    }

    @Autowired
    ObjectMapper mapper;

    @Test
    void createAndReadPatientsTest(){

        DomicileDTO addressDTO1 = new DomicileDTO("streetName", 123, "townName", "provinceName");
        DomicileDTO createdAddressDTO1 = domicileService.createAddress(addressDTO1);

        PatientDTO patientDTO1 = new PatientDTO(25682505,"Name","Last Name", mapper.convertValue(createdAddressDTO1, Domicile.class), LocalDate.of(2021, 10, 29));
        patientService.createPatient(patientDTO1);

        DomicileDTO addressDTO2 = new DomicileDTO("streetName", 123, "townName", "provinceName");
        DomicileDTO createdAddressDTO2 = domicileService.createAddress(addressDTO2);

        PatientDTO patientDTO2 = new PatientDTO(36793616,"Name2","Last Name 2", mapper.convertValue(createdAddressDTO2, Domicile.class), LocalDate.of(2020, 9, 2));
        patientService.createPatient(patientDTO2);

        Assertions.assertNotNull(patientService.getPatients());
    }

}