package com.example.dentistsOffice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@Getter
@Setter
public class Appointment {

    @Id
    @SequenceGenerator(name="appointment_sequence", sequenceName = "appointment_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_sequence")
    private Long id;
    private LocalDateTime dateTime;

    @ManyToOne //muchos turnos para un dentista
    @JoinColumn(name = "dentist_gmc", nullable = false)
    private Dentist dentist;

    @ManyToOne // muchos turnos para un paciente?
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    public Appointment(LocalDateTime dateTime, Dentist dentist, Patient patient) {
        this.dateTime = dateTime;
        this.dentist = dentist;
        this.patient = patient;
    }

    public Appointment() {
    }
}
