package com.example.dentistsOffice.service;

import com.example.dentistsOffice.model.DTO.DomicileDTO;
import com.example.dentistsOffice.model.Domicile;
import com.example.dentistsOffice.repository.IDomicileRepository;
import com.example.dentistsOffice.service.intface.IDomicileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DomicileService implements IDomicileService {

    @Autowired
    private IDomicileRepository addressRepository;

    @Autowired
    ObjectMapper mapper;

    //public void saveAddress(DomicileDTO domicileDTO){
      //  Domicile domicile = mapper.convertValue(domicileDTO, Domicile.class);
        //addressRepository.save(domicile);
    //}

    //@Override
    //public void createAddress(DomicileDTO domicileDTO) {
        //saveAddress(domicileDTO);
    //}

    @Override
    public DomicileDTO readAddress(Long id) {
        Optional<Domicile> domicile = addressRepository.findById(id);
        DomicileDTO domicileDTO = null;
        if(domicile.isPresent()){
            domicileDTO = mapper.convertValue(domicile, DomicileDTO.class);
        }
        return domicileDTO;
    }

    //@Override
    //public void editAddress(DomicileDTO domicileDTO) {
      //saveAddress(domicileDTO);
    //}

    //@Override
    //public void removeAddress(Long id) {
      //  addressRepository.deleteById(id);
    //}

    @Override
    public Set<DomicileDTO> getAddresses() {
        List<Domicile> addresses = addressRepository.findAll();
        Set<DomicileDTO> addressesDTO = new HashSet<>();
        for(Domicile address : addresses){
            addressesDTO.add(mapper.convertValue(address, DomicileDTO.class));
        }
        return addressesDTO;
    }
}
