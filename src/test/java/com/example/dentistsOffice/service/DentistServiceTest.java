package com.example.dentistsOffice.service;

import com.example.dentistsOffice.model.DTO.DentistDTO;
import com.example.dentistsOffice.service.intface.IDentistService;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DentistServiceTest {
    @Autowired
    private IDentistService dentistService;

    @Test
    public void createDentistTest(){
        DentistDTO dentistDTO = new DentistDTO();
        dentistDTO.setName("Jorgito");
        dentistDTO.setLastName("Alfajor");
        dentistDTO.setGmc(42785);

        dentistService.createDentist(dentistDTO);

        DentistDTO alfajorDentist = dentistService.readDentist(1L);
        assertTrue(alfajorDentist != null);
    }

    @Test
    public void removeDentistTest(){
        dentistService.removeDentist(1L);
        assertTrue(dentistService.readDentist(1L) == null);
    }
}