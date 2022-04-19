package com.example.dentistsOffice.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue
    private Long id; //este sí es autogenerado
    private LocalDateTime dateTime;

    @ManyToOne //muchos turnos para un dentista
    @JoinColumn(name = "dentist_gmc", nullable = false)
    private Dentist dentist;

    @ManyToOne // muchos turnos para un paciente?
    @JoinColumn(name = "patient_id", nullable = false)
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
