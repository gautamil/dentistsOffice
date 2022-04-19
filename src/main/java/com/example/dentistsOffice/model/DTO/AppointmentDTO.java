package com.example.dentistsOffice.model.DTO;

import com.example.dentistsOffice.model.Dentist;
import com.example.dentistsOffice.model.Patient;

import java.time.LocalDateTime;

public class AppointmentDTO {

    private Long id;
    private LocalDateTime dateTime;
    private Dentist dentist;
    private Patient patient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
