package com.example.dentistsOffice.model.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomicileDTO {

    private Long id;
    private String street;
    private Integer number;
    private String town;
    private String province;

    public DomicileDTO(String street, Integer number, String town, String province) {
        this.street = street;
        this.number = number;
        this.town = town;
        this.province = province;
    }
}
