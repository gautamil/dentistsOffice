package com.example.dentistsOffice.service.intface;

import com.example.dentistsOffice.model.DTO.DomicileDTO;

import java.util.Set;

public interface IDomicileService {
    //void createAddress(DomicileDTO domicileDTO);
    DomicileDTO readAddress(Long id);
    //void editAddress(DomicileDTO domicileDTO);
    //void removeAddress(Long id);
    Set<DomicileDTO> getAddresses();
}
