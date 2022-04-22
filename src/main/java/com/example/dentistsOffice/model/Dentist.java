package com.example.dentistsOffice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "dentists")
@Getter
@Setter
public class Dentist {

    @Id
    @SequenceGenerator(name="dentist_sequence", sequenceName = "dentist_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dentist_sequence")
    private Long id;
    private Integer gmc;
    private String name;
    private String lastName;

    @OneToMany(mappedBy = "dentist")
    @JsonIgnore //siempre en relaciones otm
    private Set<Appointment> appointments;

    public Dentist() {
    }
}
