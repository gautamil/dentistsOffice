package com.example.dentistsOffice.model.DTO;

import com.example.dentistsOffice.model.Domicile;

import java.time.LocalDate;

public class PatientDTO {

    private Long id;
    private int dni;
    private String name;
    private String lastName;
    private Domicile address;
    private LocalDate discharge;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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

    public Domicile getAddress() {
        return address;
    }

    public void setAddress(Domicile address) {
        this.address = address;
    }

    public LocalDate getDischarge() {
        return discharge;
    }

    public void setDischarge(LocalDate discharge) {
        this.discharge = discharge;
    }
}
