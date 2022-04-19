package com.example.dentistsOffice.service.intface;

import com.example.dentistsOffice.model.DTO.DentistDTO;

import java.util.Set;

public interface IDentistService {
    void createDentist(DentistDTO dentistDTO);
    DentistDTO readDentist(Long id); // las service van a ser usadas desde los controller, ye entre capas controller y service van los dto
    void editDentist(DentistDTO dentistDTO);
    void removeDentist(Long id);
    Set<DentistDTO> getDentists();
}
