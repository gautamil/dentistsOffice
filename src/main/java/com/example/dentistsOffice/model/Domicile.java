package com.example.dentistsOffice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "domiciles")
@Getter
@Setter
public class Domicile {

    @Id
    @SequenceGenerator(name="address_sequence", sequenceName = "address_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence")
    private Long id;
    private String street;
    private Integer number;
    private String town;
    private String province;

    public Domicile() {
    }
}
