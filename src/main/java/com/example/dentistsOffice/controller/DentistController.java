package com.example.dentistsOffice.controller;

import com.example.dentistsOffice.model.DTO.DentistDTO;
import com.example.dentistsOffice.service.intface.IDentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/dentists")
public class DentistController {

    @Autowired
    IDentistService dentistService;

    @PostMapping
    public ResponseEntity<?> createDentist(@RequestBody DentistDTO dentistDTO){
        dentistService.createDentist(dentistDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public DentistDTO getDentist(@PathVariable Long id){
        return dentistService.readDentist(id);
    }

    @PutMapping
    public ResponseEntity<?> editDentist(@RequestBody DentistDTO dentistDTO){
        dentistService.editDentist(dentistDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeDentist(@PathVariable Long id){
        dentistService.removeDentist(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<DentistDTO> getAllDentists(){
        return dentistService.getDentists();
    }
}
