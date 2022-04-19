package com.example.dentistsOffice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Dentists")
public class Dentist {

    @Id
    @GeneratedValue
    private Long id;
    private Integer gmc;
    private String name;
    private String lastName;

    @OneToMany(mappedBy = "dentist")
    @JsonIgnore //siempre en relaciones otm
    private Set<Appointment> appointments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGmc() {
        return gmc;
    }

    public void setGmc(Integer gmc) {
        this.gmc = gmc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }
}
