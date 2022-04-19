package com.example.dentistsOffice.service;

import com.example.dentistsOffice.model.DTO.DentistDTO;
import com.example.dentistsOffice.model.DTO.DomicileDTO;
import com.example.dentistsOffice.model.Dentist;
import com.example.dentistsOffice.repository.IDentistRepository;
import com.example.dentistsOffice.service.intface.IDentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DentistService implements IDentistService {

    @Autowired
    private IDentistRepository dentistRepository;

    @Autowired
    ObjectMapper mapper;

    public void saveDentist(DentistDTO dentistDTO) {
        Dentist dentist = mapper.convertValue(dentistDTO,Dentist.class);
        dentistRepository.save(dentist);
    }

    @Override
    public void createDentist(DentistDTO dentistDTO) {
        saveDentist(dentistDTO);
    }

    @Override
    public DentistDTO readDentist(Long id) {
        Optional<Dentist> dentist = dentistRepository.findById(id);
        DentistDTO dentistDTO = null;
        if(dentist.isPresent()){
            dentistDTO = mapper.convertValue(dentist, DentistDTO.class);
        }
        return dentistDTO;
    }

    @Override
    public void editDentist(DentistDTO dentistDTO) {
        saveDentist(dentistDTO);
    }

    @Override
    public void removeDentist(Long id) {
        dentistRepository.deleteById(id);
    }

    @Override
    public Set<DentistDTO> getDentists() {
        List<Dentist> dentists = dentistRepository.findAll();
        Set<DentistDTO> dentistsDTO = new HashSet<>();
        for(Dentist dentist : dentists){
            dentistsDTO.add(mapper.convertValue(dentist, DentistDTO.class));
        }
        return dentistsDTO;
    }
}
