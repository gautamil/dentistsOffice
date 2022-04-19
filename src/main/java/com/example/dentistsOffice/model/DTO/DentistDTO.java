package com.example.dentistsOffice.model.DTO;

public class DentistDTO {

    private Long id;
    private Integer gmc;
    private String name;
    private String lastName;

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
}
