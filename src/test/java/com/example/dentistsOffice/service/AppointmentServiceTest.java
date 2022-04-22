package com.example.dentistsOffice.service;

import org.springframework.beans.factory.annotation.Autowired;

class AppointmentServiceTest {

    @Autowired
    private PatientService patientService;
    @Autowired
    private DentistService dentistService;
    @Autowired
    private AppointmentService appointmentService;


}